<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.PessoaLogradouro"%>
<%@page import="br.com.fatec.controler.ControlePessoaLogradouro"%>

<%
    String obs = request.getParameter("OBS");
    PessoaLogradouro peslog = new PessoaLogradouro(0,0,0,obs);
    ControlePessoaLogradouro logpescont = new ControlePessoaLogradouro();
    List<PessoaLogradouro> logpess = logpescont.listarPessoaLogradouro(peslog);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + peslog.getObs() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA PESSOA - LOG</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdUsuPessoa">Id</th>
                  <th data-field="IdPessoa">IdPessoa</th>
                  <th data-field="NomePessoa">NomePessoa</th>
                  <th data-field="IdLog">IdLog</th>
                  <th data-field="Cod">Cep</th>
                  <th data-field="End">End</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(logpess.isEmpty())) { %>    
                <tbody>
                    <% for (PessoaLogradouro listaPL : logpess) { %>
                        <tr>
                            <td><%=listaPL.getId()%></td>
                            <td><%=listaPL.getP().getIdPessoa()%></td>
                            <td><%=listaPL.getP().getNome()%></td>
                            <td><%=listaPL.getL().getId()%></td>
                            <td><%=listaPL.getL().getCod()%></td>
                            <td><%=listaPL.getL().getEnd()%></td>
                            <td><%=listaPL.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoPeslog.jsp?<%=url + listaPL.getId()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoPeslog.jsp?<%=url + listaPL.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>