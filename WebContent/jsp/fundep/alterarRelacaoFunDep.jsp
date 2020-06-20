<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.bean.Dependente"%>
<%@page import="br.com.fatec.controler.ControleDependente"%>
<%@page import="br.com.fatec.bean.Funcionario"%>
<%@page import="br.com.fatec.controler.ControleFuncionario"%>
<%@page import="br.com.fatec.bean.FuncionarioDependente"%>
<%@page import="br.com.fatec.controler.ControleFuncionarioDependente"%>

<%

    ControleFuncionario funCont = new ControleFuncionario();
    List<Funcionario> funs = funCont.listaTodos();

    ControleDependente depCont = new ControleDependente();
    List<Dependente> deps = depCont.listaTodos();

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    
    FuncionarioDependente funDep = new FuncionarioDependente(id,0,0,"");
    ControleFuncionarioDependente contFunDep = new ControleFuncionarioDependente();
    funDep = contFunDep.buscarFuncionarioDependentePorId(funDep);
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - FUN - DEP</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - FUN DEP</h1>
        <form name="alterarUsuarioPessoa" action="validaAlterarRelacaoFunDep.jsp" method="post">
            <table>
                <tr>
                    <td>Funcionario:</td>
                        <td>
                            <select NAME="ID_FUN" class="browser-default">
                                <% for (Funcionario fun : funs) { %>
                                <% if( fun.getIdFunc()== funDep.getIdFun()) { %>
                                        <option selected value="<%=fun.getIdFunc()%>"><%=fun.getNomeFunc()%></option>
                                    <% } else { %>
                                        <option value="<%=fun.getIdFunc()%>"><%=fun.getNomeFunc()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>Dependente:</td>
                        <td>
                            <select NAME ="ID_DEP" class="browser-default">
                                <% for (Dependente dep : deps) { %>
                                <% if( dep.getIdDep() == funDep.getIdDep()) { %>
                                        <option selected value="<%=dep.getIdDep()%>"><%=dep.getNomeDep()%></option>
                                    <% } else { %>
                                        <option value="<%=dep.getIdDep()%>"><%=dep.getNomeDep()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=funDep.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=funDep.getIdFunDep()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
