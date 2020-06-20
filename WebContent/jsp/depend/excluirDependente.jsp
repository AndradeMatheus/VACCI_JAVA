<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Dependente"%>
<%@page import="br.com.fatec.controler.ControleDependente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Dependente dep = new Dependente(id,"");
    ControleDependente depCont = new ControleDependente();
    dep = depCont.excluiDependente(dep);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarDependente.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>