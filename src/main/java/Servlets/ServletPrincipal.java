package Servlets;

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
                String codigoPucp = request.getParameter("id");
                ArrayList<BeanViaje> listaViajes = daoPrincipal.listarViajes(codigoPucp);
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
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                    requestDispatcher.forward(request, response);
                }

            }


        }
    }
}
