<%@page
	contentType="text/html"
	import="java.util.*"
	pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Usuario"%>
<%@page import="vacci.controller.ControleUsuario"%>
<%
	String login = request.getParameter("LOGIN");
String senha = request.getParameter("SENHA");
ControleUsuario userController = new ControleUsuario();
Boolean validaLogin = userController.ValidaLogin(login, senha);

if (validaLogin) {
	Usuario user = userController.BuscarUsuarioPorLogin(login);
	session.setAttribute("UsuarioLogado", user);
}
%>
<!DOCTYPE html>
<html>
<%@include file="../../inc/materalizeWeb.inc"%>
<title>SISTEMA</title>
<body>
	<%
		if (validaLogin) {
	%>
	<h1>SUA MAE</h1>
	<%
		} else {
	%>
	<h1>USUÁRIO INVÁLIDO</h1>
	<%
		}
	%>
</body>
</html>
