package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CancionDao;
import Model.CancionVo;

public class cancionController extends HttpServlet {

    CancionVo cVo=new CancionVo();
    CancionDao cDao=new CancionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "formularioCancion":
            registrar(req, resp);
            break;
            case "consultarCancion":
            Consultar(req, resp);
            break;
            case "editarCancion":
            Actualizar(req, resp);
            break;
            case "estadoCancion":
            estado(req, resp);
            break;
            case "eliminarCancion":
            eliminar(req, resp);
            break;

        }
    }
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Cancion/addCancion.jsp").forward(req, resp);
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
            case "Actualizar":
            editarCancion(req,resp);
            break;
        }
    }
    private void registraradd(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreCancion")!=null){
            cVo.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            cVo.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
            cVo.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            cVo.setEstadoCancion(true);
        }
        else{
            cVo.setEstadoCancion(false);
        }
        try {
            cDao.registrar(cVo);
            System.out.println("Registro insertado correctamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    private void editarCancion (HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            cVo.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        if(req.getParameter("fechaGrabacion")!=null){
            cVo.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
            cVo.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            cVo.setEstadoCancion(true);
        }
        else{
            cVo.setEstadoCancion(false);
        }
        try {
            cDao.Actualizar(cVo);
            System.out.println("Se edito exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en editar "+e.getMessage().toString());
        }
    }
        
    
    //estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            cVo.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        if(req.getParameter("estadoCancion")!=null){
            cVo.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));
        }
        try {
            cDao.estado(cVo.isEstadoCancion(), cVo.getIdCancion());
            System.out.println("El estado se cambio exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    private void Consultar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List cancionList=cDao.Consultar();
            req.setAttribute("Cancion", cancionList);
            req.getRequestDispatcher("views/Cancion/listCancion.jsp").forward(req, resp);
            System.out.println("Datos Consultados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al Consultar los datos "+e.getMessage().toString());
        }
    }
     //eliminar
     private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            cVo.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        try {
            cDao.eliminar(cVo.getIdCancion());;
            System.out.println("El estado se cambio exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //actualizar
    private void Actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            cVo.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        try {
            List cancionList=cDao.editar(cVo.getIdCancion());
            req.setAttribute("cancionList", cancionList);
            req.getRequestDispatcher("views/Cancion/editCancion.jsp").forward(req, resp);
            System.out.println("Datos Consultados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al Consultar los datos "+e.getMessage().toString());
        }
    }
    
}


  


