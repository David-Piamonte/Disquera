package Model;

public class CancionVo {
    private int idCancion;
    private String nombreCancion;
    private String fechaGrabacion;
    private String duracionCancion;
    private boolean estadoCancion;

    public CancionVo()
    {

    }

    public CancionVo(int idCancion, String nombreCancion, String fechaGrabacion, String duracionCancion,
            boolean estadoCancion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.fechaGrabacion = fechaGrabacion;
        this.duracionCancion = duracionCancion;
        this.estadoCancion = estadoCancion;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getFechaGrabacion() {
        return fechaGrabacion;
    }

    public void setFechaGrabacion(String fechaGrabacion) {
        this.fechaGrabacion = fechaGrabacion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public boolean isEstadoCancion() {
        return estadoCancion;
    }

    public void setEstadoCancion(boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }
    

    
    

    




   
    
}
