<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%@page import="vacci.bean.Usuario"%>
<%@page import="vacci.bean.Carteira"%>
<%@page import="vacci.controller.ControleCarteira"%>
<% 
  Usuario user = (Usuario)session.getAttribute("UsuarioLogado");
  Carteira cart = new Carteira(0, user.GetId(), 1);
  ControleCarteira carteiraController = new ControleCarteira();
  carteiraController.InserirCarteira(cart);
%>
<html lang="pt-br"> 
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <link rel="stylesheet" href="..\css\styleVacinaCrianca.css"> 
    <title>Vacinas Criança</title> 
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
        <img src="http://allftp.allin.com.br/kid.svg" alt="" width="70px"> 
          <h2>Controle de Vacinas</h2>
        </div> 
        <div>
          <form>
            <table width="450" border="1px" cellspacing="0" cellpadding="0" style="text-align: center;">
            <tbody>
            <thead><th>Id</th><th>Vacinas</th></thead>
            <tr>
            <td>1</td>
            <td>"BCG + VHB (Ao nascer)"</td>
            </tr>
            <tr>
            <td>2</td>
            <td> "VHB (1 mês)"</td>
            </tr>
            <tr>
            <td>3</td>
            <td>"DPT-Hib + SABIN + ROTA (2 meses)"</td>
            </tr>
            <tr>
            <td>4</td>
            <td>"DPT-Hib + SABIN + VHB (6 meses)"</td>
            </tr>
            <tr>
            <td>5</td>
            <td>"FA (9 meses)"</td>
            </tr>
            <tr>
            <td>6</td>
            <td>"Tríplice Viral (12 meses)"</td>
            </tr>
            <tr>
            <td>7</td> 
            <td>"DPTT + SABIN (15 meses)"</td>
            </tr>
            <tr>
            <td>8</td>  
            <td>"DPT + Trípiplice Viral (4-6 anos)"</td>
            </tr>
            <tr>
            <td>9</td>  
            <td>"dT + FA (10-11 anos)"</td>
            </tr>
            </tbody>
            </table> 
            </form><br>
          <div>
          </div>
            <label for="ids">Números de vacina:</label>
            <input type="number" id="quantity" name="quantity" min="15" max="18"><br>
            <input class="btn" type="submit" value="Salvar alterações" id="submit" style="text-align: center;">
          </div> 
          </body> 
          </html> 