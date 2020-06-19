<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - FUNCIONARIO</title>
    <body>
       <div class="container"/>
        <h1>INSERIR FUNCIONARIO</h1>
        <form name="inserirFuncionario" action="validaInserirFuncionario.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
