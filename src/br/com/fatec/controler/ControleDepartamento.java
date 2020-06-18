/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Departamento;
import br.com.fatec.db.DaoDepartamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControleDepartamento {
    
    public static DaoDepartamento daoDep;

    public Departamento buscaDepartamentoPorId (Departamento dep) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.busca(dep);
    }

    public Departamento inseriDepartamento (Departamento dep) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.inseri(dep);
    }

    public Departamento alteraDepartamento (Departamento dep) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.altera(dep);
    }

    public Departamento excluiDepartamento (Departamento dep) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.exclui(dep);
    }

    public List<Departamento> listaDepartamento (Departamento dep) throws SQLException, ClassNotFoundException {
        List<Departamento> listDepart = new ArrayList();
        daoDep = new DaoDepartamento();
        listDepart = daoDep.lista(dep);
        return listDepart;
    }
}