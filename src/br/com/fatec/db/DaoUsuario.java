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
        String sql = "select * from usuario WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Usuario ret = new Usuario();
            while (rs.next()) {
                ret.SetId(rs.getInt(1));
                ret.SetNome(rs.getString(2));
                ret.SetLogin(rs.getString(3));
                ret.SetGenero(rs.getString(6));
                ret.SetCep(rs.getString(7));
                ret.SetIdade(rs.getInt(8));
            }
            
        return ret;
    }
    
    public Boolean Alterar(Usuario userModificado, Usuario user) throws SQLException{
        String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ?, genero = ?, cep = ? WHERE id = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1, userModificado.GetNome() == null ? user.GetNome() : userModificado.GetNome());
        stmt.setString(2, userModificado.GetLogin() == null ? user.GetNome() : userModificado.GetNome());
        stmt.setString(3, userModificado.GetSenha() == null ? user.GetSenha() : userModificado.GetSenha());
        stmt.setString(4, userModificado.GetGenero() == null ? user.GetGenero() : userModificado.GetGenero());
        stmt.setString(5, userModificado.GetCep() == null ? user.GetCep() : userModificado.GetCep());
        stmt.setInt(6, user.GetId());

        try {
            stmt.execute();
            stmt.close();
        }catch(Exception ex) {
        	return false;
        }
        
        return true;
    }

    public Usuario exclui(Usuario usu) throws SQLException{
        String sql = "delete from usuarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usu.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usu;
    }
    
    public Usuario validaLogin(Usuario usu) throws SQLException{
        // cria o select para ser executado no banco de dados 
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,usu.getLogin());
        stmt.setString(2,usu.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        while (rs.next()) {      
            // criando o objeto Usuario
            usu.setId(rs.getInt(1));
            usu.setNome(rs.getString(2));
            usu.setLogin(rs.getString(3));
            usu.setSenha(rs.getString(4));
            usu.setStatus(rs.getString(5));
            usu.setTipo(rs.getString(6));
            // adiciona o usu à lista de usus
        }
        
        stmt.close();
        return usu;
    }
    
    public List<Usuario> lista(Usuario usuEnt) throws SQLException{
         // usus: array armazena a lista de registros

        List<Usuario> usus = new ArrayList<>();
        
        String sql = "select * from usuarios where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            // adiciona o usu à lista de usus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
        
    }
    
    public List<Usuario> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<Usuario> usus = new ArrayList<Usuario>();
        
        String sql = "select * from usuarios";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            // adiciona o usu à lista de usus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
        
    }
    
    public Usuario inseri(Usuario usu) throws SQLException{
        String sql = "insert into usuarios" + " (nome, login, senha, status, tipo)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,usu.getNome());
        stmt.setString(2,usu.getLogin());
        stmt.setString(3,usu.getSenha());
        stmt.setString(4,usu.getStatus());
        stmt.setString(5,usu.getTipo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usu.setId(id);
        }
        stmt.close();
        return usu;
    }

}
