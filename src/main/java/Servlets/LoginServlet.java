package Servlets;

import Beans.BeanUsuario;
import Daos.DaoUsuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        RequestDispatcher view =request.getRequestDispatcher("Login.jsp");
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        DaoUsuario daoUsuario = new DaoUsuario();

        String codigo_pucp;
        String nombre;
        String apellido;
        String edad;
        String correo_pucp;
        String especialidad;
        String contrasenia;
        String contrasenha_confirmada;

        switch (action){
            case "p_validacion" ->{
                codigo_pucp = request.getParameter("codigo");
                nombre = request.getParameter("nombre");
                apellido = request.getParameter("apellido");
                edad = request.getParameter("edad");
                especialidad = request.getParameter("especialidad");
                correo_pucp = request.getParameter("correo");
                contrasenia = request.getParameter("password");



            }

        }

    }
}
