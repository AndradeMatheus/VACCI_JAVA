<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.FuncionarioDependente"%>
<%@page import="br.com.fatec.controler.ControleFuncionarioDependente"%>

<%
    String obs = request.getParameter("OBS");
    FuncionarioDependente fundep = new FuncionarioDependente(0,0,0,obs);
    ControleFuncionarioDependente fundepcont = new ControleFuncionarioDependente();
    List<FuncionarioDependente> fundeps = fundepcont.listarFuncionarioDependente(fundep);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + fundep.getObs() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdFunDep">Id</th>
                  <th data-field="IdFun">IdFun</th>
                  <th data-field="NomeFun">NomeFun</th>
                  <th data-field="IdDep">IdDep</th>
                  <th data-field="NomeDep">NomeDep</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(fundeps.isEmpty())) { %>    
                <tbody>
                    <% for (FuncionarioDependente listFD : fundeps) { %>
                        <tr>
                            <td><%=listFD.getIdFunDep()%></td>
                            <td><%=listFD.getIdFun()%></td>
                            <td><%=listFD.getFun().getNomeFunc()%></td>
                            <td><%=listFD.getIdDep()%></td>
                            <td><%=listFD.getDep().getNomeDep()%></td>
                            <td><%=listFD.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoFunDep.jsp?<%=url + listFD.getIdFunDep()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoFunDep.jsp?<%=url + listFD.getIdFunDep()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>