<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Carteira"%>
<%@page import="vacci.bean.Vacina"%>
<%@page import="vacci.controller.ControleCarteira"%>
<%
int vacina = Integer.parseInt(request.getParameter("quantity"));
ControleCarteira cartController = new ControleCarteira();
Boolean validaInsert = cartController.RegistrarCarteiraVacina(
    new Carteira(1, 0, 0),
    new Vacina(vacina, "", 0)
    );

%>
<!DOCTYPE html>
<html>
<%@include file="../../inc/materalizeWeb.inc"%>
<title>SISTEMA</title>
<body>
    <%
        if (validaInsert) {
        	String redirect = "http://localhost:8080/VACCI/jsp/ControleCarteira.jsp";
            response.sendRedirect(redirect);
        } else {
    %>
    <h1>ERRO</h1>
    <%
        }
    %>
</body>
</html>