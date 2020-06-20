<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.PessoaFisica"%>
<%@page import="br.com.fatec.controler.ControlePessoa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    PessoaFisica pes = new PessoaFisica(id,"","","","");
    ControlePessoa pesCont = new ControlePessoa();
    pes = pesCont.buscarPessoa(pes);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - PESSOA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR PESSOA</h1>
        <form name="alterarUsuario" action="validaAlterarPessoa.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=pes.getNome()%>"> <br>
            Cpf: <input type="text" name="CPF" value="<%=pes.getCpf()%>"> <br>
            Tipo: <input type="text" name="TIPO" value="<%=pes.getTipo()%>"> <br>
            Email: <input type="text" name="EMAIL" value="<%=pes.getEmail()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=pes.getIdPessoa()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>