package negocio;

import datos.Conexion_DB;
import datos.DAO_Reporte;
import entidades.Reporte;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class ReporteNegocio {
    
    private String mensaje = "";
    private DAO_Reporte reporteDAO = new DAO_Reporte();
    
    public String agregarReporte(Reporte reporte){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = reporteDAO.agregarReporte(conn, reporte);
            
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
    
    public String editarReporte(Reporte reporte){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = reporteDAO.editarReporte(conn, reporte);
            
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
    
    public String eliminarReporte(int id){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = reporteDAO.eliminarReporte(conn, id);
            
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
    
    public void listarReporte(JTable tabla){
        
        Connection conn = Conexion_DB.getConexion();
        
        reporteDAO.listarReporte(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public int getMaxID(){

        Connection conn = Conexion_DB.getConexion();
        
        int id = reporteDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return id;
    }
    
}
