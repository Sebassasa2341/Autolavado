package entidades;

public class Servicios {
    
    private int idServicios = 0;
    private String nombre = new String();
    private int precio = 0;
    private String descripcion = new String();

    public Servicios() {
    }
    
    public Servicios(int idServicio, String nombre, int precio, String descripcion){
        this.idServicios = idServicio;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicios{" + "idServicios=" + idServicios + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
