package entidades;

public class Empleado {
    
    private int idEmpleado = 0;
    private String nombre = new String();
    private String apellido = new String();
    private String telefono = new String();

    public Empleado() {
        
    }
    
    public Empleado(int idEmpleado, String nombre, String apellido, String telefono){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int id) {
        this.idEmpleado = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + '}';
    }
    
    
            
    
}
