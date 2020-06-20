<%-- 
    Document   : consultaUsuario
    Created on : 25/08/2017, 19:48:39
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - LOGRADOURO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR LOGRADOURO</h1>
       <form name="consultarLOGRADOURO" action="validaConsultarLogradouro.jsp" method="post">
           END: <input type="text" name ="END" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
