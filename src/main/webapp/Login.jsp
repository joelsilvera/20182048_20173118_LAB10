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
         <div class="form-login">

             <div class="login-container" style="margin-top: 3%;">
                 <div class="login-header">
                     <img src="logo.png"  style="width: 150px"  class="rounded float-start" alt="...">

                 </div>
                 <br>
                 <br>
                 <br>
                 <br>
                 <br>
                 <br>
                 <form method="POST" action="<%=request.getContextPath()%>/LoginServlet">
                     <div class="mb-3" style="margin-top: 2%;">
                         <h1 style="color: white">Bienvenido televiajero</h1>
                     </div>


                     <input type="text" placeholder="Usuario" >
                     <br>
                     <br>
                     <input type="password" placeholder="Contraseña" >
                     <br>
                     <br>
                     <div class="btn-container">
                         <button type="submit" class="btn btn-outline-primary" >Ingresar</button>
                     </div>
                 </form>
                 <div class="register-details-container">
                     <p class="register" style="color:white;">¿No tienes una cuenta? Regístrate haciendo click</p>
                     <a href="NuevoUsuario.jsp" class="btn-detail-register" style="color: rgb(8, 164, 247);">AQUI</a>
                 </div>
             </div>
         </div>





    </body>
</html>
