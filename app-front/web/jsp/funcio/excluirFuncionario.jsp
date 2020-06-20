<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Funcionario"%>
<%@page import="br.com.fatec.controler.ControleFuncionario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Funcionario fun = new Funcionario(id,"");
    ControleFuncionario funCont = new ControleFuncionario();
    fun = funCont.excluiFuncionario(fun);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarFuncionario.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>