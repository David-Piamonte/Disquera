package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.AlbumDao;
import Model.AlbumVo;

public class albumController extends HttpServlet {
    AlbumVo aVo=new AlbumVo();
    AlbumDao aDao=new AlbumDao();
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "formularioAlbum":
            registrar(req, resp);
            break;
            case "consultarAlbum":
            Consultar(req, resp);
            break;
            case "editarAlbum":
            editar(req, resp);
            break;
            case "estadoAlbum":
            estado(req, resp);
            break;
            case "eliminarAlbum":
            eliminar(req, resp);
            break;
        }
    }
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Album/addAlbum.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion=req.getParameter("accion");

        switch(accion){
            case "registraradd":
                registraradd(req,resp);
            break;
            case "Editar":
                editar(req,resp);
            break;
        }
    }
    private void registraradd(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreAlbum")!=null){
            aVo.setNombrealbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("anioPublicacion")!=null){
            aVo.setAnioPublicacion(req.getParameter("anioPublicacion"));
        }
        if(req.getParameter("estadoALbum")!=null){
            aVo.setEstadoAlbum(true);
        }
        else{
            aVo.setEstadoAlbum(false);
        }
        try {
            aDao.registrar(aVo);
            System.out.println("Registro insertado correctamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
        }
        if(req.getParameter("nombre")!=null){
            aVo.setNombrealbum(req.getParameter("nombre"));
        }
        if(req.getParameter("anioPublicacion")!=null){
            aVo.setAnioPublicacion(req.getParameter("anioPublicacion"));
        }
        if(req.getParameter("estado")!=null){
            aVo.setEstadoAlbum(true);
        }
        else{
            aVo.setEstadoAlbum(false);
        }
        
    }
    //estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        if(req.getParameter("estadoALbum")!=null){
            aVo.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoALbum")));
        }
        try {
            aDao.estado(aVo.isEstadoAlbum(), aVo.getIdAlbum());
            System.out.println("El estado se cambio exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    private void Consultar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List album=aDao.Consultar();
            req.setAttribute("album", album);
            req.getRequestDispatcher("views/Album/listAlbum.jsp").forward(req, resp);
            System.out.println("Datos Consultados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al Consultar los datos "+e.getMessage().toString());
        }
    }
     //eliminar
     private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        try {
            aDao.eliminar(aVo.getIdAlbum());;
            System.out.println("El estado se cambio exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    
}


  
