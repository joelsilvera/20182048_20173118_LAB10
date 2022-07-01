package Servlets;

import Beans.BeanDatosUtiles;
import Beans.BeanUsuario;
import Beans.BeanViaje;
import Daos.DaoPrincipal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletPrincipal", value = "/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "inicio" : request.getParameter("a");
        DaoPrincipal daoPrincipal = new DaoPrincipal();
        switch (action){
            case "inicio" -> {
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            }
            case "listarViajes" -> {

                //RECIBE USUARIO
                String codigoPucp = request.getParameter("id");

                //OBTIENE DATOS UTILES
                BeanDatosUtiles datosUtiles = daoPrincipal.obtenerDatosUtiles(codigoPucp);
                ArrayList<BeanViaje> listaViajes = daoPrincipal.listarViajes(codigoPucp);


                //ENVIA DATOS UTILES
                request.setAttribute("datosUtiles",datosUtiles);
                request.setAttribute("lista",listaViajes);
                RequestDispatcher view = request.getRequestDispatcher("/includes/listaDeViajes.jsp");
                view.forward(request, response);



            }
            case "borrarViaje" -> {
                String idViaje = request.getParameter("id1");
                String codigoPucp = request.getParameter("id2");
                daoPrincipal.borrarViaje(idViaje);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?a=listarViajes&id="+codigoPucp);
            }
            case "crearViaje" -> {
                String codigoPucp = request.getParameter("id");
                request.setAttribute("codigoPucp",codigoPucp);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("includes/nuevoViaje.jsp");
                requestDispatcher.forward(request, response);
            }
            case "editarViaje" -> {
                String idViaje = request.getParameter("id1");
                String codigoPucp = request.getParameter("id2");
                BeanViaje viaje = daoPrincipal.buscarViaje(idViaje);
                if (viaje != null) {
                    request.setAttribute("viaje", viaje);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("includes/editarViaje.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/index");
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DaoPrincipal daoPrincipal = new DaoPrincipal();

        String action = request.getParameter("a") == null ? "inicio" : request.getParameter("a");
        switch (action){
            case "buscarPorCiudad" -> {
                String codigoPucp = request.getParameter("id");
                String textoBuscar = request.getParameter("textoBuscar");
                try {
                    request.setAttribute("lista", daoPrincipal.buscarPorIdCiudad(codigoPucp,textoBuscar));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("includes/listaDeViajes.jsp");
                requestDispatcher.forward(request, response);
            }


            case "guardarViaje" -> {
                String codigoPucp = request.getParameter("id");
                String fechaViaje = request.getParameter("fechaViaje");
                String fechaReserva = request.getParameter("fechaReserva");
                String ciudadOrigen = request.getParameter("ciudadOrigen");
                String ciudadDestino = request.getParameter("ciudadDestino");
                String seguro = request.getParameter("seguro");
                String numBoletosStr = request.getParameter("numBoletos");
                String costoTotalStr = request.getParameter("costoTotal");

                try {
                    int numBoletos = Integer.parseInt(numBoletosStr);
                    double costoTotal = Double.parseDouble(costoTotalStr);

                    daoPrincipal.crearViaje(codigoPucp, fechaViaje, fechaReserva, ciudadOrigen, ciudadDestino, seguro, numBoletos, costoTotal);

                    response.sendRedirect(request.getContextPath() + "/ServletPrincipal?a=listarViajes&id="+codigoPucp);

                } catch (NumberFormatException e) {
                    System.out.println("error al parsear");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletPrincipal?a=listarViajes&id="+codigoPucp);
                    requestDispatcher.forward(request, response);
                }

            }
            case "actualizarViaje" -> {
                BeanViaje viaje = leerParametrosRequest(request);

                daoPrincipal.actualizarViaje(viaje);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?a=listarViajes&id="+viaje.getUsuario_codigoPucp());
            }


        }
    }

    public BeanViaje leerParametrosRequest(HttpServletRequest request) {
        String idViajes = request.getParameter("idViajes");
        String usuario_codigoPucp = request.getParameter("usuario_codigoPucp");
        String fechaViaje = request.getParameter("fechaViaje");
        String fechaReserva = request.getParameter("fechaReserva");
        String ciudadOrigen = request.getParameter("ciudadOrigen");
        String ciudadDestino = request.getParameter("ciudadDestino");
        String seguro = request.getParameter("seguro");
        String numBoletos = request.getParameter("numBoletos");
        String costoTotal = request.getParameter("costoTotal");

        BeanViaje viaje = new BeanViaje();
        viaje.setIdViajes(idViajes);
        viaje.setUsuario_codigoPucp(usuario_codigoPucp);
        viaje.setFechaViaje(fechaViaje);
        viaje.setFechaReserva(fechaReserva);
        viaje.setCiudadOrigen(ciudadOrigen);
        viaje.setCiudadDestino(ciudadDestino);
        viaje.setSeguro(seguro);
        viaje.setNumeroBoletos(Integer.parseInt(numBoletos));
        viaje.setCostoTotal(Double.parseDouble(costoTotal));
        return viaje;
    }
}
