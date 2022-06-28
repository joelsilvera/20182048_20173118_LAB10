package Daos;

import Beans.BeanViaje;

import java.sql.*;
import java.util.ArrayList;

public class DaoPrincipal {

    public ArrayList<BeanViaje> listarViajes(int id){
        ArrayList<BeanViaje> listaViajes = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String sql = "SELECT * FROM viajes WHERE Usuario_idUsuarios = ?;";


        try (Connection conn = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery();) {

                while (rs.next()) {
                    BeanViaje viaje = new BeanViaje();
                    viaje.setIdViajes(rs.getInt(1));
                    viaje.setUsuario_idUsuario(rs.getInt(2));
                    viaje.setFechaViaje(rs.getString(3));
                    viaje.setFechaReserva(rs.getString(4));
                    viaje.setCiudadOrigen(rs.getString(5));
                    viaje.setCiudadDestino(rs.getString(6));
                    viaje.setSeguro(rs.getString(7));
                    viaje.setNumeroBoletos(rs.getInt(8));
                    viaje.setCostoTotal(rs.getDouble(9));
                    listaViajes.add(viaje);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaViajes;
    }


    public ArrayList<BeanViaje> buscarPorIdCiudad(int id, String textoBuscar) throws SQLException {
        ArrayList<BeanViaje> listaViajes = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "SELECT * FROM viajes where (Usuario_idUsuarios = ?  and \n" +
                "\t(lower(ciudadOrigen) like ? or lower(ciudadDestino) like ?) );";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, "%" + textoBuscar.toLowerCase() + "%");
            preparedStatement.setString(3, "%" + textoBuscar.toLowerCase() + "%");

            try (ResultSet rs = preparedStatement.executeQuery();) {
                while (rs.next()) {
                    BeanViaje viaje = new BeanViaje();
                    viaje.setIdViajes(rs.getInt(1));
                    viaje.setUsuario_idUsuario(rs.getInt(2));
                    viaje.setFechaViaje(rs.getString(3));
                    viaje.setFechaReserva(rs.getString(4));
                    viaje.setCiudadOrigen(rs.getString(5));
                    viaje.setCiudadDestino(rs.getString(6));
                    viaje.setSeguro(rs.getString(7));
                    viaje.setNumeroBoletos(rs.getInt(8));
                    viaje.setCostoTotal(rs.getDouble(9));
                    listaViajes.add(viaje);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaViajes;
    }


    public void borrarViaje(int id) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "delete from viajes where idViajes = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void crearViaje(int id, String fechaViaje, String fechaReserva, String ciudadOrigen, String ciudadDestino, String seguro, int numBoletos, double costoTotal) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "INSERT INTO viajes (idViajes, fechaViaje, fechaReserva, ciudadOrigen, " +
                "ciudadDestino, seguro, numeroBoletos, costoTotal) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            pstmt.setString(2, fechaViaje);
            pstmt.setString(3, fechaReserva);
            pstmt.setString(4, ciudadOrigen);
            pstmt.setString(5, ciudadDestino);
            pstmt.setString(6, seguro);
            pstmt.setInt(7, numBoletos);
            pstmt.setDouble(8, costoTotal);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
