<!DOCTYPE html> 
<html lang="pt-br"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <!-- <link rel="stylesheet" href="style.css"> 
    <title>Carteiras</title> 
    <style>
      body{
        margin:0; padding: 0; border: 0; 
        font-family: Arial, Helvetica, sans-serif;
      } 
      header { 
        z-index: 1;
        background: rgba(0, 0, 0, 0.171); 
        height:70px; 
        width: 100%;
        position: fixed;
      } 
      .logo{ 
        float:left; 
        color: black; 
        padding: 0 20px; 
      } 
      .logo { 
        color: #A65355; 
        transition: 0.3s; 
      } 
      .menu{ 
        float:right; 
      } 
      .menu ul{ 
        list-style: none; 
      } 
      .menu ul li{ 
        display: inline-block; 
        padding: 10px 20px; 
      } 
      .menu ul li a{ 
        text-decoration: none; 
        color: #A65355; 
        transition: 0.5s; 
      } 
      .menu ul li a:hover{ 
        color: #FFFFFF; 
        transition: 0.5s; 
      } 
      .pai{ 
        background: rgb(235, 235, 235); 
        position:absolute; 
        width:100%; 
        height:100%; 
        display:flex; 
        justify-content:center; 
        align-items:center; 
        flex-direction: column; 
      } 
      .filho{  
        padding:60px 60px; 
        border-radius:10px; 
        display: flex; 
        justify-content: center; 
        align-items: center; 
        flex-direction: row; 
      } 
      input{ 
        padding: 8px 30px; 
        border: 1 solid #A65355; 
        margin: 5px 0; 
      } 
      .register { 
      color: black; 
      } 
      .btn{ 
        background: rgb(221, 70, 70); 
        border-radius: 5px; 
        border: 0; 
        margin: 20px 0 0 0; 
        color: white; 
        box-shadow: 0 3px 3px 0px rgba(0, 0, 0, 0.171); 
      } 
      .titulo { 
        text-align: center;
        color: rgb(133, 133, 133);
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
        }    
      .circulo_1{
        border-radius: 50%;
        width: 200px;
        height: 200px;
        background: rgb(240, 240, 240);
        border: 2px solid rgb(214, 214, 214);
        margin: 0 40px;
        transform: scale(1);
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
        cursor: pointer;
        display: flex;
        justify-content: center;
        align-items: center;
      }   
      .circulo_1:hover{
        background: rgb(255, 165, 165);
        transform: scale(1.05);
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
      }
      .circulo_1:hover~.titulo{
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
        color: rgb(31, 31, 31);
      }
      .circulo_2{
        border-radius: 50%;
        width: 200px;
        height: 200px;
        background: rgb(240, 240, 240);
        border: 2px solid rgb(214, 214, 214);
        margin: 0 40px;
        transform: scale(1);
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
        cursor: pointer;
        display: flex;
        justify-content: center;
        align-items: center;
      }   
      .circulo_2:hover{
        background: rgb(135, 207, 255);
        transform: scale(1.05);
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
      }
      .circulo_2:hover~.titulo{
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
        color: rgb(31, 31, 31);
      }
      .circulo_3{
        border-radius: 50%;
        width: 200px;
        height: 200px;
        background: rgb(240, 240, 240);
        border: 2px solid rgb(214, 214, 214);
        margin: 0 40px;
        transform: scale(1);
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
        cursor: pointer;
        display: flex;
        justify-content: center;
        align-items: center;
      }   
      .circulo_3:hover{
        background: rgb(125, 255, 120);
        transform: scale(1.05);
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
      }
      .circulo_3:hover~.titulo{
        transition: 0.5s ease-in-out;
        -moz-transition: 0.5s ease-in-out;
        color: rgb(31, 31, 31);
      }
    </style>
  -->
</head> 
<body> 
  <!-- Topo -->
    <header>
      <!-- Menu -->
      <div class="menu"> 
        <ul> 
          <li><a href="index.html">Login</a> 
          <li><a href="ControleUsuario.html">Controle Usuários</a></li> 
        </ul> 
      </div>
    </header> 
    <!-- Centro -->
    <div class="pai"> 
      <div class="texto">
        <h1 style="color: rgb(26, 26, 26);">
          Controle Carteiras
        </h1>
        <!-- <p style="text-align: center; color: rgb(117, 117, 117);">
          Escolha de acordo com o que deseja sei la.
        </p> -->
      </div>
      <div class="filho">
        <!-- Bola Criança -->
        <div class="conteudo">
          <div class="circulo_1">
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
            <img src="http://allftp.allin.com.br/teenager.svg" alt="" width="70px">
          </div>
          <div class="titulo">
            <h2>
              Adolecente
            </h2>
          </div>
        </div>
        <!-- Bola Adulto -->
        <div class="conteudo">
          <div class="circulo_3">
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