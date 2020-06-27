<%@page
	contentType="text/html"
	import="java.util.*"
	pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Vacina"%>
<%@page import="vacci.controller.ControleVacina"%>
<%
	ControleVacina vacController = new ControleVacina();
	Boolean validaInsercao;

try {
	String nome = request.getParameter("nome");
	int tipo = Integer.parseInt(request.getParameter("carteira"));
	Vacina vac = new Vacina(0, nome, tipo);

	validaInsercao = vacController.InserirVacina(vac);
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
		String redirectURL = "RegistraVacina.jsp";
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
