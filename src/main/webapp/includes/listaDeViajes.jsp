<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.BeanViaje" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<BeanViaje> listaViajes = (ArrayList<BeanViaje>) request.getAttribute("lista");%>


<% int id=3;
    String nombre = "Josue";
    String apellido = "Lopez";
    double costoTotal = 1650;
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/airplaneshape_119680.ico" type="image/x-icon">
        <title>MIS VIAJES</title>
        <style>
            body {
                background-color: #131212
            }
            .container {
                padding-right: 0 !important;
                padding-left: 0 !important;
            }
            .titlecolor {
                background: linear-gradient(0deg, #1d1d1d 0%, #525252 100%);
            }
            .navbar {
                padding-left: 20px !important;
                padding-right: 20px !important;
                <%if(costoTotal<100){%>
                background-color: rgb(51 97 255 / 94%) !important;
                <%}else if(costoTotal<1000){%>
                background-color: rgb(145 151 169 / 94%) !important;
                <%}else if(costoTotal<10000){%>
                background-color: rgb(211 189 54 / 94%) !important;
                <%}else{%>
                background-color: rgb(4 4 4 / 94%) !important;
                <%}%>
            }
            .table-transparent {
                background-color: #343a4000 !important
            }
            .tabla {
                background-color: #1d1d1d;
                padding-left: 30px;
                padding-right: 30px;
            }
            thead {
                border-top: hidden;
                font-size: 14px;
            }
            .table td {
                padding: 0.5rem;
                font-weight: 500;
            }
            .table th {
                padding: 0.5rem;
                font-weight: 100;
            }

            .fila-red {
                background-color: #ba49498c;
            }

            .fila-blue {
                background-color: #2441ac8c;
            }

            .fila-purple {
                background-color: #a4219a8c;
            }

            .fila-yellow {
                background-color: #f0e01f91;
            }


        </style>

    </head>

    <body>
        <div class='container'>

            <!--ESTE ES EL NAVBAR -->

            <nav class="navbar sticky-top navbar-expand-lg navbar-dark">
                <a class="navbar-brand" href="<%=request.getContextPath()%>//ServletPrincipal?a=listarViajes&id=3">Mis viajes</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <%if(costoTotal<100){%>
                        <li class="nav-item"><h6>STATUS: NORMAL</h6></li>
                        <%}else if(costoTotal<1000){%>
                        <li class="nav-item"><h6>STATUS: SILVER</h6></li>
                        <%}else if(costoTotal<10000){%>
                        <li class="nav-item"><h6>STATUS: GOLD</h6></li>
                        <%}else{%>
                        <li class="nav-item"><h6>STATUS: PLATINUM</h6></li>
                        <%}%>
                    </ul>
                </div>
                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item"><h6>¡Bienvenido <%=nombre +  " " +apellido%> !</h6></li>
                    </ul>
                </div>
                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="navbar-brand" href="<%=request.getContextPath()%>/ServletPrincipal">Cerar Sesion</a></li>
                    </ul>
                </div>

            </nav>


            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>PROGRAMACION DE VIAJES</h1>
                </div>
            </div>
            <div class="tabla">
                <form method="post" action="<%=request.getContextPath()%>/ServletPrincipal?a=buscar">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Filtrar por "
                               aria-label="Filtrar por " aria-describedby="button-addon2"
                               name="textoBuscar" value="Ingrese texto" />
                        <button class="btn btn-warning" type="button" id="button-addon2">Filtrar</button>
                    </div>
                </form>

                <a class="btn btn-warning ms-auto">Agregar nuevo viaje</a>
                <p> </p>

                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>FECHA VIAJE</th>
                            <th>FECHA RESERVA</th>
                            <th>ORIGEN</th>
                            <th>DESTINO</th>
                            <th>SEGURO</th>
                            <th>CANT. BOLETOS</th>
                            <th>COSTO TOTAL</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%for (BeanViaje viaje : listaViajes){ %>
                        <tr>
                            <td><%=viaje.getFechaViaje()%></td>
                            <td><%=viaje.getFechaReserva()%></td>
                            <td><%=viaje.getCiudadOrigen()%></td>
                            <td><%=viaje.getCiudadDestino()%></td>
                            <td><%=viaje.getSeguro()%></td>
                            <td><%=viaje.getNumeroBoletos()%></td>
                            <td>S/<%=viaje.getCostoTotal()%></td>
                            <td><a class="btn btn-warning ms-auto">Editar</a></td>
                            <td><a class="btn btn-danger ms-auto">Eliminar</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>