<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Logradouro"%>
<%@page import="br.com.fatec.controler.ControleLogradouro"%>

<%
    String idS = request.getParameter("ID");
    int id = Integer.parseInt(idS);
    String cod = request.getParameter("COD");
    String end = request.getParameter("END");
    String pbusca = request.getParameter("PBUSCA");

    Logradouro log = new Logradouro(id,cod,end);
    ControleLogradouro logCont = new ControleLogradouro();
    log = logCont.alteraLogradouro(log);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLogradouro.jsp?END=" + pbusca;
    response.sendRedirect(url);
%>