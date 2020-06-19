package br.com.fatec.db;

import br.com.fatec.util.ConexaoDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.fatec.bean.Usuario;
import java.sql.Statement;

public class DaoUsuario {

    private final Connection c;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public Usuario BuscaPorId(int id) throws SQLException{
        String sql = "SELECT u.id_usuario, u.nm_usuario, u.nm_login, u.nm_senha, "
        		+ "dg.nm_genero, u.nm_cep, u.id_idade FROM usuario u JOIN dom_genero dg "
        		+ "ON u.tp_genero = dg.tp_genero WHERE id_usuario = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Usuario ret = new Usuario();
            while (rs.next()) {
                ret.SetId(rs.getInt(1));
                ret.SetNome(rs.getString(2));
                ret.SetLogin(rs.getString(3));
                ret.SetSenha(rs.getString(4));
                ret.SetGeneroDescricao(rs.getString(5));
                ret.SetCep(rs.getString(6));
                ret.SetIdade(rs.getInt(7));
            }
            
            stmt.close();
            c.close();
            
        return ret;
    }
    
    public Boolean Alterar(Usuario userModificado, Usuario user) throws SQLException{
        String sql = "UPDATE usuario SET nm_usuario = ?, nm_login = ?, "
        		+ "nm_senha = ?, nm_genero = ?, nm_cep = ?, id_dade = ?, WHERE id_usuario = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1, userModificado.GetNome() == null ? user.GetNome() : userModificado.GetNome());
        stmt.setString(2, userModificado.GetLogin() == null ? user.GetNome() : userModificado.GetNome());
        stmt.setString(3, userModificado.GetSenha() == null ? user.GetSenha() : userModificado.GetSenha());
        stmt.setInt(4, userModificado.GetGeneroTipo() == 0 ? user.GetGeneroTipo() : userModificado.GetGeneroTipo());
        stmt.setString(5, userModificado.GetCep() == null ? user.GetCep() : userModificado.GetCep());
        stmt.setInt(6, userModificado.GetIdade() == 0 ? user.GetIdade() : userModificado.GetIdade());
        stmt.setInt(7, user.GetId());

        try {
            stmt.execute();
        }catch(Exception ex) {
        	return false;
        }finally {
            stmt.close();
            c.close();
        }
        
        return true;
    }

    public Boolean Excluir(Usuario user) throws SQLException{
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1, user.GetId());
        
        try {
        	stmt.execute();	
        }catch(Exception ex) {
        	return false;
        }finally {
            stmt.close();
            c.close();
        }
               
        return true;
    }
    
    public Boolean ValidaLogin(String login, String senha) throws SQLException{
        String sql = "select * from usuarios WHERE nm_login = ? AND nm_senha = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1, login);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();
        stmt.close();
        
        if(rs.next())
        	return true;
        else
        	return false;
        
    }
    
    public List<Usuario> Listar() throws SQLException{
        List<Usuario> users = new ArrayList<Usuario>();
        
        String sql = "SELECT u.id_usuario, u.nm_usuario, u.nm_login, u.nm_senha, u.tp_genero, "
        		+ "dg.nm_genero, u.nm_cep, u.id_idade FROM usuario u JOIN dom_genero dg "
        		+ "ON u.tp_genero = dg.tp_genero";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Usuario user = new Usuario(
            		rs.getInt(1),
            		rs.getString(2),
            		rs.getString(3),
            		rs.getString(4),
            		rs.getInt(5), 
            		rs.getString(6),
            		rs.getString(7),
            		rs.getInt(8)
            );
            users.add(user);
        }
        
        rs.close();
        stmt.close();
        return users; 
    }
    
    public Boolean Inserir(Usuario user) throws SQLException{
        String sql = "INSERT INTO usuario(nm_usuario, nm_login, nm_senha, tp_genero,"
        		+ " nm_cep, id_dade)" + " values (?,?,?,?,?,?)";
    
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, user.GetNome());
        stmt.setString(2, user.GetLogin());
        stmt.setString(3, user.GetSenha());
        stmt.setInt(4, user.GetGeneroTipo());
        stmt.setString(5, user.GetCep());
        stmt.setInt(6, user.GetIdade());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        stmt.close();
        		
        if (rs.next())
        	return true;
        else
        	return false;
    }
}