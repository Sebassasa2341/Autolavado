package datos;

import entidades.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_Inventario {
    
    private String mensaje = "";
    
    public String agregarInventario(Connection conn, Inventario inventario){
            
        PreparedStatement ps = null;
        
        String consulta = "INSERT INTO inventario (nombre, fechaCompra, provedor, cantidad) VALUES (?, ?, ?, ?)";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, inventario.getNombre());
            ps.setString(2, inventario.getFechaCompra());
            ps.setString(3, inventario.getProvedor());
            ps.setString(4, inventario.getCantidad());
            
            mensaje = "GUARDADO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String editarInventario(Connection conn, Inventario inventario){
        
        PreparedStatement ps = null;
        
        String consulta = "UPDATE inventario SET nombre =?, fechaCompra = ?, provedor = ?, cantidad = ? WHERE idInventario = ?";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, inventario.getNombre());
            ps.setString(2, inventario.getFechaCompra());
            ps.setString(3, inventario.getProvedor());
            ps.setString(4, inventario.getCantidad());
            ps.setInt(5, inventario.getIdInventario());
            
            mensaje = "SE ACTUALIZO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String eliminarInventario(Connection conn, int id){
        
        PreparedStatement ps = null;
        
        String consulta = "DELETE FROM inventario WHERE idInventario = ?";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setInt(1, id);
            
            mensaje = "SE ELIMINO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO ELIMINAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public void listarInventario(Connection conn, JTable tabla){
        
        DefaultTableModel model;
        
        String [] columnas = {"ID", "Nombre", "Fecha de Compra", "Provedor", "Cantidad"};
        model = new DefaultTableModel(null, columnas);
        
        String consulta = ("SELECT * FROM inventario ORDER BY idInventario");
        
        String [] filas = new String[5];
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(consulta);
            while(rs.next()){
                for(int i = 0; i < 5; i++){
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
    
    public int getMaxID(Connection conn){
        int id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String consulta = "SELECT MAX(idInventario)+1 as id FROM inventario";
        
        try {
            ps = conn.prepareCall(consulta);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
        }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar id" + e.getMessage());
        }
        
        return id;
    }
    
}
