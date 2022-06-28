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
}
