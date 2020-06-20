<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Funcionario"%>
<%@page import="br.com.fatec.controler.ControleFuncionario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String pbusca = request.getParameter("PBUSCA");

    Funcionario fun = new Funcionario(id,nome);
    ControleFuncionario funCont = new ControleFuncionario();
    fun = funCont.alteraFuncionario(fun);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarFuncionario.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>