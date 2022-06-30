package Daos;

import Beans.BeanViaje;

import java.sql.*;
import java.util.ArrayList;

public class DaoPrincipal {

    public ArrayList<BeanViaje> listarViajes(String codigoPucp){
        ArrayList<BeanViaje> listaViajes = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String sql = "SELECT * FROM viajes WHERE usuario_codigoPucp = ?;";


        try (Connection conn = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, codigoPucp);

            try (ResultSet rs = pstmt.executeQuery();) {

                while (rs.next()) {
                    BeanViaje viaje = new BeanViaje();
                    viaje.setIdViajes(rs.getString(1));
                    viaje.setUsuario_codigoPucp(rs.getString(9));
                    viaje.setFechaViaje(rs.getString(2));
                    viaje.setFechaReserva(rs.getString(3));
                    viaje.setCiudadOrigen(rs.getString(4));
                    viaje.setCiudadDestino(rs.getString(5));
                    viaje.setSeguro(rs.getString(6));
                    viaje.setNumeroBoletos(rs.getInt(7));
                    viaje.setCostoTotal(rs.getDouble(8));
                    listaViajes.add(viaje);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaViajes;
    }


    public ArrayList<BeanViaje> buscarPorIdCiudad(String codigoPucp, String textoBuscar) throws SQLException {
        ArrayList<BeanViaje> listaViajes = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "SELECT * FROM viajes where (usuario_codigoPucp = ?  and \n" +
                "\t(lower(ciudadOrigen) like ? or lower(ciudadDestino) like ?) );";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, codigoPucp);
            preparedStatement.setString(2, "%" + textoBuscar.toLowerCase() + "%");
            preparedStatement.setString(3, "%" + textoBuscar.toLowerCase() + "%");

            try (ResultSet rs = preparedStatement.executeQuery();) {
                while (rs.next()) {
                    BeanViaje viaje = new BeanViaje();
                    viaje.setIdViajes(rs.getString(1));
                    viaje.setUsuario_codigoPucp(rs.getString(9));
                    viaje.setFechaViaje(rs.getString(2));
                    viaje.setFechaReserva(rs.getString(3));
                    viaje.setCiudadOrigen(rs.getString(4));
                    viaje.setCiudadDestino(rs.getString(5));
                    viaje.setSeguro(rs.getString(6));
                    viaje.setNumeroBoletos(rs.getInt(7));
                    viaje.setCostoTotal(rs.getDouble(8));
                    listaViajes.add(viaje);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaViajes;
    }


    public void borrarViaje(String codigo) {

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

            pstmt.setString(1, codigo);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void crearViaje(String codigoPucp, String fechaViaje, String fechaReserva, String ciudadOrigen, String ciudadDestino, String seguro, int numBoletos, double costoTotal) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "INSERT INTO viajes (idViajes, fechaViaje, fechaReserva, ciudadOrigen, " +
                "ciudadDestino, seguro, numeroBoletos, costoTotal, usuario_codigoPucp) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            int numeroRand = (int)(Math.random()*(99999999-10000001+1)+10000001);
            String numRandStr = String.valueOf(numeroRand);

            pstmt.setString(1, numRandStr);
            pstmt.setString(9, codigoPucp);
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

    public BeanViaje buscarViaje(String idViaje) {
        BeanViaje viaje = null;

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "select * from viajes where idViajes = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, idViaje);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    viaje = new BeanViaje();
                    viaje.setIdViajes(rs.getString(1));
                    viaje.setFechaViaje(rs.getString(2));
                    viaje.setFechaReserva(rs.getString(3));
                    viaje.setCiudadOrigen(rs.getString(4));
                    viaje.setCiudadDestino(rs.getString(5));
                    viaje.setSeguro(rs.getString(6));
                    viaje.setNumeroBoletos(rs.getInt(7));
                    viaje.setCostoTotal(rs.getDouble(8));
                    viaje.setUsuario_codigoPucp(rs.getString(9));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return viaje;
    }

    public void actualizarViaje(BeanViaje viaje) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab10?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE viajes SET fechaViaje = ?, fechaReserva = ?, ciudadOrigen = ?, " +
                "ciudadDestino = ?, seguro = ?, numeroBoletos = ?, costoTotal = ? where idViajes = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, viaje.getFechaViaje());
            pstmt.setString(2, viaje.getFechaReserva());
            pstmt.setString(3, viaje.getCiudadOrigen());
            pstmt.setString(4, viaje.getCiudadDestino());
            pstmt.setString(5, viaje.getSeguro());
            pstmt.setInt(6, viaje.getNumeroBoletos());
            pstmt.setDouble(7, viaje.getCostoTotal());
            pstmt.setString(8, viaje.getIdViajes());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
