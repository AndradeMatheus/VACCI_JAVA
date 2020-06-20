<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
   <!-- <link
      rel="stylesheet"
      type="text/css"
    />
    <link rel="stylesheet" type="text/css" href="css/register.css" />
    <link rel="stylesheet" type="text/css" href="css/animate.css" /> -->
    <title>Registra Usuário</title>
  </head>

  <body class="menu">
    <div class="titulo">
      <h1>Registra Usuário</h1>
    </div>

    <div>
      <form>
        <ul>
          <li>
            <label for="nome">Nome</label>
            <input
              type="name"
              id="nome"
              placeholder="Nome"
            />
          </li>
          <li>
            <label for="password">Senha</label>
            <input
              type="password"
              id="password"
              placeholder="Entre com sua senha"
            />
          </li>
          <li>
            <label for="login">Login</label>
            <input type="text" id="login" placeholder="Login" />
          </li>
          <li>
            <label >Sexo</label>
            <select name="sexo">
              <option value="#">Selecionar...</option>
              <option value="Male">Masculino</option>
              <option value="Female">Feminino</option>
            </select>
          </li>
          <li>
            <label for="age">Idade</label>
            <input type="text" id="Idade" placeholder=""/>
          </li>
          <li>
            <button onclick="location.href = 'ControleUsuario.html';" id="myButton">
              Registrar
            </button>
          </li>
        </ul>
      </form>
    </div>
  </body>
</html>
