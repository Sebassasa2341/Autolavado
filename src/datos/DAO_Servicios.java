package datos;

import entidades.Servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_Servicios {
    
    private String mensaje = "";
    
    public String agregarServicio(Connection conn, Servicios servicio){
        
        PreparedStatement ps = null;
        
        String consulta = "INSERT INTO servicios (nombre, precio, descripcion) VALUES (?, ?, ?)";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, servicio.getNombre());
            ps.setInt(2, servicio.getPrecio());
            ps.setString(3, servicio.getDescripcion());
            
            mensaje = "GUARDADO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String editarServicio(Connection conn, Servicios servicio){
        
        PreparedStatement ps = null;
        
        String consulta = "UPDATE servicios SET nombre =?, precio = ?, descripcion = ? WHERE idServicios = ?";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, servicio.getNombre());
            ps.setInt(2, servicio.getPrecio());
            ps.setString(3, servicio.getDescripcion());
            ps.setInt(4, servicio.getIdServicios());
            
            mensaje = "SE ACTUALIZO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        
        return mensaje;
    }
    
    public String eliminarServicio(Connection conn, int id){
        
        PreparedStatement ps = null;
        
        String consulta = "DELETE FROM servicios WHERE idServicios = ?";
                                                                                                
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
    
    public void listarServicios(Connection conn, JTable tabla){
        
        DefaultTableModel model;
        
        String [] columnas = {"ID", "Nombre", "Precio", "Descripcion"};
        model = new DefaultTableModel(null, columnas);
        
        String consulta = ("SELECT * FROM servicios ORDER BY idServicios");
        
        String [] filas = new String[4];
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(consulta);
            while(rs.next()){
                for(int i = 0; i < 4; i++){
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
            String consulta = "SELECT MAX(idServicios)+1 as id FROM servicios";
        
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
    

