<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Usuario"%>
<%@page import="vacci.controller.ControleUsuario"%>
<%
  ControleUsuario userController = new ControleUsuario();
  List<Usuario> users = userController.ListarUsuarios();
%>

<html lang="pt-br"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <link rel="stylesheet" href="..\css\styleVacinaAdolescente.css"> 
    <title>Vacinas Adolescente</title> 
</head> 
  <body> 
    <header> 
      <div class="logo"> 
        <h2><a onclick="index.jsp">Vacci</a></h2> 
      </div>
      <div class="menu"> 
          <li><a href="ControleCarteira.jsp" ><< RETORNAR</a></li>
        </ul> 
      </div>
    </header> 
    <div class="pai"> 
      <div class="filho"> 
        <div class="titulo">
          <h2>Controle de Usuários</h2>
        </div> 
        <div>
          <form>
            <table width="450" border="1px" cellspacing="0" cellpadding="0" style="text-align: center;">
            <thead><th data-field="Id">Id</th>
            <th data-field="Vacina">Nome</th>
            <th data-field="Dose">Login</th>
            <th data-field="Dose">Idade</th>
            </thead>
            <% if (!(users.isEmpty())) { %>    
              <tbody>
                <% for (Usuario user : users) { %>
                  <tr>
                    <td><%=user.GetId()%></td> 
                    <td><%=user.GetNome()%></td>
                    <td><%=user.GetLogin()%></td>
                    <td><%=user.GetIdade()%></td>
                  </tr>
                <% } %>
              </tbody>
              <% } %>              
            </table>
            </form><br>
          <div>
          </div>
                    <form name="FORMDELETE"
                action="ControleUsuario_action.jsp"
                method="post">
          <label for="ids">Deletar usuário:</label>
            <input type="number" id="userDelete" name="userDelete" min="0"><br>
            <input class="btn" type="submit" value="Salvar alterações" id="submit" style="text-align: center;">
</form>
</div> 
</body> 
</html> 