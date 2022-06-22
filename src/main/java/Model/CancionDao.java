package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CancionDao {

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consultas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int registrar(CancionVo Cancion) throws SQLException{
        sql="INSERT INTO Cancion(nombreCancion,fechaGrabacion,duracionCancion,estadoCancion) values(?,?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, Cancion.getNombreCancion());
            ps.setString(2, Cancion.getFechaGrabacion());
            ps.setString(3, Cancion.getDuracionCancion());
            ps.setBoolean(4, Cancion.isEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró la Cancion correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

        //cONSULTAR O LISTAR

    public List<CancionVo> Consultar() throws SQLException{
        List<CancionVo> Cancion=new ArrayList<>();
        sql="SELECT * FROM Cancion";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CancionVo r=new CancionVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdCancion(rs.getInt("idCancion"));
                r.setNombreCancion(rs.getString("nombreCancion"));
                r.setFechaGrabacion(rs.getString("fechaGrabacion"));
                r.setDuracionCancion(rs.getString("duracionCancion"));
                r.setEstadoCancion(rs.getBoolean("estadoCancion"));
                Cancion.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return Cancion;
    }
    //Eliminar 
    public void eliminar (int idCancion) throws SQLException {
        sql="DELETE FROM Cancion WHERE idCancion="+idCancion;
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
        }
    }
    //Estado
    public void estado(Boolean estadoCancion, int idCancion) throws SQLException {
        sql="UPDATE Cancion SET estadoCancion= " +estadoCancion+ " WHERE idCancion= " +idCancion;
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoCancion+" correctamente");
        }catch(Exception e){
            System.out.println("Error no se puede cambiar el estado "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }

    //Editar
    public List<CancionVo> editar(int idCancion) throws SQLException{
        List<CancionVo> Cancion=new ArrayList<>();
        sql="SELECT * FROM Cancion WHERE idCancion="+idCancion;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CancionVo r=new CancionVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdCancion(rs.getInt("idCancion"));
                r.setNombreCancion(rs.getString("nombreCancion"));
                r.setFechaGrabacion(rs.getString("fechaGrabacion"));
                r.setDuracionCancion(rs.getString("duracionCancion"));
                r.setEstadoCancion(rs.getBoolean("estadoCancion"));
                Cancion.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return Cancion;
    }

    //Actualizar
    public int Actualizar (CancionVo Cancion) throws SQLException {
        sql="UPDATE Cancion SET nombreCancion=?, fechaGrabacion=?, duracionCancion=?, estadoCancion=? WHERE idCancion=?";
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setInt(1, Cancion.getIdCancion());
            ps.setString(2, Cancion.getNombreCancion());
            ps.setString(3, Cancion.getFechaGrabacion());
            ps.setString(4, Cancion.getDuracionCancion());
            ps.setBoolean(5, Cancion.isEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito el Genero correctamente");

        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }
}
