<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<%
%>
<html lang="pt-br"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
     <link rel="stylesheet" href="..\css\styleCarteira.css"> 
    <title>Carteiras</title> 
</head> 
<body> 
  <!-- Topo -->
    <header>
      <!-- Menu -->
      <div class="menu"> 
        <ul> 
          <li><a href="index.jsp">Login</a> 
          <li><a href="ControleUsuario.jsp">Controle Usuários</a></li> 
          <li><a href="RegistraVacina.jsp">Registrar Vacinas</a></li> 
        </ul> 
      </div>
    </header> 
    <!-- Centro -->
    <div class="pai"> 
      <div class="texto">
        <h1 style="color: rgb(26, 26, 26);">
          Controle Carteiras
        </h1>
         <p style="text-align: center; color: rgb(117, 117, 117);">
          Escolha de acordo com o seu perfil para criar uma carteira com as respectivas vacinas
        </p>
      </div>
      <div class="filho">
        <!-- Bola Criança -->
        <div class="conteudo">
          <div class="circulo_1">
            <a href = "ControleVacina_crianca.jsp">
            <img src="http://allftp.allin.com.br/kid.svg" alt="" width="70px">
          </div>
          <div class="titulo">
            <h2>
              Criança
            </h2>
          </div>
        </div>
        <!-- Bola Adolecente -->
        <div class="conteudo">
          <div class="circulo_2">
            <a href = "ControleVacina_adolescente.jsp">
            <img src="http://allftp.allin.com.br/teenager.svg" alt="" width="70px">
          </div>
          <div class="titulo">
            <h2>
              Adolescente
            </h2>
          </div>
        </div>
        <!-- Bola Adulto -->
        <div class="conteudo">
          <div class="circulo_3">
            <a href = "ControleVacina_adulto.jsp">
            <img src="http://allftp.allin.com.br/man.svg" alt="" width="70px">
          </div>
          <div class="titulo">
            <h2>
              Adulto
            </h2>
          </div>
        </div>
      </div>
    </div>
</div> 
</body> 
</html> 