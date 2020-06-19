<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.FuncionarioDependente"%>
<%@page import="br.com.fatec.controler.ControleFuncionarioDependente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    FuncionarioDependente funDep = new FuncionarioDependente(id,0,0,"");
    ControleFuncionarioDependente funDepCont = new ControleFuncionarioDependente();
    funDep = funDepCont.excluirFuncionarioDependente(funDep);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoFunDep.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>

