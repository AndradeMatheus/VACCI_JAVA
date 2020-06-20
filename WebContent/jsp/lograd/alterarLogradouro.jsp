<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Logradouro"%>
<%@page import="br.com.fatec.controler.ControleLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Logradouro log = new Logradouro(id,"","");
    ControleLogradouro logCont = new ControleLogradouro();
    log = logCont.buscaLogradouroPorId(log);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - LOGRADOURO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR LOGRADOURO</h1>
        <form name="alterarLOGRADOURO" action="validaAlterarLogradouro.jsp" method="post">
            Cod-Cep: <input type="text" name="COD" value="<%=log.getCod()%>"> <br>
            End: <input type="text" name="END" value="<%=log.getEnd()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=log.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>