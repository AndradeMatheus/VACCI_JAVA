<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.controler.ControleUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id,"","","","","");
    ControleUsuario usuCont = new ControleUsuario();
    usu = usuCont.excluirUsuario(usu);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarUsuario.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>