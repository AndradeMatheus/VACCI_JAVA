/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;


import br.com.fatec.bean.Logradouro;
import br.com.fatec.db.DaoLogradouro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControleLogradouro {
    
    public static DaoLogradouro daoLog;

    public Logradouro buscaLogradouroPorId (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.busca(log);
    }

    public Logradouro inseriLogradouro (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.inseri(log);
    }

    public Logradouro alteraLogradouro (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.altera(log);
    }

    public Logradouro excluiLogradouro (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.exclui(log);
    }

    public List<Logradouro> listaLogradouro (Logradouro log) throws SQLException, ClassNotFoundException {
        List<Logradouro> listLogs = new ArrayList();
        daoLog = new DaoLogradouro();
        listLogs = daoLog.lista(log);
        return listLogs;
    }

    public List<Logradouro> listaTodos () throws SQLException, ClassNotFoundException {
        List<Logradouro> listLogs = new ArrayList();
        daoLog = new DaoLogradouro();
        listLogs = daoLog.listaTodos();
        return listLogs;
    }

}
