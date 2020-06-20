<%-- 
    Document   : validaConsultarDependente
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.Funcionario"%>
<%@page import="br.com.fatec.controler.ControleFuncionario"%>

<%
    String nome = request.getParameter("NOME");
    Funcionario fun = new Funcionario(0,nome);
    ControleFuncionario funCont = new ControleFuncionario();
    List<Funcionario> funcs = funCont.listaFuncionario(fun);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + fun.getNomeFunc() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA FUNCIONARIO</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(funcs.isEmpty())) { %>    
                <tbody>
                    <% for (Funcionario listaf : funcs) { %>
                        <tr>
                            <td><%=listaf.getIdFunc()%></td>
                            <td><%=listaf.getNomeFunc()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                              <td><a href="excluirFuncionario.jsp?<%=url + listaf.getIdFunc()%>">Excluir</a></td>
                              <td><a href="alterarFuncionario.jsp?<%=url + listaf.getIdFunc()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>