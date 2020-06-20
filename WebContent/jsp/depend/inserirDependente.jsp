<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - DEPENDENTE</title>
    <body>
       <div class="container"/>
        <h1>INSERIR DEPENDENTE</h1>
        <form name="inserirDependente" action="validaInserirDependente.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
