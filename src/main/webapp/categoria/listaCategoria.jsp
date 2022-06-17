<%-- 
    Document   : listaCategoria
    Created on : 15 jun 2022, 19:33:16
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
        <title>Listado de categorías</title>
    </head>
    <body>
        <% out.println(cdao.getNavbar()); %>
        
        <h3 class="text-center mt-3">Listado de categorías</h3>
        
        <div class="d-flex justify-content-end" style="width: 95%">
            <a href="agregarCategoria.jsp" class="btn btn-outline-dark me-3">Nueva categoría</a>
        </div>
        
        <!--Creación de la tabla de categorias--> 
        <div class="d-flex justify-content-center">
            <table class="mt-3 table table-striped table-dark" style="width: 95%">
                <thead>
                    <tr>
                        <th scope="col">Identificador</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Descripción</th>
                        <th scope="col">Detalles</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        List<CategoriaDTO> categorias = cdao.readAll();
                    
                        if(categorias.size() > 0){
                            for(CategoriaDTO lc : categorias){
                    %>
                    <tr>
                        <td><%= lc.getEntidad().getIdCategoria()%></td>
                        <td><%= lc.getEntidad().getNombreCategoria()%></td>
                        <td><%= lc.getEntidad().getDescripcionCategoria()%></td>
                        <td><a href="detalleCategoria.jsp?id=<%= lc.getEntidad().getIdCategoria()%>" class="btn btn-outline-light">Detalles</a></td>
                        <td><a href="editarCategoria.jsp?id=<%= lc.getEntidad().getIdCategoria()%>" class="btn btn-outline-light">Editar</a></td>
                        <td><a href="../CategoriaServlet?accion=deleteCategoria&id=<%= lc.getEntidad().getIdCategoria()%>" class="btn btn-outline-light">Eliminar</a></td>
                    </tr>
                    <%
                            }
                    %>
                </tbody>
            </table>
                    <%
                        } else {

                    %>
                    
                    <p>No hay categorías registrados.</p>
                    
                    <%
                        }
                    %>
        </div>
    </body>
</html>
