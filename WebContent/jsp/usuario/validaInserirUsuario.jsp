<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.controler.ControleUsuario"%>

<%
    String nome = request.getParameter("NOME");
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    String status = request.getParameter("STATUS");
    String tipo = request.getParameter("TIPO");
    Usuario usu = new Usuario(0,login,nome,senha,status,tipo);
    ControleUsuario usucont = new ControleUsuario();
    usu = usucont.inserirUsuario(usu);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirUsuario.jsp";
    response.sendRedirect(url);
%>
