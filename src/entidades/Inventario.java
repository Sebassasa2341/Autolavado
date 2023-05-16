package entidades;

public class Inventario {
    
    private int idInventario = 0;
    private String nombre = new String();
    private String fechaCompra = new String();
    private String provedor = new String();
    private String cantidad = new String();

    public Inventario() {
    }
    
    public Inventario(int idInventario, String nombre, String fechaCompra, String provedor, String cantidad){
        this.idInventario = idInventario;
        this.nombre = nombre;
        this.fechaCompra = fechaCompra;
        this.provedor = provedor;
        this.cantidad = cantidad;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Inventario{" + "idInventario=" + idInventario + ", nombre=" + nombre + ", fechaCompra=" + fechaCompra + ", provedor=" + provedor + ", cantidad=" + cantidad + '}';
    }
    
    
    
}
