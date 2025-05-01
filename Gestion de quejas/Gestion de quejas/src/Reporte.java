
public class Reporte {

    private String usuario;
    private String descripcion;
    private String direccion;
    private String tipoReporte;
    private String estado;

    public Reporte(String usuario, String descripcion, String direccion, String tipoReporte, String estado) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.tipoReporte = tipoReporte;
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}