/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.TipoFuncionario;
import br.com.fatec.db.DaoTipoFuncionario;
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

public class ControleTipoFuncionario {
    
    public static DaoTipoFuncionario daoTpFunc;

    public TipoFuncionario buscaTipoFuncionarioPorId (TipoFuncionario tpfunc) throws SQLException,ClassNotFoundException {
        daoTpFunc = new DaoTipoFuncionario();
        return daoTpFunc.busca(tpfunc);
    }

    public TipoFuncionario inseriTipoFuncionario (TipoFuncionario tpfunc) throws SQLException, ClassNotFoundException {
        daoTpFunc = new DaoTipoFuncionario();
        return daoTpFunc.inseri(tpfunc);
    }

    public TipoFuncionario alteraTipoFuncionario (TipoFuncionario tpfunc) throws SQLException, ClassNotFoundException {
        daoTpFunc = new DaoTipoFuncionario();
        return daoTpFunc.altera(tpfunc);
    }

    public TipoFuncionario excluiTipoFuncionario (TipoFuncionario tpfunc) throws SQLException, ClassNotFoundException {
        daoTpFunc = new DaoTipoFuncionario();
        return daoTpFunc.exclui(tpfunc);
    }

    public List<TipoFuncionario> listaTipoFuncionario (TipoFuncionario tpfunc) throws SQLException, ClassNotFoundException {
        List<TipoFuncionario> listpFuns = new ArrayList();
        daoTpFunc = new DaoTipoFuncionario();
        listpFuns = daoTpFunc.lista(tpfunc);
        return listpFuns;
    }
}

