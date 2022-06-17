<%-- 
    Document   : agregarCategoria
    Created on : 15 jun 2022, 19:33:53
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
        <title>Agregar categoría</title>
    </head>
    <body>
        <% out.println(cdao.getNavbar()); %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 50rem">
                <div>
                    <h3 class="text-center mt-3">Agregar nueva categoría</h3>
                </div>
                <div>
                    <div class="card-body">
                        <form action="../CategoriaServlet">
                            <div>
                                <input type="hidden" name="accion" id="accion" value="addCategoria">
                            </div>
                            <div class="mb-3">
                                <label for="txtNombreCategoria" class="form-label">Nombre del categoría</label>
                                <input type="text" class="form-control" id="txtNombreCategoria" name="txtNombreCategoria" >
                            </div>
                            <div class="mb-3">
                                <label for="txtDescripcionCategoria" class="form-label">Descripción del categoría</label>
                                <input type="text" class="form-control" id="txtDescripcionCategoria" name="txtDescripcionCategoria">
                            </div>

                            <div class="d-flex justify-content-between">
                                <button type="submit" class="btn btn-outline-dark">Nueva categoría</button>
                                <a href="listaCategoria.jsp" class="btn btn-outline-danger">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
