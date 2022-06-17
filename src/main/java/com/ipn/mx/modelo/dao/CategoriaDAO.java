package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.List;
import lombok.Data;

@Data

public class CategoriaDAO {

    //MYSQL
    
    private static final String SQL_CREATE = "insert into Categoria(nombreCategoria, descripcionCategoria) values (?, ?)";
//    private static final String SQL_UPDATE = "update Categoria set nombreCategoria = ?, descripcionCategoria = ? where idCategoria = ?";
//    private static final String SQL_DELETE = "delete from Categoria where idCategoria = ?";
//    private static final String SQL_READ = "select * from Categoria where idCategoria = ?";
//    private static final String SQL_READ_ALL = "select * from Categoria";
    
    
    //POSTGRESQL
    
//    private static final String SQL_CREATE = "insert into Categoria values (nombrecategoria = ?, descripcioncategoria = ?)";
    private static final String SQL_UPDATE = "update Categoria set nombrecategoria = ?, descripcioncategoria = ? where idcategoria = ?";
    private static final String SQL_DELETE = "delete from Categoria where idcategoria = ?";
    private static final String SQL_READ = "select * from Categoria where idcategoria = ?";
    private static final String SQL_READ_ALL = "select * from Categoria";

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
            + "                                <li><a class=\"dropdown-item\" href=\"../articulo/listaArticulo.jsp\">Ver artículos</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../articulo/agregarArticulo.jsp\">Añadir artículo</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Categoria\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"listaCategoria.jsp\">Ver categorias</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"agregarCategoria.jsp\">Añadir categoria</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                    </ul>\n"
            + "                </div>\n"
            + "            </div>\n"
            + "        </nav>";

    public CategoriaDAO() {
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

    public void create(CategoriaDTO dto) throws SQLException {
        getConnection();

        PreparedStatement ps = null;

        try {
            //Declaramos la sentencia SQL
            ps = conn.prepareStatement(SQL_CREATE);

            //Asignamos los valores para cada argumento,
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());

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

    public void update(CategoriaDTO dto) throws SQLException {
        getConnection();

        PreparedStatement ps = null;

        try {
            //Declaramos la sentencia SQL
            ps = conn.prepareStatement(SQL_UPDATE);

            //Asignamos los valores para cada argumento,
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.setInt(3, dto.getEntidad().getIdCategoria());

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

    public void delete(CategoriaDTO dto) throws SQLException {
        getConnection();

        //Creamos el objeto de la sentencia.
        PreparedStatement ps = null;

        try {
            //Guardamos la sentencia en el ps
            ps = conn.prepareStatement(SQL_DELETE);

            //Asignamos los valores
            ps.setInt(1, dto.getEntidad().getIdCategoria());

            //Ejecutamos la consulta
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public CategoriaDTO read(CategoriaDTO dto) throws SQLException {
        getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        List lista = null;
        try {
            ps = conn.prepareStatement(SQL_READ);

            ps.setInt(1, dto.getEntidad().getIdCategoria());

            rs = ps.executeQuery();

            lista = obtenerResultados(rs);

            if (!lista.isEmpty()) {
                return (CategoriaDTO) lista.get(0);
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
            CategoriaDTO dto = new CategoriaDTO();

            //Llenamos la instancia.
            dto.getEntidad().setIdCategoria(rs.getInt("idcategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombrecategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcioncategoria"));

            //Añadimos la instancia a la lista.
            resultados.add(dto);
        }

        return resultados;
    }

    public static void main(String[] args) throws SQLException {
        CategoriaDTO dto = new CategoriaDTO();
        CategoriaDAO dao = new CategoriaDAO();

        dto.getEntidad().setIdCategoria(1);

        List<CategoriaDTO> lista = dao.readAll();

        for (CategoriaDTO c : lista) {
            System.out.println("ENTIDAD: \n" + c.getEntidad().toString());
        }

//        System.out.println("ENTIDAD: \n" + dto.getEntidad().toString());
    }
}
