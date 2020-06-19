<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Dependente"%>
<%@page import="br.com.fatec.controler.ControleDependente"%>

<%
    String nome = request.getParameter("NOME");
    Dependente dep = new Dependente(0,nome);
    ControleDependente depcont = new ControleDependente();
    dep = depcont.inseriDependente(dep);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirDependente.jsp";
    response.sendRedirect(url);
%>
