<%-- 
    Document   : validaConsultarDependente
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.Dependente"%>
<%@page import="br.com.fatec.controler.ControleDependente"%>

<%
    String nome = request.getParameter("NOME");
    Dependente  dep = new Dependente(0,nome);
    ControleDependente depCont = new ControleDependente();
    List<Dependente> depends = depCont.listaDependente(dep);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + dep.getNomeDep() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA DEPENDENTE</title>
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
            <% if (!(depends.isEmpty())) { %>    
                <tbody>
                    <% for (Dependente listaDep : depends) { %>
                        <tr>
                            <td><%=listaDep.getIdDep()%></td>
                            <td><%=listaDep.getNomeDep()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                              <td><a href="excluirDependente.jsp?<%=url + listaDep.getIdDep()%>">Excluir</a></td>
                              <td><a href="alterarDependente.jsp?<%=url + listaDep.getIdDep()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>