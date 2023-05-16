package datos;

import entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_Empleado {
    
    private String mensaje = "";
    
    public String agregarEmpleado(Connection conn, Empleado empleado){
        
        PreparedStatement ps = null;
        
        String consulta = "INSERT INTO empleado (nombre, apellido, telefono) VALUES (?, ?, ?)";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getTelefono());
            mensaje = "GUARDADO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String editarEmpleado(Connection conn, Empleado empleado){
        
        PreparedStatement ps = null;
        
        String consulta = "UPDATE empleado SET nombre =?, apellido = ?, telefono = ? WHERE idEmpleado = ?";
                                                                                                
        try {
            ps = conn.prepareStatement(consulta);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getTelefono());
            ps.setInt(4, empleado.getIdEmpleado());
            
            mensaje = "SE ACTUALIZO CORRECTAMENTE";
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR CORRECTAMENTE \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String eliminarEmpleado(Connection conn, int id){
        
        PreparedStatement ps = null;
        
        String consulta = "DELETE FROM empleado WHERE idEmpleado = ?";
                                                                                                
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
    
    public void listarEmpleado(Connection conn, JTable tabla){
        
        DefaultTableModel model;
        String [] columnas = {"ID", "Nombre", "Apellido", "Telefono"};
        model = new DefaultTableModel(null, columnas);
        
        String consulta = ("SELECT * FROM empleado ORDER BY idEmpleado");
        
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
        String consulta = "SELECT MAX(idEmpleado)+1 as id FROM empleado";
        
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
