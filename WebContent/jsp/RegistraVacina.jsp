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
                <li><a href="ControleCarteira.jsp"><< RETORNAR</a></li>
                <li><a href="DeleteVacina.jsp"><< DELETAR VACINAS >></a></li>
            </ul>
        </div>
    </header>
    <div class="pai">
        <div class="filho">
            <div class="titulo">
                <h1>Registra vacina</h1>
                <ul>
                    <form
                        name="FORMLOGIN"
                        action="RegistraVacina_action.jsp"
                        method="post"
                    >
                        <label for="nome">Nome da vacina</label> 
                        <input type="text" id="nome" name="nome" placeholder="Vacina">

                         <label>Tipo da carteira</label> <select name="carteira">
                            <option value="0">Selecionar...</option>
                            <option value="1">Criança</option>
                            <option value="2">Adolescente</option>
                            <option value="3">Adulto</option>
                        <button>
                        <input class="btn" type="submit" name="REGISTRAR">
                        </button><br>
                    </form>
                </ul>
            </div>
</body>
</html>