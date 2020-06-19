<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.PessoaFisica"%>
<%@page import="br.com.fatec.controler.ControlePessoa"%>

<%
    String nome = request.getParameter("NOME");
    PessoaFisica  pe = new PessoaFisica(0,nome,"","","");
    ControlePessoa pescont = new ControlePessoa();
    List<PessoaFisica> pess = pescont.listarPessoa(pe);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + pe.getNome() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Login">Nome</th>
                  <th data-field="Cpf">Cpf</th>
                  <th data-field="Tipo">Tipo</th>
                  <th data-field="email">Email</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(pess.isEmpty())) { %>    
                <tbody>
                    <% for (PessoaFisica listaPessoas : pess) { %>
                        <tr>
                            <td><%=listaPessoas.getIdPessoa()%></td>
                            <td><%=listaPessoas.getNome()%></td>
                            <td><%=listaPessoas.getCpf()%></td>
                            <td><%=listaPessoas.getTipo()%></td>
                            <td><%=listaPessoas.getEmail()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirPessoa.jsp?<%=url + listaPessoas.getIdPessoa()%>">Excluir</a></td>
                                <td><a href="alterarPessoa.jsp?<%=url + listaPessoas.getIdPessoa()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>