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
                String id = request.getParameter("id");
                ArrayList<BeanViaje> listaViajes = daoPrincipal.listarViajes(Integer.parseInt(id));
                request.setAttribute("lista",listaViajes);
                RequestDispatcher view = request.getRequestDispatcher("/includes/listaDeViajes.jsp");
                view.forward(request, response);
            }
            case "borrarViaje" -> {
                String id1Str = request.getParameter("id1");
                String id2Str = request.getParameter("id2");
                int id1 = Integer.parseInt(id1Str);
                int id2 = Integer.parseInt(id2Str);
                daoPrincipal.borrarViaje(id1);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?a=listarViajes&id="+id2);
            }
            case "crearViaje" -> {
                String idStr = request.getParameter("id");
                request.setAttribute("idStr",idStr);
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
                String idStr = request.getParameter("id");
                int id = Integer.parseInt(idStr);
                String textoBuscar = request.getParameter("textoBuscar");
                try {
                    request.setAttribute("lista", daoPrincipal.buscarPorIdCiudad(id,textoBuscar));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("includes/listaDeViajes.jsp");
                requestDispatcher.forward(request, response);
            }


            case "guardarViaje" -> {
                String idStr = request.getParameter("id");
                String fechaViaje = request.getParameter("fechaViaje");
                String fechaReserva = request.getParameter("fechaReserva");
                String ciudadOrigen = request.getParameter("ciudadOrigen");
                String ciudadDestino = request.getParameter("ciudadDestino");
                String seguro = request.getParameter("seguro");
                String numBoletosStr = request.getParameter("numBoletos");
                String costoTotalStr = request.getParameter("costoTotal");

                try {
                    int id = Integer.parseInt(idStr);
                    int numBoletos = Integer.parseInt(numBoletosStr);
                    double costoTotal = Double.parseDouble(costoTotalStr);

                    daoPrincipal.crearViaje(id, fechaViaje, fechaReserva, ciudadOrigen, ciudadDestino, seguro, numBoletos, costoTotal);

                    response.sendRedirect(request.getContextPath() + "/ServletPrincipal?a=listarViajes&id="+id);

                } catch (NumberFormatException e) {
                    System.out.println("error al parsear");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                    requestDispatcher.forward(request, response);
                }

            }


        }
    }
}
