<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Funcionario"%>
<%@page import="br.com.fatec.controler.ControleFuncionario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Funcionario fun = new Funcionario(id,"");
    ControleFuncionario funCont = new ControleFuncionario();
    fun = funCont.buscaFuncionarioPorId(fun);
    String pbusca = request.getParameter("PBUSCA");
%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - FUNCIONARIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR FUNCIONARIO</h1>
        <form name="alterarDependente" action="validaAlterarFuncionario.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=fun.getNomeFunc()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=fun.getIdFunc()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>