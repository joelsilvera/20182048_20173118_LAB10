package Servlets;

import Beans.BeanViaje;
import Daos.DaoPrincipal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
