<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.PessoaLogradouro"%>
<%@page import="br.com.fatec.controler.ControlePessoaLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idLog = Integer.parseInt(request.getParameter("ID_LOG"));
    int idPessoa = Integer.parseInt(request.getParameter("ID_PESSOA"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    PessoaLogradouro logpes = new PessoaLogradouro(id,idPessoa,idLog,obs);
    ControlePessoaLogradouro logpescont = new ControlePessoaLogradouro();
    logpes = logpescont.alterarPessoaLogradouro(logpes);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoPeslog.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    