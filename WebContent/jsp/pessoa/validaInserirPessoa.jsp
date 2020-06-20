<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.PessoaFisica"%>
<%@page import="br.com.fatec.controler.ControlePessoa"%>

<%
    String nome = request.getParameter("NOME");
    String cpf = request.getParameter("CPF");
    String tipo = request.getParameter("TIPO");
    String email = request.getParameter("EMAIL");
    PessoaFisica pes = new PessoaFisica(0,nome,cpf,tipo,email);
    ControlePessoa pecont = new ControlePessoa();
    pes = pecont.inserirPessoa(pes);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirPessoa.jsp";
    response.sendRedirect(url);
%>
