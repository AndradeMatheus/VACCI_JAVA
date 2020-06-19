<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.UsuarioPessoa"%>
<%@page import="br.com.fatec.controler.ControleUsuarioPessoa"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.controler.ControleUsuario"%>
<%@page import="br.com.fatec.bean.PessoaFisica"%>
<%@page import="br.com.fatec.controler.ControlePessoa"%>

<%
    ControleUsuario usuCont = new ControleUsuario();
    List<Usuario> usus = usuCont.listarTodosUsuario();

    ControlePessoa pesCont = new ControlePessoa();
    List<PessoaFisica> pess = pesCont.listarTodosPessoa();

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioPessoa usuPes = new UsuarioPessoa(id,0,0,"");
    ControleUsuarioPessoa usuPesCont = new ControleUsuarioPessoa();
    usuPes = usuPesCont.buscarUsuarioPessoa(usuPes);
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO PESSOA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - USUÁRIO PESSOA</h1>
        <form name="alterarUsuarioPessoa" action="validaAlterarRelacaoUsuarioPessoa.jsp" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <% if( usu.getId() == usuPes.getIdUsuario() ) { %>
                                        <option selected value="<%=usu.getId()%>"><%=usu.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=usu.getId()%>"><%=usu.getNome()%></option>
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
                                    <% if( pes.getIdPessoa()== usuPes.getIdPessoa() ) { %>
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
                        <td><input type="text" name="OBS" value="<%=usuPes.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=usuPes.getIdUsuPes()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>