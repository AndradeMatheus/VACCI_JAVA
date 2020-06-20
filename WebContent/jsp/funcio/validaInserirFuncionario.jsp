<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Funcionario"%>
<%@page import="br.com.fatec.controler.ControleFuncionario"%>

<%
    String nome = request.getParameter("NOME");
    Funcionario fuc = new Funcionario(0,nome);
    ControleFuncionario funcont = new ControleFuncionario();
    fuc = funcont.inseriFuncionario(fuc);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirFuncionario.jsp";
    response.sendRedirect(url);
%>
