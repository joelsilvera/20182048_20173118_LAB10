package Daos;

import Beans.BeanUsuario;

import java.sql.*;
import java.util.ArrayList;

public class DaoUsuario extends DaoBase {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";
    public void crearUsuario(String codigo, String nombre, String apellido, String edad, String correo_pucp,
                             String especialidad, String contrasenia) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "insert into usuario(codigoPUCP,nombreUsuario,apellidoUsuario,edadUsuario,correoPUCP,especialidad,password)\n" +
                "values(?,?,?,?,?,?,sha2(?,256))";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, codigo);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setString(4, edad);
            pstmt.setString(5, correo_pucp);
            pstmt.setString(6, especialidad);
            pstmt.setString(7, contrasenia);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public BeanUsuario validarUsuarioPassword(String username, String password) {

        BeanUsuario beanUsuario = null;

        String sql = "select * from usuario where correoPUCP = ? and password = sha2(?,256);";

        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    beanUsuario = this.obtenerUsuario(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return beanUsuario;
    }
    public BeanUsuario obtenerUsuario(int codigoUsuario) {

        BeanUsuario usuario = null;
        ArrayList<BeanUsuario> listaUsuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario e WHERE codigoPucp = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, codigoUsuario);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    usuario = new BeanUsuario();
                    usuario.setCodigo_pucp(rs.getInt(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setApellidos(rs.getString(3));
                    usuario.setEdad(rs.getInt(4));
                    usuario.setCorreo_pucp(rs.getString(5));
                    usuario.setEspecialidad(rs.getString(6));


                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuario;
    }

}
