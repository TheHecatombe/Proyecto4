<%-- 
    Document   : agregarArticulo
    Created on : 15 jun 2022, 17:00:30
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
        <title>Nuevo artículo</title>
    </head>
    <body>
        <% out.println(adao.getNavbar()); %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 50rem">
                <div>
                    <h3 class="text-center mt-3">Nuevo artículo</h3>
                </div>
                <div>
                    <div class="card-body">
                        <form action="../ArticuloServlet" method="post">
                            <div>
                                <input type="hidden" name="accion" id="accion" value="addArticulo">
                            </div>
                            <div class="mb-3">
                                <label for="txtNombreArticulo" class="form-label">Nombre del artículo</label>
                                <input type="text" class="form-control" id="txtNombreArticulo" name="txtNombreArticulo">
                            </div>
                            <div class="mb-3">
                                <label for="txtDescripcionArticulo" class="form-label">Descripción del artículo</label>
                                <input type="text" class="form-control" id="txtDescripcionArticulo" name="txtDescripcionArticulo">
                            </div>
                            <div class="mb-3">
                                <label for="txtPrecioArticulo" class="form-label">Precio por cada unidad</label>
                                <input type="number" class="form-control" id="txtPrecioArticulo" name="txtPrecioArticulo" min="0" step="0.01">
                            </div>
                            <div class="mb-3">
                                <label for="txtExistenciasArticulo" class="form-label">Cantidad de unidades disponibles</label>
                                <input type="number" class="form-control" id="txtExistenciasArticulo" name="txtExistenciasArticulo" step=1 min="0">
                            </div>
                            <div class="mb-3">
                                <label for="txtStockMinimo" class="form-label">Cantidad mínima de unidades en almacen</label>
                                <input type="number" class="form-control" id="txtStockMinimo" name="txtStockMinimo" step=1 min="0">
                            </div>
                            <div class="mb-3">
                                <label for="txtStockMaximo" class="form-label">Cantidad máxima de unidades en almacen</label>
                                <input type="number" class="form-control" id="txtStockMaximo" name="txtStockMaximo" step=1 min="0">
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="txtCategoria">Categoria: </label>
                                <select id="txtCategoria" class="form-select" name="txtCategoria">
                                    <%
                                        List<CategoriaDTO> categorias = cdao.readAll();
                                        
                                        for(CategoriaDTO cs : categorias){
                                    %>
                                    <option value="<%= cs.getEntidad().getIdCategoria()%>"><%= cs.getEntidad().getNombreCategoria()%></option>
                                    <%
                                        }
                                    %>
                                </select>

                            </div>

                            <div class="d-flex justify-content-between">
                                <button type="submit" class="btn btn-outline-dark">Agregar artículo</button>
                                <a href="listaArticulo.jsp" class="btn btn-outline-danger">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
