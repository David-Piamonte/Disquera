package Model;

public class AlbumVo {
    private int idAlbum;
    private String nombrealbum;
    private String anioPublicacion;
    private boolean estadoALbum;

    public AlbumVo()
    {

    }
   
    public AlbumVo(int idAlbum, String nombrealbum, String anioPublicacion, boolean estadoALbum) {
        this.idAlbum = idAlbum;
        this.nombrealbum = nombrealbum;
        this.anioPublicacion = anioPublicacion;
        this.estadoALbum = estadoALbum;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombrealbum() {
        return nombrealbum;
    }

    public void setNombrealbum(String nombrealbum) {
        this.nombrealbum = nombrealbum;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isEstadoAlbum() {
        return estadoALbum;
    }

    public void setEstadoAlbum(boolean estadoALbum) {
        this.estadoALbum = estadoALbum;
    }
}