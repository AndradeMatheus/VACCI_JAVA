<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Dependente"%>
<%@page import="br.com.fatec.controler.ControleDependente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Dependente dep = new Dependente(id,"");
    ControleDependente depCont = new ControleDependente();
    dep = depCont.buscaDependentePorId(dep);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - DEPENDENTE</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR DEPENDENTE</h1>
        <form name="alterarDependente" action="validaAlterarDependente.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=dep.getNomeDep()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=dep.getIdDep()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>