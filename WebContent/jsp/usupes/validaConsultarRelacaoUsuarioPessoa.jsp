<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.UsuarioPessoa"%>
<%@page import="br.com.fatec.controler.ControleUsuarioPessoa"%>

<%
    String obs = request.getParameter("OBS");
    UsuarioPessoa usupes = new UsuarioPessoa(0,0,0,obs);
    ControleUsuarioPessoa usupescont = new ControleUsuarioPessoa();
    List<UsuarioPessoa> usupess = usupescont.listarUsuarioPessoa(usupes);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usupes.getObs() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdUsuPessoa">Id</th>
                  <th data-field="IdPessoa">IdPessoa</th>
                  <th data-field="NomePessoa">NomePessoa</th>
                  <th data-field="IdUsuario">IdUsuario</th>
                  <th data-field="NomeUsuario">NomeUsuario</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(usupess.isEmpty())) { %>    
                <tbody>
                    <% for (UsuarioPessoa listaUsuarioPessoa : usupess) { %>
                        <tr>
                            <td><%=listaUsuarioPessoa.getIdUsuPes()%></td>
                            <td><%=listaUsuarioPessoa.getIdPessoa()%></td>
                            <td><%=listaUsuarioPessoa.getPes().getNome()%></td>
                            <td><%=listaUsuarioPessoa.getIdUsuario()%></td>
                            <td><%=listaUsuarioPessoa.getUsu().getNome()%></td>
                            <td><%=listaUsuarioPessoa.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoUsuarioPessoa.jsp?<%=url + listaUsuarioPessoa.getIdUsuPes()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoUsuarioPessoa.jsp?<%=url + listaUsuarioPessoa.getIdUsuPes()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>