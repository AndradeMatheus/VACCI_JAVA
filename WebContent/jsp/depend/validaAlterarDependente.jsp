<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Dependente"%>
<%@page import="br.com.fatec.controler.ControleDependente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String pbusca = request.getParameter("PBUSCA");

    Dependente dep = new Dependente(id,nome);
    ControleDependente depCont = new ControleDependente();
    dep = depCont.alteraDependente(dep);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarDependente.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>