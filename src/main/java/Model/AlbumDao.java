package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consultas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    //REGISTRAR O INSERTAR 

    public int registrar(AlbumVo Album) throws SQLException{
        sql="INSERT INTO Album(nombreAlbum,anioPublicacion,estadoALbum) values(?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, Album.getNombrealbum());
            ps.setString(2, Album.getAnioPublicacion());
            ps.setBoolean(3, Album.isEstadoAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el álbum correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

        //cONSULTAR O LISTAR

    public List<AlbumVo> Consultar() throws SQLException{
        List<AlbumVo> album=new ArrayList<>();
        sql="SELECT * FROM Album";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                AlbumVo r=new AlbumVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdAlbum(rs.getInt("idAlbum"));
                r.setNombrealbum(rs.getString("nombreAlbum"));
                r.setAnioPublicacion(rs.getString("anioPublicacion"));
                r.setEstadoAlbum(rs.getBoolean("estadoALbum"));
                album.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return album;
    }
    //estado
    public void estado(boolean estadoALbum, int idAlbum) throws SQLException {
        sql="UPDATE Album SET estadoALbum= " +estadoALbum+ " WHERE idAlbum= " +idAlbum;
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoALbum+" correctamente");
        }catch(Exception e){
            System.out.println("Error no se puede cambiar el estado "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }
    
    //eliminar
    public void eliminar(int idAlbum) throws SQLException {
        sql="DELETE FROM Album WHERE idAlbum="+idAlbum;
        try {
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino correctamente");
        }catch(Exception e){
            System.out.println("Error al eliminar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }{
    }


    }
}
