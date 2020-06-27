<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Vacina"%>
<%@page import="vacci.bean.CarteiraVacina"%>
<%@page import="vacci.controller.ControleVacina"%>
<%
  ControleVacina vacinaController = new ControleVacina();
  List<Vacina> vacs = vacinaController.ListarVacinas();
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
          <li><a href="ControleCarteira_action.jsp"><< EXCLUIR CARTEIRA >></a><li>  
        </ul> 
      </div>
    </header> 
    <div class="pai"> 
      <div class="filho"> 
        <div class="titulo">
          <h2>Controle de Vacinas</h2>
        </div> 
        <div>
          <form>
            <table width="450" border="1px" cellspacing="0" cellpadding="0" style="text-align: center;">
            <thead><th data-field="Id">Id</th>
            <th data-field="Vacina">Vacina</th>
            </thead>
            <% if (!(vacs.isEmpty())) { %>    
              <tbody>
                <% for (Vacina vac : vacs) { %>
                  <tr>
                    <td><%=vac.GetId()%></td> 
                    <td><%=vac.GetNome()%></td>
                  </tr>
                <% } %>
              </tbody>
              <% } %>              
            </table>
            </form><br>
          <div>
          </div>
                    <form name="FORMREGISTRO"
                action="DeleteVacina_action.jsp"
                method="post">
          <label for="ids">Vacina para deletar:</label>
            <input type="number" id="quantity" name="vacinaId" min="0"><br>
            <input class="btn" type="submit" value="Salvar alterações" id="submit" style="text-align: center;">
</form>
</div> 
</body> 
</html> 