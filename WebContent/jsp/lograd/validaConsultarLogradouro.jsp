<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.Logradouro"%>
<%@page import="br.com.fatec.controler.ControleLogradouro"%>

<%
    String end = request.getParameter("END");
    Logradouro log = new Logradouro(0,"",end);
    ControleLogradouro logCont = new ControleLogradouro();
    List<Logradouro> logs = logCont.listaLogradouro(log);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + log.getEnd()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA LOGRADOURO</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Cod-Cep">Cod-Cep</th>
                  <th data-field="End">Endereco</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(logs.isEmpty())) { %>    
                <tbody>
                    <% for (Logradouro listaL : logs) { %>
                        <tr>
                            <td><%=listaL.getId()%></td>
                            <td><%=listaL.getCod()%></td>
                            <td><%=listaL.getEnd()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirLogradouro.jsp?<%=url + listaL.getId()%>">Excluir</a></td>
                                <td><a href="alterarLogradouro.jsp?<%=url + listaL.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>