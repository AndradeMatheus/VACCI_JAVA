/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.db;

/**
 *
 * @author ProfAlexandre
 */
import br.com.fatec.bean.Logradouro;
import br.com.fatec.util.ConexaoDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

/**
 *
 * @author ProfAlexandre
 */

//create table db2020.lo_logradouros (
//  lo_id BIGINT NOT NULL AUTO_INCREMENT,
//  lo_cod VARCHAR(10),
//  lo_end VARCHAR(255),
//  primary key (lo_id));

public class DaoLogradouro {

    private final Connection c;
    
    public DaoLogradouro() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    
    public Logradouro busca(Logradouro log) throws SQLException{
        String sql = "select * from lo_logradouros WHERE lo_id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,log.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                log.setId(rs.getInt(1));
                log.setCod(rs.getString(2));
                log.setEnd(rs.getString(3));
                // adiciona o usu à lista de usus
            }

            stmt.close();
            c.close();
    
        return log;

    }
    
    public Logradouro altera(Logradouro log) throws SQLException{
        String sql = "UPDATE lo_logradouros SET lo_cod = ?, lo_end = ? WHERE lo_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,log.getCod());
        stmt.setString(2,log.getEnd());
        stmt.setInt(3,log.getId());

        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return log;
    }

    public Logradouro exclui(Logradouro log) throws SQLException{
        String sql = "delete from lo_logradouros WHERE lo_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,log.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return log;
    }
    
    
    public Logradouro inseri(Logradouro log) throws SQLException{
        String sql = "insert into lo_logradouros" + " (lo_cod, lo_end)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,log.getCod());
        stmt.setString(2,log.getEnd());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            log.setId(id);
        }
        stmt.close();
        c.close();
        return log;
    }

    public List<Logradouro> lista(Logradouro logEnt) throws SQLException{
         // usus: array armazena a lista de registros

        List<Logradouro> logs = new ArrayList<>();
        
        String sql = "select * from lo_logradouros where lo_end like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + logEnt.getEnd()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Logradouro
            Logradouro log = new Logradouro(rs.getInt(1),rs.getString(2),rs.getString(3));
            // adiciona o usu à lista de logs
            logs.add(log);
        }
        
        rs.close();
        stmt.close();
        return logs;
        
    }

    public List<Logradouro> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<Logradouro> logs = new ArrayList<>();
        
        String sql = "select * from lo_logradouros";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Logradouro
            Logradouro log = new Logradouro(rs.getInt(1),rs.getString(2),rs.getString(3));
            // adiciona o usu à lista de logs
            logs.add(log);
        }
        
        rs.close();
        stmt.close();
        return logs;
        
    }

}

