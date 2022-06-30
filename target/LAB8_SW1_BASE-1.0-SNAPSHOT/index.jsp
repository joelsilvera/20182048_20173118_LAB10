<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%String codigoPucp = "20137525";%>
    <body>
        <div class='container'>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <a href="<%=request.getContextPath()%>/ServletPrincipal?a=listarViajes&id=<%=codigoPucp%>">Iniciar sesión de User 3</a>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
