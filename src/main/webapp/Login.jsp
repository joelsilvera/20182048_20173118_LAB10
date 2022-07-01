<jsp:useBean id="indicador" scope="session" type="java.lang.String" class="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <!-- Importando estilos personalizados -->
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <title></title>
    </head>
    <body >
         <div class="form-login" style="margin:50px auto; width:500px;">

             <div class="login-container" style="margin-top: 3%;">
                 <div class="login-header">
                     <img src="logo.png"  style="width: 210px"  class="centrado" alt="...">

                 </div>

                 <form method="POST" action="<%=request.getContextPath()%>/LoginServlet">
                     <div class="mb-3" style="margin-top: 2%;">
                         <h1 style="color: white">Bienvenido televiajero</h1>
                     </div>


                     <input type="email" placeholder="Usuario" name="username" class="form-control">
                     <br>
                     <br>
                     <input type="password" placeholder="Contraseña" name="password" class="form-control">
                     <br>
                     <br>
                     <div class="btn-container">
                         <button type="submit" class="btn btn-outline-primary" >Ingresar</button>
                         <br>
                         <br>
                     </div>
                 </form>
                 <%if (session.getAttribute("indicador").equals("error")){%>
                 </br>
                 <div class="text-danger nb-2">
                     Error en usuario o contraseña!!!
                 </div>
                 <%session.removeAttribute("indicador");%>
                 <%}else if (session.getAttribute("indicador").equals("diferenteEspecialidad")){%>
                 <div class="text-danger nb-2">
                     No pertenece al teleco
                 </div>
                 <%session.removeAttribute("indicador");%>
                 <%}%>
                 <div class="register-details-container">
                     <a href="NuevoUsuario.jsp" class="btn-detail-register" style="color: rgb(8, 164, 247);">SOY NUEVO Y QUIERO REGISTRARME</a>
                 </div>
                 <br>
             </div>
         </div>

    </body>
</html>
