<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Logradouro"%>
<%@page import="br.com.fatec.controler.ControleLogradouro"%>

<%
    String cod = request.getParameter("COD");
    String end = request.getParameter("END");
    Logradouro log = new Logradouro(0,cod,end);
    ControleLogradouro logCont = new ControleLogradouro();
    log = logCont.inseriLogradouro(log);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirLogradouro.jsp";
    response.sendRedirect(url);
%>
