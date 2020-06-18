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
import br.com.fatec.bean.Dependente;
import java.sql.Statement;

/**
 *
 * @author ProfAlexandre
 */
public class DaoDependente {

    private final Connection c;
    
    public DaoDependente() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    
    public Dependente busca(Dependente dep) throws SQLException{
        String sql = "select * from dependentes WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,dep.getIdDep());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                dep.setIdDep(rs.getInt(1));
                dep.setNomeDep(rs.getString(2));
                // adiciona o usu à lista de usus
            }
        
            stmt.close();
            c.close();
            
        return dep;
    }
    
    public Dependente altera(Dependente dep) throws SQLException{
        String sql = "UPDATE dependentes SET nome = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,dep.getNomeDep());
        stmt.setInt(2,dep.getIdDep());

        // executa
        stmt.execute();
        stmt.close();
        return dep;
    }

    public Dependente exclui(Dependente dep) throws SQLException{
        String sql = "delete from dependentes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,dep.getIdDep());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return dep;
    }
    
       
    public List<Dependente> lista(Dependente depEnt) throws SQLException{
         // usus: array armazena a lista de registros

        List<Dependente> depends = new ArrayList<>();
        
        String sql = "select * from dependentes where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + depEnt.getNomeDep()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Dependente dep = new Dependente(rs.getInt(1),rs.getString(2));
            // adiciona o usu à lista de usus
            depends.add(dep);
        }
        
        rs.close();
        stmt.close();
        return depends;
        
    }
    
    public Dependente inseri(Dependente dep) throws SQLException{
        String sql = "insert into dependentes" + "(nome)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,dep.getNomeDep());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            dep.setIdDep(id);
        }
        stmt.close();
        return dep;
    }

    public List<Dependente> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<Dependente> depends = new ArrayList<>();
        
        String sql = "select * from dependentes";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Dependente dep = new Dependente(rs.getInt(1),rs.getString(2));
            // adiciona o usu à lista de usus
            depends.add(dep);
        }
        
        rs.close();
        stmt.close();
        return depends;
        
    }


}
