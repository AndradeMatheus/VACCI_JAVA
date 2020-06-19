package br.com.fatec.controler;

import br.com.fatec.bean.Usuario;
import br.com.fatec.db.DaoUsuario;
import java.lang.Boolean;
import java.sql.SQLException;
import java.util.List;

public class ControleUsuario {
	
    public Usuario BuscarUsuarioPorId(Usuario user) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        user = usuDao.BuscaPorId(user.GetId());
        return user;
    }
    
    public Boolean AlterarUsuario(Usuario userModificado, Usuario user) throws SQLException, ClassNotFoundException {
        DaoUsuario userDao = new DaoUsuario();
        return userDao.Alterar(userModificado, user);
    }
	
    public Boolean ExcluirUsuario(Usuario user) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        Boolean valida = usuDao.Excluir(user);
        return valida;
    }
    
    public Boolean ValidaLogin(String login, String senha) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        Boolean valida = usuDao.ValidaLogin(login, senha);
        return valida;
    }
    
    public List<Usuario> ListarUsuarios() throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        List<Usuario> users = usuDao.Listar();
        return users;
    }
    
    public Boolean InserirUsuario(Usuario user) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        Boolean valida = usuDao.Inserir(user);
        return valida;
    }    
}
