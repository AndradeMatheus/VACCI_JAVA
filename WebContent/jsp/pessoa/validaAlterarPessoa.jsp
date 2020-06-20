<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.PessoaFisica"%>
<%@page import="br.com.fatec.controler.ControlePessoa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String cpf = request.getParameter("CPF");
    String tipo = request.getParameter("TIPO");
    String email = request.getParameter("EMAIL");

    String pbusca = request.getParameter("PBUSCA");

    PessoaFisica pes = new PessoaFisica(id,nome,cpf,tipo,email);
    ControlePessoa usuCont = new ControlePessoa();
    pes = usuCont.alterarPessoa(pes);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarPessoa.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>