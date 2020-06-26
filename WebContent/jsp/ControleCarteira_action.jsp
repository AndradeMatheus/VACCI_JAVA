<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Carteira"%>
<%@page import="vacci.bean.Vacina"%>
<%@page import="vacci.controller.ControleCarteira"%>
<%
  Carteira cart = (Carteira)session.getAttribute("CarteiraUsuario");
  ControleCarteira cartController = new ControleCarteira();

    Boolean validaDelete = cartController.ExcluirCarteira(cart);

%>
<!DOCTYPE html>
<html>
<%@include file="../../inc/materalizeWeb.inc"%>
<title>SISTEMA</title>
<body>
    <%
        if (validaDelete) {
        	String redirect = "http://localhost:8080/VACCI/jsp/ControleCarteira.jsp" ;
            response.sendRedirect(redirect);
        } else {
    %>
    <h1>ERRO</h1>
    <%
        }
    %>
</body>
</html>