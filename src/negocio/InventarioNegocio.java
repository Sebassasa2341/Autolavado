package negocio;

import datos.Conexion_DB;
import datos.DAO_Inventario;
import entidades.Inventario;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class InventarioNegocio {
    
    private String mensaje = "";
    private DAO_Inventario inventarioDAO = new DAO_Inventario();
    
    public String agregarInventario(Inventario inventario){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = inventarioDAO.agregarInventario(conn, inventario);
            
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
    
    public String editarInventario(Inventario inventario){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = inventarioDAO.editarInventario(conn, inventario);
            
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
    
    public String eliminarInventario(int id){
        
        Connection conn = Conexion_DB.getConexion();
        
        try {
            mensaje = inventarioDAO.eliminarInventario(conn, id);
            
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
    
    public void listarInventario(JTable tabla){
        
        Connection conn = Conexion_DB.getConexion();
        
        inventarioDAO.listarInventario(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public int getMaxID(){

        Connection conn = Conexion_DB.getConexion();
        
        int id = inventarioDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return id;
    }
    
    
}
