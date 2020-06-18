/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Dependente;
import br.com.fatec.db.DaoDependente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */

//create table db2020.dependentes (
  //id BIGINT NOT NULL AUTO_INCREMENT,
  //nome VARCHAR(255),
  //primary key (id));

public class ControleDependente {
    
    public static DaoDependente daoDep;

    public Dependente buscaDependentePorId (Dependente dep) throws SQLException,ClassNotFoundException {
        daoDep = new DaoDependente();
        return daoDep.busca(dep);
    }

    public Dependente inseriDependente (Dependente dep) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDependente();
        return daoDep.inseri(dep);
    }

    public Dependente alteraDependente (Dependente dep) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDependente();
        return daoDep.altera(dep);
    }

    public Dependente excluiDependente (Dependente dep) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDependente();
        return daoDep.exclui(dep);
    }

    public List<Dependente> listaDependente (Dependente dep) throws SQLException, ClassNotFoundException {
        List<Dependente> lisDeps = new ArrayList();
        daoDep = new DaoDependente();
        lisDeps = daoDep.lista(dep);
        return lisDeps;
    }

    public List<Dependente> listaTodos () throws SQLException, ClassNotFoundException {
        List<Dependente> lisDeps = new ArrayList();
        daoDep = new DaoDependente();
        lisDeps = daoDep.listaTodos();
        return lisDeps;
    }

    
}
