
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nuevo Usuario</title>
        <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="estilos_d.css">
    </head>
    <body>
        <main>
            <form class="formulario" id="formulario" method="POST" action="<%=request.getContextPath()%>/LoginServlet?a=p_validacion">
                <!-- Grupo: Usuario -->

                <!-- Grupo: Nombre -->
                <div class="formulario__grupo" id="grupo__nombre">
                    <label for="nombre" class="formulario__label">Nombre</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="nombre" id="nombre" placeholder="" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">El nombre solo puede contener letras y espacios.</p>
                </div>

                <div class="formulario__grupo" id="grupo__apellido">
                    <label for="apellido" class="formulario__label">Apellidos</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="apellido" id="apellido" placeholder="" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">El nombre solo puede contener letras y espacios.</p>
                </div>

                <!-- Grupo: Contraseña -->
                <div class="formulario__grupo" id="grupo__password">
                    <label for="password" class="formulario__label">Contraseña</label>
                    <div class="formulario__grupo-input">
                        <input type="password" class="formulario__input" name="password" id="password" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">La contraseña debe contar con una mayúscula, un número y un caracter especial</p>
                </div>

                <!-- Grupo: Contraseña 2 -->
                <div class="formulario__grupo" id="grupo__password2">
                    <label for="password2" class="formulario__label">Repetir Contraseña</label>
                    <div class="formulario__grupo-input">
                        <input type="password" class="formulario__input" name="password2" id="password2" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">Ambas contraseñas deben ser iguales.</p>
                </div>

                <!-- Grupo: Correo Electronico -->
                <div class="formulario__grupo" id="grupo__correo">
                    <label for="correo" class="formulario__label">Correo Electrónico</label>
                    <div class="formulario__grupo-input">
                        <input type="email" class="formulario__input" name="correo" id="correo" placeholder="" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">El correo solo puede contener letras, numeros, puntos, guiones y guion bajo.</p>
                </div>

                <!-- Grupo: Teléfono -->
                <div class="formulario__grupo" id="grupo__especialidad">
                    <label for="especialidad" class="formulario__label">Especialidad</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="especialidad" id="especialidad" placeholder="" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">El telefono solo puede contener 9 dígitos.</p>
                </div>
                <div class="formulario__grupo" id="grupo__edad">
                    <label for="edad" class="formulario__label">Edad</label>
                    <div class="formulario__grupo-input">
                        <input type="tel" class="formulario__input" name="edad" id="edad" maxlength="2" minlength="2" pattern="[0-9][0-9]" title="ingrese su edad" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">La edad no debe exceder los 29 años y ser mayor de edad.</p>

                </div>

                <div class="formulario__grupo" id="grupo__codigo">
                    <label for="codigo" class="formulario__label">Código PUCP</label>
                    <div class="formulario__grupo-input">
                        <input type="tel" class="formulario__input" name="codigo" id="codigo" maxlength="8" minlength="8" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]" title="ingrese su código PUCP" required>
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">El código PUCP solo puede contener números y el máximo son 8 dígitos.</p>

                </div>


                <div class="formulario__mensaje" id="formulario__mensaje">
                    <p><i class="fas fa-exclamation-triangle"></i> <b>Error:</b> Por favor rellena el formulario correctamente. </p>
                </div>

                <div class="formulario__grupo formulario__grupo-btn-enviar">
                    <button type="submit" class="formulario__btn">Enviar</button>
                    <p class="formulario__mensaje-exito" id="formulario__mensaje-exito">Formulario enviado exitosamente!</p>
                </div>
            </form>
        </main>

        <script src="js/formulario.js"></script>
        <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
    </body>
</html>
