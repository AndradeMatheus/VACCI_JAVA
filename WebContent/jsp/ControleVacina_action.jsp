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

    String tipoCarteira = "";

    if(cart.GetCarteiraTipo() == 1){
        tipoCarteira = "crianca";
    }else if(cart.GetCarteiraTipo() == 2){
        tipoCarteira = "adolescente";
    }else if(cart.GetCarteiraTipo() == 3){
        tipoCarteira = "adulto";
    }

    int vacina = Integer.parseInt(request.getParameter("quantity"));
    Boolean validaInsert = cartController.RegistrarCarteiraVacina(
        cart,
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
        	String redirect = "http://localhost:8080/VACCI/jsp/ControleVacina_" + tipoCarteira + ".jsp" ;
            response.sendRedirect(redirect);
        } else {
    %>
    <h1>ERRO</h1>
    <%
        }
    %>
</body>
</html>