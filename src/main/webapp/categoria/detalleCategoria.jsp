<%-- 
    Document   : detalleCategoria
    Created on : 15 jun 2022, 19:33:27
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.modelo.dao.*" %>
<%@page import="com.ipn.mx.modelo.dto.*" %>
<%@page import="com.ipn.mx.modelo.entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<%! ArticuloDAO adao = new ArticuloDAO(); %>
<%! ArticuloDTO adto = new ArticuloDTO(); %>
<%! CategoriaDAO cdao = new CategoriaDAO(); %>
<%! CategoriaDTO cdto = new CategoriaDTO(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Detalle categoría</title>
    </head>
    <body>
        <% out.println(cdao.getNavbar()); %>
        <% 
            cdto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));
            cdto = cdao.read(cdto);
        %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 20rem">
                <div class="card-header">
                    <h5 class="card-title">Detalles categoría</h5>
                    <p class="card-text"><%= cdto.getEntidad().getNombreCategoria()%></p>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Descripción: </b> <%= cdto.getEntidad().getDescripcionCategoria()%></li>
                    </ul>
                </div>
                <div class="card-body d-flex justify-content-between">
                    <a href="editarCategoria.jsp?id=<%= cdto.getEntidad().getIdCategoria()%>" class="btn btn-outline-dark">Editar</a>
                    <a href="../CategoriaServlet?accion=deleteCategoria&id=<%= cdto.getEntidad().getIdCategoria()%>" class="btn btn-outline-danger">Borrar</a>
                    <a href="listaCategoria.jsp" class="btn btn-outline-dark">Salir</a>
                </div>
            </div>
        </div>
    </body>
</html>
