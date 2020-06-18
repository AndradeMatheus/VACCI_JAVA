/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.PessoaFisica;
import br.com.fatec.bean.Logradouro;
import br.com.fatec.bean.PessoaLogradouro;
import br.com.fatec.db.DaoPessoaLogradouro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControlePessoaLogradouro {
    
    public static ControlePessoa  contPes;
    public static ControleLogradouro contLoge;
    public static DaoPessoaLogradouro daoPesLog;
    
    public PessoaLogradouro buscarPessoaLogradouroPorId(PessoaLogradouro pesLog) throws SQLException, ClassNotFoundException {

        daoPesLog = new DaoPessoaLogradouro();
        pesLog = daoPesLog.busca(pesLog);
        
        contPes = new ControlePessoa();
        contLoge = new ControleLogradouro();

        PessoaFisica pe = new PessoaFisica(pesLog.getIdPes(),"","","","");
        Logradouro log = new Logradouro(pesLog.getIdLog(),"","");
        
        pesLog.setP(contPes.buscarPessoa(pe));
        pesLog.setL(contLoge.buscaLogradouroPorId(log));

        return pesLog;
    }
    
    public PessoaLogradouro inserirPessoaLogradouro(PessoaLogradouro pesLog) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoaLogradouro();
        return daoPesLog.inseri(pesLog);
    }
 
    public PessoaLogradouro alterarPessoaLogradouro(PessoaLogradouro pesLog) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoaLogradouro();
        return daoPesLog.altera(pesLog);
    }

    public PessoaLogradouro excluirPessoaLogradouro(PessoaLogradouro pesLog) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoaLogradouro();
        return daoPesLog.exclui(pesLog);
    }

    public List<PessoaLogradouro> listarPessoaLogradouro(PessoaLogradouro pesLog) throws SQLException, ClassNotFoundException {

        daoPesLog = new DaoPessoaLogradouro();

        List<PessoaLogradouro> pesLogs = daoPesLog.lista(pesLog);
        
        contPes = new ControlePessoa();
        contLoge = new ControleLogradouro();
        for (PessoaLogradouro listaPL : pesLogs) {
            PessoaFisica pe = new PessoaFisica(listaPL.getIdPes(),"","","","");
            Logradouro log = new Logradouro(listaPL.getIdLog(),"","");
            listaPL.setP(contPes.buscarPessoa(pe));
            listaPL.setL(contLoge.buscaLogradouroPorId(log));
            listaPL.toString();
        }

        return pesLogs;
    }
}
