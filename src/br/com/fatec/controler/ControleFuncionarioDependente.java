/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Dependente;
import br.com.fatec.bean.Funcionario;
import br.com.fatec.bean.FuncionarioDependente;
import br.com.fatec.db.DaoFuncionarioDependente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControleFuncionarioDependente {
    
    public static ControleDependente contDepe;
    public static ControleFuncionario  contfun;
    public static DaoFuncionarioDependente daoFunDep;
    
    public FuncionarioDependente inserirFuncionarioDependente(FuncionarioDependente funcDep) throws SQLException, ClassNotFoundException {
        daoFunDep = new DaoFuncionarioDependente();
        return daoFunDep.inseri(funcDep);
    }
 
    public FuncionarioDependente excluirFuncionarioDependente(FuncionarioDependente funcDep) throws SQLException, ClassNotFoundException {
        daoFunDep = new DaoFuncionarioDependente();
        return daoFunDep.exclui(funcDep);
    }

    public FuncionarioDependente alterarFuncionarioDependente(FuncionarioDependente funcDep) throws SQLException, ClassNotFoundException {
        daoFunDep = new DaoFuncionarioDependente();
        return daoFunDep.altera(funcDep);
    }

    public FuncionarioDependente buscarFuncionarioDependentePorId(FuncionarioDependente funcDep) throws SQLException, ClassNotFoundException {

        daoFunDep = new DaoFuncionarioDependente();
        funcDep = daoFunDep.busca(funcDep);
        
        contfun = new ControleFuncionario();
        contDepe = new ControleDependente();

        Funcionario fun = new Funcionario(funcDep.getIdFun(),"");
        Dependente depe = new Dependente(funcDep.getIdDep(),"");
        
        funcDep.setFun(contfun.buscaFuncionarioPorId(fun));
        funcDep.setDep(contDepe.buscaDependentePorId(depe));

        return funcDep;
    }


    public List<FuncionarioDependente> listarFuncionarioDependente(FuncionarioDependente funDepe) throws SQLException, ClassNotFoundException {

        contDepe = new ControleDependente();
        contfun = new ControleFuncionario();

        daoFunDep = new DaoFuncionarioDependente();
        List<FuncionarioDependente> funDeps = daoFunDep.lista(funDepe);

        for (FuncionarioDependente listaFD : funDeps) {
            Funcionario fun = new Funcionario(listaFD.getIdFun(),"");
            Dependente dep = new Dependente(listaFD.getIdDep(),"");
            listaFD.setFun(contfun.buscaFuncionarioPorId(fun));
            listaFD.setDep(contDepe.buscaDependentePorId(dep));
        }

        return funDeps;
    }

    
}
