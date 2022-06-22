package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.GeneroDao;
import Model.GeneroVo;

public class generoController extends HttpServlet {
    GeneroVo gVo=new GeneroVo();
    GeneroDao gDao=new GeneroDao();
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "formularioGenero":
            registrar(req, resp);
            break;
            case "consultarGenero":
            Consultar(req, resp);
            break;
            case "editarGenero":
            Actualizar(req, resp);
            break;
            case "estadoG":
            estado(req, resp);
            break;
            case "eliminarGenero":
            eliminar(req, resp);
            break;
        }
    }
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Genero/addGenero.jsp").forward(req, resp);
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
            editarGenero(req,resp);
            break;
        }
    }
    private void registraradd(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreGenero")!=null){
            gVo.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            gVo.setEstadoGenero(true);
        }
        else{
            gVo.setEstadoGenero(false);
        }
        try {
            gDao.registrar(gVo);
            System.out.println("Registro insertado correctamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    private void editarGenero (HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            gVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        if(req.getParameter("nombreGenero")!=null){
            gVo.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            gVo.setEstadoGenero(true);
        }
        else{
            gVo.setEstadoGenero(false);
        }
        try {
            gDao.Actualizar(gVo);
            System.out.println("Se edito exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en editar "+e.getMessage().toString());
        }
    }
        
    
    //estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            gVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if(req.getParameter("estadoGenero")!=null){
            gVo.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        }
        try {
            gDao.estado(gVo.getEstadoGenero(), gVo.getIdGenero());
            System.out.println("El estado se cambio exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    private void Consultar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List generoList=gDao.Consultar();
            req.setAttribute("generos", generoList);
            req.getRequestDispatcher("views/Genero/listGenero.jsp").forward(req, resp);
            System.out.println("Datos Consultados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al Consultar los datos "+e.getMessage().toString());
        }
    }
     //eliminar
     private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            gVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        try {
            gDao.eliminar(gVo.getIdGenero());;
            System.out.println("El estado se cambio exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //actualizar
    private void Actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            gVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        try {
            List generoList=gDao.editar(gVo.getIdGenero());
            req.setAttribute("generoList", generoList);
            req.getRequestDispatcher("views/Genero/editGenero.jsp").forward(req, resp);
            System.out.println("Datos Consultados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al Consultar los datos "+e.getMessage().toString());
        }
    }
    
}


  
