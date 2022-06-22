package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consultas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int registrar(GeneroVo genero) throws SQLException{
        sql="INSERT INTO Genero(nombreGenero,estadoGenero) values(?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el genero correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

        //cONSULTAR O LISTAR

    public List<GeneroVo> Consultar() throws SQLException{
        List<GeneroVo> genero=new ArrayList<>();
        sql="SELECT * FROM Genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                GeneroVo r=new GeneroVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdGenero(rs.getInt("idGenero"));
                r.setNombreGenero(rs.getString("nombreGenero"));
                r.setEstadoGenero(rs.getBoolean("estadoGenero"));
                genero.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return genero;
    }
    //Eliminar 
    public void eliminar (int idGenero) throws SQLException {
        sql="DELETE FROM Genero WHERE idGenero="+idGenero;
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
    public void estado(Boolean estadoGenero, int idGenero) throws SQLException {
        sql="UPDATE Genero SET estadoGenero= " +estadoGenero+ " WHERE idGenero= " +idGenero;
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoGenero+" correctamente");
        }catch(Exception e){
            System.out.println("Error no se puede cambiar el estado "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }

    //Editar
    public List<GeneroVo> editar(int idGenero) throws SQLException{
        List<GeneroVo> genero=new ArrayList<>();
        sql="SELECT * FROM Genero WHERE idGenero="+idGenero;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                GeneroVo r=new GeneroVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdGenero(rs.getInt("idGenero"));
                r.setNombreGenero(rs.getString("nombreGenero"));
                r.setEstadoGenero(rs.getBoolean("estadoGenero"));
                genero.add(r);
            }
            ps.close();
            System.out.println("edicion exitosa");
        } catch (Exception e) {
            System.out.println("La edicion no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return genero;
    }

    //Actualizar
    public int Actualizar (GeneroVo genero) throws SQLException {
        sql="UPDATE Genero SET nombreGenero=?, estadoGenero=? WHERE idGenero=?";
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            ps.setInt(3, genero.getIdGenero());

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
