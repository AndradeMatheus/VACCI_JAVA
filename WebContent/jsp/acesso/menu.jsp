<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.controler.ControleUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usu = new Usuario(0,"",login,senha,"","");
    ControleUsuario usucont = new ControleUsuario();
    usu = usucont.validaUsuario(usu);
    session.setAttribute("UsuarioLogado",usu);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA </title>
    <body>
        <% if (!usu.getStatus().equals("")) { %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Controle de Usuario</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Controle de Usuario & Pessoa</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Controle de Pessoa</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Controle de Dependente</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown5'>Manter Controle de Funcionario & Dependente</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown6'>Manter Controle de Funcionario</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown7'>Manter Controle de Logradouro</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown8'>Manter Controle de Logradouro & Pessoa</a>        

            <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> InseriUsuario </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> ConsultaUsuarioParametro </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> ConsultaUsuarioParametro </a></li>
                </ul>
            <% } %>

            <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../usupes/inserirRelacaoUsuarioPessoa.jsp"> InseriUsuarioPessoa </a></li>
                    <li><a href="../usupes/consultarRelacaoUsuarioPessoa.jsp"> ConsultaUsuarioPessoa </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../usupes/consultarRelacaoUsuarioPessoa.jsp"> ConsultaUsuarioPessoa </a></li>
                </ul>
            <% } %>

            <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../pessoa/inserirPessoa.jsp"> InseriPessoa </a></li>
                    <li><a href="../pessoa/consultarPessoa.jsp"> ConsultaPessoa </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../pessoa/consultarPessoa.jsp"> ConsultaPessoa </a></li>
                </ul>
            <% } %>

            <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../depend/inserirDependente.jsp"> InseriDependente </a></li>
                    <li><a href="../depend/consultarDependente.jsp"> ConsultaDependente </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../depend/consultarDependente.jsp"> ConsultaDependente </a></li>
                </ul>
            <% } %>
            
            <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../fundep/inserirRelacaoFunDep.jsp"> InseriFuncinarioDependente </a></li>
                    <li><a href="../fundep/consultarRelacaoFunDep.jsp"> ConsultaFuncinarioDependente </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../fundep/consultarRelacaoFunDep.jsp"> ConsultaFuncinarioDependente </a></li>
                </ul>
            <% } %>
         
           <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown6' class='dropdown-content'>
                    <li><a href="../funcio/inserirFuncionario.jsp"> InseriFuncinario</a></li>
                    <li><a href="../funcio/consultarFuncionario.jsp"> ConsultaFuncinario</a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown6' class='dropdown-content'>
                    <li><a href="../funcio/consultarFuncionario.jsp"> ConsultaFuncionario</a></li>
                </ul>
            <% } %>

           <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown7' class='dropdown-content'>
                    <li><a href="../lograd/inserirLogradouro.jsp"> InseriLogradouro</a></li>
                    <li><a href="../lograd/consultarLogradouro.jsp"> ConsultaLogradouro</a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown7' class='dropdown-content'>
                    <li><a href="../lograd/consultarLogradouro.jsp"> ConsultaLogradouro</a></li>
                </ul>
            <% } %>

            <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown8' class='dropdown-content'>
                    <li><a href="../peslog/inserirRelacaoPeslog.jsp"> Inseri Pessoa & Logradouro</a></li>
                    <li><a href="../peslog/consultarRelacaoPeslog.jsp"> Consulta Pessoa & Logradouro</a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown8' class='dropdown-content'>
                    <li><a href="../peslog/consultarRelacaoPeslog.jsp"> Consulta Pessoa & Logradouro</a></li>
                </ul>
            <% } %>

            
        <% } else { %>
                <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>
