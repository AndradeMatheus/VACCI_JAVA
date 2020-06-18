/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Funcionario;
import br.com.fatec.db.DaoFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */

//create table db2020.funcionarios (
  //id BIGINT NOT NULL AUTO_INCREMENT,
  //nome VARCHAR(255),
  //primary key (id));

public class ControleFuncionario {
    
    public static DaoFuncionario daoFunc;

    public Funcionario buscaFuncionarioPorId (Funcionario func) throws SQLException,ClassNotFoundException {
        daoFunc = new DaoFuncionario();
        return daoFunc.busca(func);
    }

    public Funcionario inseriFuncionario (Funcionario func) throws SQLException, ClassNotFoundException {
        daoFunc = new DaoFuncionario();
        return daoFunc.inseri(func);
    }

    public Funcionario alteraFuncionario (Funcionario func) throws SQLException, ClassNotFoundException {
        daoFunc = new DaoFuncionario();
        return daoFunc.altera(func);
    }

    public Funcionario excluiFuncionario (Funcionario func) throws SQLException, ClassNotFoundException {
        daoFunc = new DaoFuncionario();
        return daoFunc.exclui(func);
    }

    public List<Funcionario> listaFuncionario (Funcionario func) throws SQLException, ClassNotFoundException {
        List<Funcionario> lisFuns = new ArrayList();
        daoFunc = new DaoFuncionario();
        lisFuns = daoFunc.lista(func);
        return lisFuns;
    }

    public List<Funcionario> listaTodos () throws SQLException, ClassNotFoundException {
        List<Funcionario> lisFuns = new ArrayList();
        daoFunc = new DaoFuncionario();
        lisFuns = daoFunc.listaTodos();
        return lisFuns;
    }

    
}
