<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.FuncionarioDependente"%>
<%@page import="br.com.fatec.controler.ControleFuncionarioDependente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idFun = Integer.parseInt(request.getParameter("ID_FUN"));
    int idDep = Integer.parseInt(request.getParameter("ID_DEP"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    FuncionarioDependente fundep = new FuncionarioDependente(id,idFun,idDep,obs);
    ControleFuncionarioDependente contfundep = new ControleFuncionarioDependente();
    fundep = contfundep.alterarFuncionarioDependente(fundep);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoFunDep.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    