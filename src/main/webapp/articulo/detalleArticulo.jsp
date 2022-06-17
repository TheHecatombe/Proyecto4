<%-- 
    Document   : detalleArticulo
    Created on : 15 jun 2022, 18:41:12
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.modelo.dao.*" %>
<%@page import="com.ipn.mx.modelo.entidades.*" %>
<%@page import="com.ipn.mx.modelo.dto.*" %>
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
        <title>Detalles artículo</title>
    </head>
    <body>
        <% out.println(cdao.getNavbar()); %>
        <% 
            adto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("id")));
            adto = adao.read(adto);
        %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 20rem">
                <div class="card-header">
                    <h5 class="card-title">Detalles artículo</h5>
                    <p class="card-text"><%= adto.getEntidad().getNombreArticulo()%></p>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Descripción: </b> <%= adto.getEntidad().getDescripcionArticulo()%></li>
                        <li class="list-group-item"><b>Precio por unidad: </b> <%= adto.getEntidad().getPrecioUnitarioArticulo()%></li>
                        <li class="list-group-item"><b>Unidades disponibles: </b> <%= adto.getEntidad().getExitenciasArticulo()%></li>
                        <li class="list-group-item"><b>Unidades mínimas: </b> <%= adto.getEntidad().getStockMinimoArticulo()%></li>
                        <li class="list-group-item"><b>Unidades máximas: </b> <%= adto.getEntidad().getStockMaximoArticulo()%></li>
                        
                        <%
                        // Consultar la categoria.
                        
                        cdto.getEntidad().setIdCategoria(adto.getEntidad().getIdCategoria());
                        
                        cdto = cdao.read(cdto);
                        %>
                        
                        <li class="list-group-item"><b>Categoria: </b> <%= cdto.getEntidad().getNombreCategoria()%></li>
                    </ul>
                </div>
                <div class="card-body d-flex justify-content-between">
                    <a href="editarArticulo.jsp?id=<%= adto.getEntidad().getIdArticulo()%>" class="btn btn-outline-dark">Editar</a>
                    <a href="../ArticuloServlet?accion=deleteArticulo&id=<%= adto.getEntidad().getIdArticulo()%>" class="btn btn-outline-danger">Borrar</a>
                    <a href="listaArticulo.jsp" class="btn btn-outline-dark">Salir</a>
                </div>
            </div>
        </div>
    </body>
</html>
