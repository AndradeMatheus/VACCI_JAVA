/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Departamento;
import br.com.fatec.bean.Funcionario;
import br.com.fatec.bean.FuncionarioDepartamento;
import br.com.fatec.db.DaoFuncionarioDepartamento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControleFuncionarioDepartamento {
    
    public static ControleDepartamento contDep;
    public static ControleFuncionario  contfun;
    public static DaoFuncionarioDepartamento daoFunDepart;
    
    public FuncionarioDepartamento inserirFuncionarioDepartamento(FuncionarioDepartamento funcDepart) throws SQLException, ClassNotFoundException {
        daoFunDepart = new DaoFuncionarioDepartamento();
        funcDepart = daoFunDepart.inseri(funcDepart);
        return funcDepart;
    }
    
 
    public FuncionarioDepartamento excluirFuncionarioDepartamento(FuncionarioDepartamento funcDepart) throws SQLException, ClassNotFoundException {
        daoFunDepart = new DaoFuncionarioDepartamento();
        funcDepart = daoFunDepart.exclui(funcDepart);
        return funcDepart;
    }

    public FuncionarioDepartamento alterarUsuarioPessoa(FuncionarioDepartamento funcDepart) throws SQLException, ClassNotFoundException {
        daoFunDepart = new DaoFuncionarioDepartamento();
        funcDepart = daoFunDepart.altera(funcDepart);
        return funcDepart;
    }

    public FuncionarioDepartamento buscarFuncionarioDepartamentoPorId(FuncionarioDepartamento funcDepart) throws SQLException, ClassNotFoundException {

        daoFunDepart = new DaoFuncionarioDepartamento();
        funcDepart = daoFunDepart.busca(funcDepart);
        
        contDep = new ControleDepartamento();
        contfun = new ControleFuncionario();

        Funcionario fun = new Funcionario(funcDepart.getIdFun(),"");
        Departamento dep = new Departamento(funcDepart.getIdDepart(),"");
        
        funcDepart.setFun(contfun.buscaFuncionarioPorId(fun));
        funcDepart.setDepart(contDep.buscaDepartamentoPorId(dep));

        return funcDepart;
    }


    public List<FuncionarioDepartamento> listarFuncionarioDepartamento(FuncionarioDepartamento funDepart) throws SQLException, ClassNotFoundException {

        contDep = new ControleDepartamento();
        contfun = new ControleFuncionario();
        
        daoFunDepart = new DaoFuncionarioDepartamento();

        List<FuncionarioDepartamento> funDeparts = daoFunDepart.lista(funDepart);

        for (FuncionarioDepartamento listaFD : funDeparts) {
            Funcionario fun = new Funcionario(listaFD.getIdFun(),"");
            Departamento dep = new Departamento(listaFD.getIdDepart(),"");
            listaFD.setFun(contfun.buscaFuncionarioPorId(fun));
            listaFD.setDepart(contDep.buscaDepartamentoPorId(dep));
        }

        return funDeparts;
    }

    
}
