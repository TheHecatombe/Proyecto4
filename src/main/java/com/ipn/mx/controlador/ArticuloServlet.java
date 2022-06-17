/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.ArticuloDAO;
import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.ArticuloDTO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonathan
 */
@WebServlet(name = "ArticuloServlet", urlPatterns = {"/ArticuloServlet"})
public class ArticuloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "addArticulo":
                addArticulo(request, response);
                break;
            case "updateArticulo":
                updateArticulo(request, response);
                break;
            case "deleteArticulo":
                deleteArticulo(request, response);
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addArticulo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        CategoriaDTO cdto = new CategoriaDTO();
        CategoriaDAO cdao = new CategoriaDAO();
        
        ArticuloDTO adto = new ArticuloDTO();
        ArticuloDAO adao = new ArticuloDAO();
        
        // Recuperamos la categoria.
        cdto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
        cdto = cdao.read(cdto);
        
        // Damos forma al articulo.
        
        adto.getEntidad().setNombreArticulo(request.getParameter("txtNombreArticulo"));
        adto.getEntidad().setDescripcionArticulo(request.getParameter("txtDescripcionArticulo"));
        adto.getEntidad().setPrecioUnitarioArticulo(Double.parseDouble(request.getParameter("txtPrecioArticulo")));
        adto.getEntidad().setExitenciasArticulo(Integer.parseInt(request.getParameter("txtExistenciasArticulo")));
        adto.getEntidad().setStockMinimoArticulo(Integer.parseInt(request.getParameter("txtStockMinimo")));
        adto.getEntidad().setStockMaximoArticulo(Integer.parseInt(request.getParameter("txtStockMaximo")));
        adto.getEntidad().setIdCategoria(cdto.getEntidad().getIdCategoria());
        
        adao.create(adto);
        
        response.sendRedirect("articulo/listaArticulo.jsp");
    }
    
    private void updateArticulo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        CategoriaDTO cdto = new CategoriaDTO();
        ArticuloDTO adto = new ArticuloDTO();
        
        CategoriaDAO cdao = new CategoriaDAO();
        ArticuloDAO adao = new ArticuloDAO();
        
        // Recuperamos la categoria.
        cdto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
        cdto = cdao.read(cdto);
        
        // Damos forma al articulo.
        
        adto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("idCategoria")));
        adto.getEntidad().setNombreArticulo(request.getParameter("txtNombreArticulo"));
        adto.getEntidad().setDescripcionArticulo(request.getParameter("txtDescripcionArticulo"));
        adto.getEntidad().setPrecioUnitarioArticulo(Double.parseDouble(request.getParameter("txtPrecioArticulo")));
        adto.getEntidad().setExitenciasArticulo(Integer.parseInt(request.getParameter("txtExistenciasArticulo")));
        adto.getEntidad().setStockMinimoArticulo(Integer.parseInt(request.getParameter("txtStockMinimo")));
        adto.getEntidad().setStockMaximoArticulo(Integer.parseInt(request.getParameter("txtStockMaximo")));
        adto.getEntidad().setIdCategoria(cdto.getEntidad().getIdCategoria());
        
        adao.update(adto);
        
        response.sendRedirect("articulo/listaArticulo.jsp");
    }

    private void deleteArticulo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        CategoriaDTO cdto = new CategoriaDTO();
        ArticuloDTO adto = new ArticuloDTO();
        
        CategoriaDAO cdao = new CategoriaDAO();
        ArticuloDAO adao = new ArticuloDAO();
        
        adto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("id")));
        
        adao.delete(adto);
        
        response.sendRedirect("articulo/listaArticulo.jsp");
    }
}
