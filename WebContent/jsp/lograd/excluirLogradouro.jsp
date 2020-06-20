<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Logradouro"%>
<%@page import="br.com.fatec.controler.ControleLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Logradouro log = new Logradouro(id,"","");
    ControleLogradouro logCont = new ControleLogradouro();
    log = logCont.excluiLogradouro(log);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLogradouro.jsp?END=" + pbusca;
    response.sendRedirect(url);
%>