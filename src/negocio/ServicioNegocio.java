package negocio;

import datos.Conexion_DB;
import datos.DAO_Servicios;
import entidades.Servicios;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class ServicioNegocio {
    
    private String mensaje = "";
    
    private DAO_Servicios serviciosDAO = new DAO_Servicios();
    
    public String agregarServicio(Servicios servicio){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = serviciosDAO.agregarServicio(conn, servicio);
            
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        
        return mensaje;
    }
    
    public String editarServicio(Servicios servicio){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = serviciosDAO.editarServicio(conn, servicio);
            
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        
        
        return mensaje;
    }
    
    public String eliminarServicio(int id){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = serviciosDAO.eliminarServicio(conn, id);
            
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        
        
        return mensaje;
    }
    
    public void listarServicios(JTable tabla){
        
        Connection conn = Conexion_DB.getConexion();
        
        serviciosDAO.listarServicios(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public int getMaxID(){

        Connection conn = Conexion_DB.getConexion();
        
        int id = serviciosDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return id;
    }
    
    
}
    

