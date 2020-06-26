<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Usuario"%>
<%@page import="vacci.bean.Carteira"%>
<%@page import="vacci.bean.Vacina"%>
<%@page import="vacci.controller.ControleCarteira"%>
<%@page import="vacci.controller.ControleVacina"%>
<%
  ControleVacina vacinaController = new ControleVacina();
  List<Vacina> vacs = vacinaController.ListarVacinasPorTipo(new Carteira(0, 0, 3));

  Usuario user = (Usuario)session.getAttribute("UsuarioLogado");
  Carteira cart = new Carteira(0, user.GetId(), 3);
  ControleCarteira carteiraController = new ControleCarteira();
  carteiraController.InserirCarteira(cart);
%>
<html lang="pt-br"> 
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <link rel="stylesheet" href="..\css\styleVacinaAdulto.css"> 
    <title>Vacinas Adulto</title> 
</head> 
<body> 
    <header> 
      <div class="logo"> 
        <h2>Vacci</h2> 
      </div>
      <div class="menu"> 
          <li><a href="ControleCarteiras.jsp">Login</a></li> 
        </ul> 
      </div>
    </header> 
    <div class="pai"> 
      <div class="filho"> 
        <div class="titulo">
        <h1>Adulto</h1>
         <img src="http://allftp.allin.com.br/man.svg" alt="" width="70px">
          <h2>Controle de Vacinas</h2>
        </div> 
        <div>
          <form>
            <table width="450" border="1px" cellspacing="0" cellpadding="0" style="text-align: center;">
            <thead><th data-field="Id">Id</th><th data-field="Vacina">Vacina</th></thead>
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
            </form><BR>
          <div>
          </div>
          <form name="FORMREGISTRO"
                action="ControleVacina_action.jsp"
                method="post">
            <label for="ids">Números de vacina:</label>
            <input type="number" id="quantity" name="quantity" min="15" max="18"><br>
            <input class="btn" type="submit" value="Salvar alterações" id="submit" style="text-align: center;">
          </form>
          </div> 
          </body> 
          </html> 