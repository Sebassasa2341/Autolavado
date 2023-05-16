package negocio;

import datos.Conexion_DB;
import datos.DAO_Empleado;
import entidades.Empleado;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class EmpleadoNegocio {
    
    private String mensaje = "";
    private DAO_Empleado empleadoDAO = new DAO_Empleado();
    
    public String agregarEmpleado(Empleado empleado){
        
        Connection conn = Conexion_DB.getConexion();
        try {
            mensaje = empleadoDAO.agregarEmpleado(conn, empleado);
            
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
    
    public String editarEmpleado(Empleado empleado){
        
        Connection conn = Conexion_DB.getConexion();
        try {
            mensaje = empleadoDAO.editarEmpleado(conn, empleado);
            
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
    
    public String eliminarEmpleado(int id){
        
        Connection conn = Conexion_DB.getConexion();
        try {
            mensaje = empleadoDAO.eliminarEmpleado(conn, id);
            
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
    
    public void listarEmpleado(JTable tabla){
        Connection conn = Conexion_DB.getConexion();
        empleadoDAO.listarEmpleado(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){

        Connection conn = Conexion_DB.getConexion();
        int id = empleadoDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return id;
    }
    
}
