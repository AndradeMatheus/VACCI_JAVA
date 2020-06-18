/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.PessoaFisica;
import br.com.fatec.db.DaoPessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControlePessoa {
    
    public static DaoPessoa pesDao;
    
    public List<PessoaFisica> listarTodosPessoa() throws SQLException, ClassNotFoundException {
        List<PessoaFisica>  pess ;
        pesDao = new DaoPessoa();
        pess = pesDao.listaTodos();
        return pess;
    }
    
    public List<PessoaFisica> listarPessoa(PessoaFisica pe) throws SQLException, ClassNotFoundException {
        List<PessoaFisica>  pess ;
        pesDao = new DaoPessoa();
        pess = pesDao.lista(pe);
        return pess;
    }

    public PessoaFisica buscarPessoa(PessoaFisica pes) throws SQLException, ClassNotFoundException {
        pesDao = new DaoPessoa();
        return pesDao.busca(pes);
    }

   public PessoaFisica inserirPessoa(PessoaFisica pes) throws SQLException, ClassNotFoundException {
        pesDao = new DaoPessoa();
        return pesDao.inseri(pes);
    }

    public PessoaFisica excluirPessoa(PessoaFisica pes) throws SQLException, ClassNotFoundException {
        pesDao = new DaoPessoa();
        return pesDao.exclui(pes);
    }

    public PessoaFisica alterarPessoa(PessoaFisica usu) throws SQLException, ClassNotFoundException {
        pesDao = new DaoPessoa();
        return pesDao.altera(usu);
    }


}
