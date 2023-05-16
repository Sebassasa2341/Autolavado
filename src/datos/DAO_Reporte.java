package datos;

import entidades.Reporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_Reporte {
    
    private String mensaje = "";
    
    public String agregarReporte(Connection conn, Reporte reporte){
        
        PreparedStatement ps = null;
        
        String consulta = "INSERT INTO reporte (fechaHora, nombreCliente, vehiculo, nombreServicio) VALUES (?, ?, ?, ?)";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, reporte.getFechaHora());
            ps.setString(2, reporte.getNombreCliente());
            ps.setString(3, reporte.getVehiculo());
            ps.setString(4, reporte.getNombreServicio());
            
            mensaje = "GUARDADO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String editarReporte(Connection conn, Reporte reporte){
        
        PreparedStatement ps = null;
        
        String consulta = "UPDATE reporte SET fechaHora =?, nombreCliente = ?, vehiculo = ?, nombreServicio = ? WHERE idReporte = ?";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, reporte.getFechaHora());
            ps.setString(2, reporte.getNombreCliente());
            ps.setString(3, reporte.getVehiculo());
            ps.setString(4, reporte.getNombreServicio());
            ps.setInt(5, reporte.getIdReporte());
            
            mensaje = "SE ACTUALIZO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        
        return mensaje;
    }
    
    public String eliminarReporte(Connection conn, int id){
        
        PreparedStatement ps = null;
        
        String consulta = "DELETE FROM reporte WHERE idReporte = ?";
                                                                                                
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
    
    public void listarReporte(Connection conn, JTable tabla){
        
        DefaultTableModel model;
        
        String [] columnas = {"ID", "Fecha", "Nombre del Cliente", "Vehiculo", "Servicio"};
        model = new DefaultTableModel(null, columnas);
        
        String consulta = ("SELECT * FROM reporte ORDER BY idReporte");
        
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
            String consulta = "SELECT MAX(idReporte)+1 as id FROM reporte";
        
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
