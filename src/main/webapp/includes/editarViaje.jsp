<%@ page import="Beans.BeanViaje" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% BeanViaje viaje = (BeanViaje) request.getAttribute("viaje");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/airplaneshape_119680.ico" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <title>EDITAR VIAJE</title>
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
                background-color: rgb(51 97 255 / 94%) !important;
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
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">

                    <h1 class='mb-3' style="color:white;">Editar Viaje</h1>
                    <form method="POST" action="<%=request.getContextPath()%>/ServletPrincipal?a=actualizarViaje">

                        <input type="hidden" name="idViajes" value="<%=viaje.getIdViajes()%>"/>
                        <input type="hidden" name="usuario_codigoPucp" value="<%=viaje.getUsuario_codigoPucp()%>"/>
                        <div class="mb-3">
                            <label for="fechaViaje" class="form-label" style="color:white;">Fecha de viaje (AAAA-MM-DD)</label>
                            <input type="text" class="form-control" name="fechaViaje" id="fechaViaje" value="<%=viaje.getFechaViaje()%>">
                        </div>
                        <div class="mb-3">
                            <label for="fechaReserva" class="form-label" style="color:white;">Fecha de reserva (AAAA-MM-DD)</label>
                            <input type="text" class="form-control" name="fechaReserva" id="fechaReserva" value="<%=viaje.getFechaReserva()%>">
                        </div>
                        <div class="mb-3">
                            <label for="ciudadOrigen" class="form-label" style="color:white;">Ciudad de origen </label>
                            <input type="text" class="form-control" name="ciudadOrigen" id="ciudadOrigen" value="<%=viaje.getCiudadOrigen()%>">
                        </div>
                        <div class="mb-3">
                            <label for="ciudadDestino" class="form-label" style="color:white;">Ciudad Destino</label>
                            <input type="text" class="form-control" name="ciudadDestino" id="ciudadDestino" value="<%=viaje.getCiudadDestino()%>">
                        </div>
                        <div class="mb-3">
                            <label for="seguro" class="form-label" style="color:white;">Empresa de seguro</label>
                            <!--<input type="text" class="form-control" name="seguro" id="seguro" >-->
                            <select name="seguro" id="seguro" class="form-control">
                                <option value="Rimac" <%=viaje.getSeguro().equals("Rimac") ? "selected" : "" %>>Rimac</option>
                                <option value="Pacifico" <%=viaje.getSeguro().equals("Pacifico") ? "selected" : "" %>>Pacifico</option>
                                <option value="La Positiva" <%=viaje.getSeguro().equals("La Positiva") ? "selected" : "" %>>La Positiva</option>
                                <option value="Seguro Internacional" <%=viaje.getSeguro().equals("Seguro Internacional") ? "selected" : "" %>>Seguro Internacional</option>
                                <option value="Otro" <%=viaje.getSeguro().equals("Otro") ? "selected" : "" %>>Otro</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="numBoletos" class="form-label" style="color:white;">Numero de boletos</label>
                            <input type="text" class="form-control" name="numBoletos" id="numBoletos" value="<%=viaje.getNumeroBoletos()%>">
                        </div>
                        <div class="mb-3">
                            <label for="costoTotal" class="form-label" style="color:white;">Costo total</label>
                            <input type="text" class="form-control" name="costoTotal" id="costoTotal" value="<%=viaje.getCostoTotal()%>">
                        </div>
                        <a href="<%=request.getContextPath()%>/ServletPrincipal?a=listarViajes&id=<%=viaje.getUsuario_codigoPucp()%>" class="btn btn-danger">Regresar</a>
                        <button type="submit" class="btn btn-warning">Actualizar viaje</button>
                    </form>

                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>