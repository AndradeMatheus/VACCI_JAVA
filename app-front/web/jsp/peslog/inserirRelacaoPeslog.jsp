<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.bean.Logradouro"%>
<%@page import="br.com.fatec.bean.PessoaFisica"%>

<%@page import="br.com.fatec.controler.ControleLogradouro"%>
<%@page import="br.com.fatec.controler.ControlePessoa"%>

<%
    ControleLogradouro logCont = new ControleLogradouro();
    List<Logradouro> logs = logCont.listaTodos();

    ControlePessoa pesCont = new ControlePessoa();
    List<PessoaFisica> pess = pesCont.listarTodosPessoa();

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR PESSOA LOGRADOURO</title>
    <body>
        <div class="container"/>
            <h1>Inseri Pessoa Logradouro</h1>
            <form name="inseriLogPessoa" action="validaRelacaoPeslog.jsp" method="POST">
                <table>
                    <tr>
                        <td>Pessoa:</td>
                        <td>
                            <select NAME ="ID_PESSOA" class="browser-default">
                                <% for (PessoaFisica pes : pess) { %>
                                    <option value="<%=pes.getIdPessoa()%>"><%=pes.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Logradouro:</td>
                        <td>
                            <select NAME="ID_LOG" class="browser-default">
                                <% for (Logradouro log : logs) { %>
                                    <option value="<%=log.getId()%>"><%=log.getCod()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
