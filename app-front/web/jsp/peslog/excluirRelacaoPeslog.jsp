<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.PessoaLogradouro"%>
<%@page import="br.com.fatec.controler.ControlePessoaLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    PessoaLogradouro logPes = new PessoaLogradouro(id,0,0,"");
    ControlePessoaLogradouro logPesCont = new ControlePessoaLogradouro();
    logPes = logPesCont.excluirPessoaLogradouro(logPes);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoPeslog.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>

