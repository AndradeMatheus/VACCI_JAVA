<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Vacina"%>
<%@page import="vacci.controller.ControleVacina"%>
<%
  ControleVacina vacController = new ControleVacina();

    int vacinaId = Integer.parseInt(request.getParameter("vacinaId"));
    Vacina vac = new Vacina();
    vac.SetId(vacinaId);
    Boolean validaDelete = vacController.ExcluirVacina(vac);

%>
<!DOCTYPE html>
<html>
<%@include file="../../inc/materalizeWeb.inc"%>
<title>SISTEMA</title>
<body>
    <%
        if (validaDelete) {
        	String redirect = "http://localhost:8080/VACCI/jsp/DeleteVacina.jsp";
            response.sendRedirect(redirect);
        } else {
    %>
    <h1>ERRO</h1>
    <%
        }
    %>
</body>
</html>