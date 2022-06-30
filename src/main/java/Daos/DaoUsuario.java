package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUsuario {
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

}
