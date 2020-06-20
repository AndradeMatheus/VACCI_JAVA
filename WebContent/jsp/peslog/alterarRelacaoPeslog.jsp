<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.bean.PessoaFisica"%>
<%@page import="br.com.fatec.bean.Logradouro"%>
<%@page import="br.com.fatec.bean.PessoaLogradouro"%>

<%@page import="br.com.fatec.controler.ControlePessoa"%>
<%@page import="br.com.fatec.controler.ControleLogradouro"%>
<%@page import="br.com.fatec.controler.ControlePessoaLogradouro"%>

<%
    ControleLogradouro logCont = new ControleLogradouro();
    List<Logradouro> logs = logCont.listaTodos();

    ControlePessoa pesCont = new ControlePessoa();
    List<PessoaFisica> pess = pesCont.listarTodosPessoa();

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    PessoaLogradouro logpes = new PessoaLogradouro(id,0,0,"");
    ControlePessoaLogradouro logPesCont = new ControlePessoaLogradouro();
    logpes = logPesCont.buscarPessoaLogradouroPorId(logpes);
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - LOGRADOURO PESSOA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - LOGRADOURO PESSOA</h1>
        <form name="alterarLogPessoa" action="validaAlterarPeslog.jsp" method="post">
            <table>
                <tr>
                    <td>LOGRADOURO:</td>
                        <td>
                            <select NAME="ID_LOG" class="browser-default">
                                <% for (Logradouro log : logs) { %>
                                <% if( log.getId() == logpes.getIdLog()) { %>
                                        <option selected value="<%=log.getId()%>"><%=log.getCod()%></option>
                                    <% } else { %>
                                    <option value="<%=log.getId()%>"><%=log.getCod()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>Pessoa:</td>
                        <td>
                            <select NAME ="ID_PESSOA" class="browser-default">
                                <% for (PessoaFisica pes : pess) { %>
                                    <% if( pes.getIdPessoa()== logpes.getIdPes() ) { %>
                                        <option selected value="<%=pes.getIdPessoa()%>"><%=pes.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=pes.getIdPessoa()%>"><%=pes.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=logpes.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=logpes.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>