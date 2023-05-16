package entidades;

public class Reporte {
    
    private int idReporte = 0;
    private String fechaHora = new String();
    private String nombreCliente = new String();
    private String vehiculo = new String();
    private String nombreServicio = new String();

    public Reporte() {
    }
    
    public Reporte(int idReporte, String fechaHora, String nombreCliente, String vehiculo, String nombreServicio){
        this.idReporte = idReporte;
        this.fechaHora = fechaHora;
        this.nombreCliente = nombreCliente;
        this.vehiculo = vehiculo;
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Reporte{" + "idReporte=" + idReporte + ", fechaHora=" + fechaHora + ", nombreCliente=" + nombreCliente + ", vehiculo=" + vehiculo + ", nombreServicio=" + nombreServicio + '}';
    }
    
}
