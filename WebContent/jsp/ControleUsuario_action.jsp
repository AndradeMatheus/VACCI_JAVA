<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Usuario"%>
<%@page import="vacci.controller.ControleUsuario"%>
<%
  ControleUsuario userController = new ControleUsuario();

    int userId = Integer.parseInt(request.getParameter("userDelete"));
    Usuario user = new Usuario();
    user.SetId(userId);
    Boolean validaDelete = userController.ExcluirUsuario(user);

%>
<!DOCTYPE html>
<html>
<%@include file="../../inc/materalizeWeb.inc"%>
<title>SISTEMA</title>
<body>
    <%
        if (validaDelete) {
        	String redirect = "http://localhost:8080/VACCI/jsp/index.jsp";
            response.sendRedirect(redirect);
        } else {
    %>
    <h1>ERRO</h1>
    <%
        }
    %>
</body>
</html>