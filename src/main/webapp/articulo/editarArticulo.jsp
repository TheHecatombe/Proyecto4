<%-- 
    Document   : detalleArticulo
    Created on : 15 jun 2022, 17:50:06
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
        <title>Editar artículo</title>
    </head>
    <body>
        <% out.println(adao.getNavbar()); %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 50rem">
                <div>
                    <h3 class="text-center mt-3">Editar artículo</h3>
                </div>
                <div>
                    <% 
                        adto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("id")));
                        
                        adto = adao.read(adto);
                    %>
                    <div class="card-body">
                        <form action="../ArticuloServlet">
                            <div>
                                <input type="hidden" name="accion" id="accion" value="updateArticulo">
                                <input type="hidden" name="idCategoria" id="idCategoria" value="<%= adto.getEntidad().getIdArticulo()%>">
                            </div>
                            <div class="mb-3">
                                <label for="txtIdArticulo" class="form-label">Identificador del artículo</label>
                                <input type="text" class="form-control" id="txtIdArticulo" name="txtIdArticulo" 
                                       value="<%= adto.getEntidad().getIdArticulo()%>" disabled>
                            </div>
                            <div class="mb-3">
                                <label for="txtNombreArticulo" class="form-label">Nombre del artículo</label>
                                <input type="text" class="form-control" id="txtNombreArticulo" name="txtNombreArticulo" 
                                       value="<%= adto.getEntidad().getNombreArticulo()%>">
                            </div>
                            <div class="mb-3">
                                <label for="txtDescripcionArticulo" class="form-label">Descripción del artículo</label>
                                <input type="text" class="form-control" id="txtDescripcionArticulo" name="txtDescripcionArticulo"
                                       value="<%= adto.getEntidad().getDescripcionArticulo()%>">
                            </div>
                            <div class="mb-3">
                                <label for="txtPrecioArticulo" class="form-label">Precio por cada unidad</label>
                                <input type="number" class="form-control" id="txtPrecioArticulo" name="txtPrecioArticulo" min="0" step="0.01"
                                       value="<%= adto.getEntidad().getPrecioUnitarioArticulo()%>">
                            </div>
                            <div class="mb-3">
                                <label for="txtExistenciasArticulo" class="form-label">Cantidad de unidades disponibles</label>
                                <input type="number" class="form-control" id="txtExistenciasArticulo" name="txtExistenciasArticulo" step=1 min="0"
                                       value="<%= adto.getEntidad().getExitenciasArticulo()%>">
                            </div>
                            <div class="mb-3">
                                <label for="txtStockMinimo" class="form-label">Cantidad mínima de unidades en almacen</label>
                                <input type="number" class="form-control" id="txtStockMinimo" name="txtStockMinimo" step=1 min="0"
                                       value="<%= adto.getEntidad().getStockMinimoArticulo()%>">
                            </div>
                            <div class="mb-3">
                                <label for="txtStockMaximo" class="form-label">Cantidad máxima de unidades en almacen</label>
                                <input type="number" class="form-control" id="txtStockMaximo" name="txtStockMaximo" step=1 min="0"
                                       value="<%= adto.getEntidad().getStockMaximoArticulo()%>">
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="txtCategoria">Categoria: </label>
                                <select id="txtCategoria" class="form-select" name="txtCategoria">
                                    <%
                                        List<CategoriaDTO> categorias = cdao.readAll();
                                        
                                        //Consultar la actual categoria del articulo
                                        
                                        cdto.getEntidad().setIdCategoria(adto.getEntidad().getIdCategoria());
                                        cdto = cdao.read(cdto);
                                        
                                        for(CategoriaDTO cs : categorias){
                                            if(cs.getEntidad().getNombreCategoria().equals(cdto.getEntidad().getNombreCategoria())){
                                    %>
                                    <option value="<%= cs.getEntidad().getIdCategoria()%>" selected><%= cs.getEntidad().getNombreCategoria()%></option>
                                    <%
                                            }else{
                                    %>
                                    <option value="<%= cs.getEntidad().getIdCategoria()%>"><%= cs.getEntidad().getNombreCategoria()%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>

                            </div>

                            <div class="d-flex justify-content-between">
                                <button type="submit" class="btn btn-outline-dark">Editar artículo</button>
                                <a href="listaArticulo.jsp" class="btn btn-outline-danger">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
