<%@page
	contentType="text/html"
	import="java.util.*"
	pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Usuario"%>
<%@page import="vacci.controller.ControleUsuario"%>
<%
	ControleUsuario userController = new ControleUsuario();
Boolean validaInsercao;

try {
	String nome = request.getParameter("nome");
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	int genero = Integer.parseInt(request.getParameter("genero"));
	int idade = Integer.parseInt(request.getParameter("idade"));

	Usuario user = new Usuario(0, nome, login, senha, genero, "", "", idade);

	validaInsercao = userController.InserirUsuario(user);
} catch (Exception ex) {
	validaInsercao = false;
}
%>
<!DOCTYPE html>
<html>
<%@include file="../../inc/materalizeWeb.inc"%>
<title>SISTEMA</title>
<body>
	<%
		if (validaInsercao) {
		String redirectURL = "index.jsp";
		response.sendRedirect(redirectURL);
	%>
	<%
		} else {
	%>
	<h1>USUÁRIO INVÁLIDO</h1>
	<%
		}
	%>
</body>
</html>
