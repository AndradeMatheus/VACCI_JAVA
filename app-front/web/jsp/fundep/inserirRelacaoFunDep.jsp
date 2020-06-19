<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.bean.Dependente"%>
<%@page import="br.com.fatec.controler.ControleDependente"%>
<%@page import="br.com.fatec.bean.Funcionario"%>
<%@page import="br.com.fatec.controler.ControleFuncionario"%>

<%
    ControleDependente depCont = new ControleDependente();
    List<Dependente> deps = depCont.listaTodos();

    ControleFuncionario funCont = new ControleFuncionario();
    List<Funcionario> funs = funCont.listaTodos();
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR FUNCIONARIO DEPENDENTE</title>
    <body>
        <div class="container"/>
            <h1>Inseri Funcionario Dependente</h1>
            <form name="inseriFunDep" action="validaRelacaoFunDep.jsp" method="POST">
                <table>
                    <tr>
                        <td>FUNCINARIO:</td>
                        <td>
                            <select NAME ="ID_FUN" class="browser-default">
                                <% for (Funcionario fun : funs) { %>
                                    <option value="<%=fun.getIdFunc()%>"><%=fun.getNomeFunc()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Dependente:</td>
                        <td>
                            <select NAME="ID_DEP" class="browser-default">
                                <% for (Dependente dep : deps) { %>
                                    <option value="<%=dep.getIdDep()%>"><%=dep.getNomeDep()%></option>
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
