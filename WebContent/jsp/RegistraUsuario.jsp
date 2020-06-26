<%@page
    contentType="text/html"
    import="java.util.*"
    pageEncoding="UTF-8"
%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta
    name="viewport"
    content="width=device-width, initial-scale=1.0"
>
<meta
    http-equiv="X-UA-Compatible"
    content="ie=edge"
>
<link
    rel="stylesheet"
    href="..\css\styleRegistra.css"
/>
<link
    rel="stylesheet"
    type="text/css"
    href="css/register.css"
/>
<link
    rel="stylesheet"
    type="text/css"
    href="css/animate.css"
/>
<title>Registra Usuário</title>
</head>
<body>
    <header>
        <div class="logo">
            <h2>Vacci</h2>
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
                    <form
                        name="FORMLOGIN"
                        action="Registra_action.jsp"
                        method="post"
                    >
                        <label for="nome">Nome</label> <input
                            type="text"
                            id="nome"
                            name="nome"
                            placeholder="Nome"
                        /> <label for="senha">Senha</label> <input
                            type="password"
                            id="senha"
                            name="senha"
                            placeholder="Entre com sua senha"
                        /> <label for="login">Login</label> <input
                            type="text"
                            id="login"
                            name="login"
                            placeholder="Login"
                        /> <label>Genero</label> <select name="genero">
                            <option value="0">Selecionar...</option>
                            <option value="1">Masculino</option>
                            <option value="2">Feminino</option>
                            <option value="3">Outro</option>
                        </select> <label for="idade">Idade</label> <input
                            type="number"
                            id="idade"
                            name="idade"
                            placeholder=""
                        /> <input
                            class="btn"
                            type="submit"
                            name="REGISTRAR"
                        >
                        </button>
                    </form>
                </ul>
            </div>
</body>
</html>