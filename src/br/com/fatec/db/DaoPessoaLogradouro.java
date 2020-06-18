/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.db;

import br.com.fatec.bean.PessoaLogradouro;
import br.com.fatec.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class DaoPessoaLogradouro {
    
    private final Connection c;
    
    public DaoPessoaLogradouro() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public PessoaLogradouro altera(PessoaLogradouro pesLog) throws SQLException{
        String sql = "UPDATE pl_pessoas_logradouros SET pl_pe_id = ?, pl_lo_id = ?, pl_obs = ? WHERE pl_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesLog.getIdPes());
        stmt.setInt(2,pesLog.getIdLog());
        stmt.setString(3,pesLog.getObs());
        stmt.setInt(4,pesLog.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pesLog;
    }

    public PessoaLogradouro exclui(PessoaLogradouro pesLog) throws SQLException{
        String sql = "delete from pl_pessoas_logradouros WHERE pl_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesLog.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pesLog;
    }


    public PessoaLogradouro inseri(PessoaLogradouro pesLog) throws SQLException{

        String sql = "insert into pl_pessoas_logradouros" + " (pl_pe_id, pl_lo_id, pl_obs)" + " values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,pesLog.getIdPes());
        stmt.setInt(2,pesLog.getIdLog());
        stmt.setString(3,pesLog.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pesLog.setId(id);
        }
        stmt.close();
        c.close();
        return pesLog;

    }
    
    public PessoaLogradouro busca(PessoaLogradouro pesLog) throws SQLException{
        String sql = "select * from pl_pessoas_logradouros WHERE pl_id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pesLog.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                pesLog.setId(rs.getInt(1));
                pesLog.setIdPes(rs.getInt(2));
                pesLog.setIdLog(rs.getInt(3));
                pesLog.setObs(rs.getString(4));
                // adiciona o usu à lista de usus
            }
        return pesLog;
    }
    
    public List<PessoaLogradouro> lista(PessoaLogradouro pesLog) throws SQLException{

        List<PessoaLogradouro> peslogs = new ArrayList<>();
        
        String sql = "select * from pl_pessoas_logradouros where pl_obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pesLog.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoaLogradouro peslogl = new PessoaLogradouro(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            peslogs.add(peslogl);
        }
        
        rs.close();
        stmt.close();
        return peslogs;
    }

}