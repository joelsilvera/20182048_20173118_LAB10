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
        String action = request.getParameter("a") != null ? request.getParameter("a") : "login";

        HttpSession session = request.getSession();

        switch (action){
            case "login":
                BeanUsuario usuario = (BeanUsuario) session.getAttribute("usuarioLogueado");
                if(usuario != null && usuario.getCodigo_pucp() != 0){
                    response.sendRedirect(request.getContextPath());
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                }
                break;
            case "logout":
                session.invalidate();
                response.sendRedirect(request.getContextPath());
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        DaoUsuario daoUsuario = new DaoUsuario();
        HttpSession session = request.getSession();

        String codigo_pucp;
        String nombre;
        String apellido;
        String edad;
        String correo_pucp;
        String especialidad;
        String contrasenia;

        switch (action){
            case "p_validacion" ->{
                codigo_pucp = request.getParameter("codigo");
                nombre = request.getParameter("nombre");
                apellido = request.getParameter("apellido");
                edad = request.getParameter("edad");
                especialidad = request.getParameter("especialidad");
                correo_pucp = request.getParameter("correo");
                contrasenia = request.getParameter("password");
                daoUsuario.crearUsuario(codigo_pucp, nombre,apellido,edad,correo_pucp,especialidad,contrasenia
                );
                response.sendRedirect(request.getContextPath() + "/LoginServlet");

            }
            case "listar" ->{
                String username = request.getParameter("username");
                String password = request.getParameter("password");


                BeanUsuario cuentaUsuario = daoUsuario.validarUsuarioPassword(username, password);
                if (cuentaUsuario != null) { //existe usuario y password
                    session.setAttribute("id", String.valueOf(cuentaUsuario.getCodigo_pucp()));
                    String id = String.valueOf(cuentaUsuario.getCodigo_pucp());
                    session.setMaxInactiveInterval(60 * 10);
                    response.sendRedirect(request.getContextPath() + "/ServletPrincipal?a=listarViajes&id="+id);

                } else {
                    session.setAttribute("indicador","error");
                    response.sendRedirect(request.getContextPath() + "/LoginServlet?error");
                }

            }

        }

    }
}
