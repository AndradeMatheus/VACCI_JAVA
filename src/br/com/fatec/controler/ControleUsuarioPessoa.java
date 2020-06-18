/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.PessoaFisica;
import br.com.fatec.bean.Usuario;
import br.com.fatec.bean.UsuarioPessoa;
import br.com.fatec.db.DaoUsuarioPessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControleUsuarioPessoa {
    
    static ControleUsuario usucont = new ControleUsuario();
    static ControlePessoa pescont = new ControlePessoa();

    public UsuarioPessoa inserirUsuarioPessoa(UsuarioPessoa usupe) throws SQLException, ClassNotFoundException {
        DaoUsuarioPessoa usupesDao = new DaoUsuarioPessoa();
        usupe = usupesDao.inseri(usupe);
        return usupe;
    }
    
    public UsuarioPessoa buscarUsuarioPessoa(UsuarioPessoa usupe) throws SQLException, ClassNotFoundException {

        DaoUsuarioPessoa usupesDao = new DaoUsuarioPessoa();
        usupe = usupesDao.busca(usupe);

        Usuario usu = new Usuario(usupe.getIdUsuario(),"","","","","");
        usu = usucont.buscarUsuario(usu);
        usupe.setUsu(usu);

        PessoaFisica pesfis = new PessoaFisica(usupe.getIdPessoa(),"","","","");
        pesfis = pescont.buscarPessoa(pesfis);
        usupe.setPes(pesfis);

        return usupe;
    }
    
    public UsuarioPessoa excluirUsuarioPessoa(UsuarioPessoa usupe) throws SQLException, ClassNotFoundException {
        DaoUsuarioPessoa usupesDao = new DaoUsuarioPessoa();
        usupe = usupesDao.exclui(usupe);
        return usupe;
    }

    public UsuarioPessoa alterarUsuarioPessoa(UsuarioPessoa usupe) throws SQLException, ClassNotFoundException {
        DaoUsuarioPessoa usupesDao = new DaoUsuarioPessoa();
        usupe = usupesDao.altera(usupe);
        return usupe;
    }

    public List<UsuarioPessoa> listarUsuarioPessoa(UsuarioPessoa usupes) throws SQLException, ClassNotFoundException {

        DaoUsuarioPessoa usupesDao = new DaoUsuarioPessoa();
        List<UsuarioPessoa> ususpes = usupesDao.lista(usupes);

        for (UsuarioPessoa listaUsuarioPessoa : ususpes) {
            Usuario usu = new Usuario(listaUsuarioPessoa.getIdUsuario(),"","","","","");
            PessoaFisica pesfis = new PessoaFisica(listaUsuarioPessoa.getIdPessoa(),"","","","");
            listaUsuarioPessoa.setPes(pescont.buscarPessoa(pesfis));
            listaUsuarioPessoa.setUsu(usucont.buscarUsuario(usu));
        }

        return ususpes;
    }
}
