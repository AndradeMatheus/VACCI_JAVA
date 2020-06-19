<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.PessoaLogradouro"%>
<%@page import="br.com.fatec.controler.ControlePessoaLogradouro"%>

<%
    int idLog = Integer.parseInt(request.getParameter("ID_LOG"));
    int idPessoa = Integer.parseInt(request.getParameter("ID_PESSOA"));
    String obs = request.getParameter("OBS");
    
    PessoaLogradouro logpes = new PessoaLogradouro(0,idLog,idPessoa,obs);
    ControlePessoaLogradouro logpescont = new ControlePessoaLogradouro();
    logpes = logpescont.inserirPessoaLogradouro(logpes);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoPeslog.jsp";
    response.sendRedirect(url);

%>