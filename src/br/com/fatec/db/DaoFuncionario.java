/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.db;

import br.com.fatec.util.ConexaoDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.fatec.bean.Funcionario;
import java.sql.Statement;

/**
 *
 * @author ProfAlexandre
 */
public class DaoFuncionario {

    private final Connection c;
    
    public DaoFuncionario() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    
    public Funcionario busca(Funcionario fun) throws SQLException{
        String sql = "select * from funcionarios WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,fun.getIdFunc());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                fun.setIdFunc(rs.getInt(1));
                fun.setNomeFunc(rs.getString(2));
                // adiciona o usu à lista de usus
            }
        
            stmt.close();
            c.close();
            
        return fun;
    }
    
    public Funcionario altera(Funcionario fun) throws SQLException{
        String sql = "UPDATE funcionarios SET nome = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,fun.getNomeFunc());
        stmt.setInt(2,fun.getIdFunc());

        // executa
        stmt.execute();
        stmt.close();
        return fun;
    }

    public Funcionario exclui(Funcionario fun) throws SQLException{
        String sql = "delete from funcionarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,fun.getIdFunc());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return fun;
    }
    
       
    public List<Funcionario> lista(Funcionario funEnt) throws SQLException{
         // usus: array armazena a lista de registros

        List<Funcionario> funcs = new ArrayList<>();
        
        String sql = "select * from funcionarios where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + funEnt.getNomeFunc()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Funcionario fun = new Funcionario(rs.getInt(1),rs.getString(2));
            // adiciona o usu à lista de usus
            funcs.add(fun);
        }
        
        rs.close();
        stmt.close();
        return funcs;
        
    }
    
    public Funcionario inseri(Funcionario fun) throws SQLException{
        String sql = "insert into funcionarios" + "(nome)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,fun.getNomeFunc());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            fun.setIdFunc(id);
        }
        stmt.close();
        return fun;
    }
    
    public List<Funcionario> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<Funcionario> funs = new ArrayList<>();
        
        String sql = "select * from funcionarios";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Funcionario fun = new Funcionario(
                rs.getInt(1),
                rs.getString(2)
            );
            // adiciona o usu à lista de usus
            funs.add(fun);
        }
        
        rs.close();
        stmt.close();
        return funs;
        
    }


}
