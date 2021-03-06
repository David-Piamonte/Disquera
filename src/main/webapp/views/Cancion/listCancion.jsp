<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Disquera</title>
    <link rel="stylesheet" href="../../assets/css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>
    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Disquera S.A.S</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="index.jsp">INICIO</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                ARTISTA
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="artista?accion=formularioArtista">Registrar artista</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="artista?accion=consultarArtista">Consultar artista</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="artista?accion=editarArtista">Editar artista</a></li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                CANCI??N
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="cancion?accion=formularioCancion">Registrar canci??n</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="cancion?accion=consultarCancion">Consultar canci??n</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="cancion?accion=editarCancion">Editar canci??n</a></li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                ??LBUM
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="album?accion=formularioAlbum">Registrar ??lbum</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="album?accion=consultarAlbum">Consultar ??lbum</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="album?accion=editarAlbum">Editar ??lbum</a></li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                GENERO
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="genero?accion=formularioGenero">Registrar Genero</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="genero?accion=consultarGenero">Consultar Genero</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="genero?accion=editarGenero">Editar Genero</a></li>
              </ul>
            </li>

          </ul>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Buscar</button>
          </form>
        </div>
      </div>
    </nav>
      <h2>CONSULTAR CANCION</h2>
      
      <section class="tablas1">
        <table class="table">
        <thead>
            <tr>
              <th>ID</th>
              <th>NOMBRE</th>
              <th>FECHA GRABACION</th>
              <th>DURACION</th>
              <th>ACCIONES</th>
              <th>OPCIONES</th>
            </tr>
          </thead>
            <c:forEach var="Cancion" items="${Cancion}"> 
              <tr>
                <td>${Cancion.getIdCancion()}</td><!--ID-->
                <td>${Cancion.getNombreCancion()}</td><!--Nombre-->
                <td>${Cancion.getFechaGrabacion()}</td><!--fecha grabacion-->
                <td>${Cancion.getDuracionCancion()}</td><!--duracion cancion-->
                <c:if test="${Cancion.isEstadoCancion() == true}">
                  <td><span>Activo</span></td> 
                </c:if>
                <c:if test="${Cancion.isEstadoCancion() == false}">
                  <td><span>Inactivo</span></td> 
                </c:if>
                <c:if test="${Cancion.isEstadoCancion() == true}">
                    <td>
                      <a href="cancion?accion=estadoCancion&idGenero=${Cancion.getIdCancion()}&estadoCancion=false"><button type="button" class="btn btn-danger">Inactivar</button> </a>
                    </td> 
                </c:if>
                <c:if test="${Cancion.isEstadoCancion() == false}">
                  <td>
                    <a href="genero?accion=estadoCancion&idGenero=${Cancion.getIdCancion()}&estadoCancion=true"><button class="btn btn-success" type="button">Activar</button> </a>
                  </td> 
                </c:if>
                  <td>
                    <a href="cancion?accion=editarCancion&idCancion=${Cancion.getIdCancion()}"><button class="btn btn-outline-success" type="button">Editar</button> </a>
                                            
                    <a href="cancion?accion=eliminarCancion&idCancion=${Cancion.getIdCancion()}"><button class="btn btn-outline-danger" type="button">Eliminar</button> </a>
                  </td>
                </tr>
            </c:forEach>    
        </table>
      </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>