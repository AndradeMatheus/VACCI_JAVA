<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - LOGRADOURO</title>
    <body>
       <div class="container"/>
        <h1>INSERIR LOGRADOURO</h1>
        <form name="inserirLOGRADOURO" action="validaInserirLogradouro.jsp" method="post">
            Cod: <input type="text" name="COD" value=""> <br>
            End: <input type="text" name="END" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
