<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Usuario"%>
<%@page import="vacci.bean.Carteira"%>
<%@page import="vacci.bean.Vacina"%>
<%@page import="vacci.bean.CarteiraVacina"%>
<%@page import="vacci.controller.ControleCarteira"%>
<%@page import="vacci.controller.ControleVacina"%>
<%
  Usuario user = (Usuario)session.getAttribute("UsuarioLogado");

  ControleCarteira cartController = new ControleCarteira();
  ControleVacina vacinaController = new ControleVacina();
  List<Vacina> vacs = vacinaController.ListarVacinasPorTipo(new Carteira(0, 0, 2));
  Carteira cart = cartController.BuscarCarteiraPorUsuarioTipoCarteira(user, new Carteira(0, 0, 2));

  if(cart.GetUsuarioId() != 0){
    session.setAttribute("CarteiraUsuario", cart);

    List<CarteiraVacina> cartVacs = cartController.ListarCarteiraVacinas(cart);

      for (Vacina vac : vacs){
        vac.SetCarteiraQuantidade(0);
        for (CarteiraVacina cartVac : cartVacs){
          if(vac.GetId() == cartVac.GetVacinaId()){
            vac.SetCarteiraQuantidade(vac.GetCarteiraQuantidade() + 1);
          }
        } 
      } 

  }else{
    Carteira cartNova = new Carteira(0, user.GetId(), 2);
    cartController.InserirCarteira(cartNova);
    cartNova = cartController.BuscarCarteiraPorUsuarioTipoCarteira(user, cart);

    session.setAttribute("CarteiraUsuario", cartNova);
    response.setIntHeader("Refresh", 1);
  }
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
        <h1>Adolescente</h1>
        <img src="http://allftp.allin.com.br/teenager.svg" alt="" width="70px">
          <h2>Controle de Vacinas</h2>
        </div> 
        <div>
          <form>
            <table width="450" border="1px" cellspacing="0" cellpadding="0" style="text-align: center;">
            <thead><th data-field="Id">Id</th>
            <th data-field="Vacina">Vacina</th>
            <th data-field="Dose">Doses</th>
            </thead>
            <% if (!(vacs.isEmpty())) { %>    
              <tbody>
                <% for (Vacina vac : vacs) { %>
                  <tr>
                    <td><%=vac.GetId()%></td> 
                    <td><%=vac.GetNome()%></td>
                    <td><%=vac.GetCarteiraQuantidade()%></td>
                  </tr>
                <% } %>
              </tbody>
              <% } %>              
            </table>
            </form><br>
          <div>
          </div>
                    <form name="FORMREGISTRO"
                action="ControleVacina_action.jsp"
                method="post">
          <label for="ids">Números de vacina:</label>
            <input type="number" id="quantity" name="quantity" min="10" max="13"><br>
            <input class="btn" type="submit" value="Salvar alterações" id="submit" style="text-align: center;">
</form>
</div> 
</body> 
</html> 