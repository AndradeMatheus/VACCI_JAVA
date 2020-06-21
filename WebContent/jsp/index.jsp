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
	href="..\css\styleIndex.css"
>
<title>Vacci</title>
</head>
<body>
	<header>
		<div class="logo">
			<h2>Vacci</h2>
		</div>
		<div class="menu">
			<ul>
				<li><a href="https://github.com/AndradeMatheus/VACCI_JAVA">Matheus e Mioki</a>
				<li><a href="RegistraUsuario.jsp"> Registre um usuário></a></li>
			</ul>
		</div>
	</header>
	<div class="pai">
		<div class="filho">
			<div class="titulo">
				<h2>Entre para acessar</h2>
			</div>
			<form
				name="FORMLOGIN"
				action="index_action.jsp"
				method="post"
			>
				LOGIN: <input
					type="text"
					name="LOGIN"
				> <br> SENHA: <input
					type="password"
					name="SENHA"
				> <br> <input
					type="submit"
					name="ENVIAR"
				>
			</form>
			<div>
				<label for="submit"></label> <input
					class="btn"
					type="submit"
					value="Logar"
					id="submit"
				>
			</div>
</body>
</html>