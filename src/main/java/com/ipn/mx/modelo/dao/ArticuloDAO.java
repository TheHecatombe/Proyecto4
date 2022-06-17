package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ArticuloDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;

@Data

public class ArticuloDAO {

    private static final String SQL_CREATE = "insert into Articulo(nombreArticulo, descripcionArticulo, precioUnitarioArticulo, existenciaArticulo, stockMinimoArticulo, stockMaximoArticulo, idCategoria) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Articulo set nombreArticulo = ?, descripcionArticulo = ?, precioUnitarioArticulo = ?, existenciaArticulo = ?, stockMinimoArticulo = ?, stockMaximoArticulo = ?, idCategoria = ? where idArticulo = ?";
    private static final String SQL_DELETE = "delete from Articulo where idArticulo = ?";
    private static final String SQL_READ = "select * from Articulo where idArticulo = ?";
    private static final String SQL_READ_ALL = "select * from Articulo";
    private Connection conn;

    private String navbar = "<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark d-flex justify-content-space-between\">\n"
            + "            <div class=\"container-fluid\">\n"
            + "                <a class=\"navbar-brand\" href=\"#\">Tienda ORM</a>\n"
            + "                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
            + "                    <span class=\"navbar-toggler-icon\"></span>\n"
            + "                </button>\n"
            + "                <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n"
            + "                    <ul class=\"navbar-nav\">\n"
            + "                        <li class=\"nav-item\">\n"
            + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"../index.jsp\">Inicio</a>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Artículos\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"listaArticulo.jsp\">Ver artículos</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"agregarArticulo.jsp\">Añadir artículo</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Categoria\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../categoria/listaCategoria.jsp\">Ver categorias</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../categoria/agregarCategoria.jsp\">Añadir categoria</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                    </ul>\n"
            + "                </div>\n"
            + "            </div>\n"
            + "        </nav>";

    public ArticuloDAO() {
    }

    public Connection getConnection() {
//        MYSQL
        
//        String url = "jdbc:mysql://localhost:3306/ProyectoBase4";
//        String usuario = "admin";
//        String password = "12345";
//        String driverDB = "com.mysql.cj.jdbc.Driver";

//        POSTGRESQL

        String url = "jdbc:postgresql://ec2-23-23-182-238.compute-1.amazonaws.com:5432/dccmdnsatad59j";
        String usuario = "oscsvffynoijni";
        String password = "f9f86ae035bfb6ba1f3e9ce57227329918898a45d7522b357e4ce119c685ba0c";
        String driverDB = "org.postgresql.Driver";
        try {
            Class.forName(driverDB);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void create(ArticuloDTO dto) throws SQLException {
        getConnection();

        PreparedStatement ps = null;

        try {
            //Declaramos la sentencia SQL
            ps = conn.prepareStatement(SQL_CREATE);

            //Asignamos los valores para cada argumento,
            ps.setString(1, dto.getEntidad().getNombreArticulo());
            ps.setString(2, dto.getEntidad().getDescripcionArticulo());
            ps.setDouble(3, dto.getEntidad().getPrecioUnitarioArticulo());
            ps.setInt(4, dto.getEntidad().getExitenciasArticulo());
            ps.setInt(5, dto.getEntidad().getStockMinimoArticulo());
            ps.setInt(6, dto.getEntidad().getStockMaximoArticulo());
            ps.setInt(7, dto.getEntidad().getIdCategoria());

            //Ejecutamos la consulta.
            ps.executeUpdate();

        } finally {
            //Cerramos el objeto de la sentencia.
            if (ps != null) {
                ps.close();
            }

            //Cerramos la conexión.
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void update(ArticuloDTO dto) throws SQLException {
        getConnection();

        PreparedStatement ps = null;

        try {
            //Declaramos la sentencia SQL
            ps = conn.prepareStatement(SQL_UPDATE);

            //Asignamos los valores para cada argumento,
            ps.setString(1, dto.getEntidad().getNombreArticulo());
            ps.setString(2, dto.getEntidad().getDescripcionArticulo());
            ps.setDouble(3, dto.getEntidad().getPrecioUnitarioArticulo());
            ps.setInt(4, dto.getEntidad().getExitenciasArticulo());
            ps.setInt(5, dto.getEntidad().getStockMinimoArticulo());
            ps.setInt(6, dto.getEntidad().getStockMaximoArticulo());
            ps.setInt(7, dto.getEntidad().getIdCategoria());
            ps.setInt(8, dto.getEntidad().getIdArticulo());

            //Ejecutamos la consulta.
            ps.executeUpdate();

        } finally {
            //Cerramos el objeto de la sentencia.
            if (ps != null) {
                ps.close();
            }

            //Cerramos la conexión.
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete(ArticuloDTO dto) throws SQLException {
        getConnection();

        PreparedStatement ps = null;

        try {
            //Declaramos la sentencia SQL
            ps = conn.prepareStatement(SQL_DELETE);

            //Asignamos los valores para cada argumento,
            ps.setInt(1, dto.getEntidad().getIdArticulo());

            //Ejecutamos la consulta.
            ps.executeUpdate();

        } finally {
            //Cerramos el objeto de la sentencia.
            if (ps != null) {
                ps.close();
            }

            //Cerramos la conexión.
            if (conn != null) {
                conn.close();
            }
        }
    }

    public ArticuloDTO read(ArticuloDTO dto) throws SQLException {
        getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        List lista = null;
        try {
            ps = conn.prepareStatement(SQL_READ);

            ps.setInt(1, dto.getEntidad().getIdArticulo());

            rs = ps.executeQuery();

            lista = obtenerResultados(rs);

            if (!lista.isEmpty()) {
                return (ArticuloDTO) lista.get(0);
            } else {
                return null;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public List readAll() throws SQLException {
        //Obtener conexión
        getConnection();

        //Creamos el SP
        PreparedStatement ps = null;

        //Se crea un ResultSet para guardar los valores de la consulta.
        ResultSet rs = null;

        //Lista con los resultados
        List lista = null;

        try {
            //Sentencia de consulta
            ps = conn.prepareStatement(SQL_READ_ALL);

            //Ejecutamos la consulta
            rs = ps.executeQuery();

            //Procesamos los resultados de la consulta y lo guardamos en la lista.
            lista = obtenerResultados(rs);

            //Verificamos que la lista tenga datos.
            if (!lista.isEmpty()) {
                return lista;
            } else {
                return null;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }
    
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();

        while (rs.next()) {
            ArticuloDTO dto = new ArticuloDTO();

            //Llenamos la instancia.
            dto.getEntidad().setIdArticulo(rs.getInt("idArticulo"));
            dto.getEntidad().setNombreArticulo(rs.getString("nombreArticulo"));
            dto.getEntidad().setDescripcionArticulo(rs.getString("descripcionArticulo"));
            dto.getEntidad().setPrecioUnitarioArticulo(rs.getDouble("precioUnitarioArticulo"));
            dto.getEntidad().setExitenciasArticulo(rs.getInt("existenciaArticulo"));
            dto.getEntidad().setStockMinimoArticulo(rs.getInt("stockMinimoArticulo"));
            dto.getEntidad().setStockMaximoArticulo(rs.getInt("stockMaximoArticulo"));
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            

            //Añadimos la instancia a la lista.
            resultados.add(dto);
        }

        return resultados;
    }
}
