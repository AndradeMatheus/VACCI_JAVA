<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <link
      rel="stylesheet" href="..\css\styleRegistra.css"
    />
    <link rel="stylesheet" type="text/css" href="css/register.css" />
    <link rel="stylesheet" type="text/css" href="css/animate.css" /> 
    <title>Registra Usuário</title>
  </head>

  <body>
    <header> 
      <div class="logo"> 
        <h2>  Vacci  </h2> 
      </div>
      <div class="menu"> 
        <ul> 
          <li><a href="https://github.com/AndradeMatheus/VACCI_JAVA">Matheus e Mioki</a> 
        </ul> 
      </div>
    </header> 
    <div class="pai"> 
      <div class="filho"> 
        <div class="titulo">
        <h1>Registra usuário</h1> 
          <ul>
            <label for="nome">Nome</label>
            <input
              type="name"
              id="nome"
              placeholder="Nome"
            />
            <label for="password">Senha</label>
            <input
              type="password"
              id="password"
              placeholder="Entre com sua senha"/>
            <label for="login">Login</label>
            <input type="text" id="login" placeholder="Login" />
            <label >Sexo</label>
            <select name="sexo">
              <option value="#">Selecionar...</option>
              <option value="Male">Masculino</option>
              <option value="Female">Feminino</option>
              <option value="Outro">Outro</option>
            </select>
            <label for="age">Idade</label>
            <input type="text" id="Idade" placeholder=""/>
            <input class="btn" type="submit" value="Registrar" id="submit">
            </button>
        </ul>
      </form>
    </div>
  </body>
</html>
