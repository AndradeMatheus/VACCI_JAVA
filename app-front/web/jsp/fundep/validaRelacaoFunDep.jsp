<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.FuncionarioDependente"%>
<%@page import="br.com.fatec.controler.ControleFuncionarioDependente"%>

<%
    int idDep = Integer.parseInt(request.getParameter("ID_DEP"));
    int idFun = Integer.parseInt(request.getParameter("ID_FUN"));
    String obs = request.getParameter("OBS");
    
    FuncionarioDependente fundep = new FuncionarioDependente(0,idFun,idDep,obs);
    ControleFuncionarioDependente fundepcont = new ControleFuncionarioDependente();
    fundep = fundepcont.inserirFuncionarioDependente(fundep);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoFunDep.jsp";
    response.sendRedirect(url);

%>