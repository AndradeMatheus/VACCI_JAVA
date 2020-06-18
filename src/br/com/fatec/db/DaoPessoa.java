/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.db;

import br.com.fatec.bean.PessoaFisica;
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


public class DaoPessoa {
    
    private final Connection c;
    
    public DaoPessoa() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public List<PessoaFisica> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<PessoaFisica> pess = new ArrayList<>();
        
        String sql = "select * from pe_pessoas";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoaFisica pes = new PessoaFisica(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)   
            );
            // adiciona o usu à lista de usus
            pess.add(pes);
        }
        
        rs.close();
        stmt.close();
        return pess;
        
    }

    public List<PessoaFisica> lista(PessoaFisica pesEnt) throws SQLException{
         // usus: array armazena a lista de registros

        List<PessoaFisica> pess = new ArrayList<>();
        
        String sql = "select * from pe_pessoas where pe_nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pesEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoaFisica pe = new PessoaFisica(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            pess.add(pe);
        }
        
        rs.close();
        stmt.close();
        return pess;
        
    }

    public PessoaFisica busca(PessoaFisica pes) throws SQLException{
        String sql = "select * from pe_pessoas WHERE pe_id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pes.getIdPessoa());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                pes.setIdPessoa(rs.getInt(1));
                pes.setNome(rs.getString(2));
                pes.setCpf(rs.getString(3));
                pes.setTipo(rs.getString(4));
                pes.setEmail(rs.getString(5));
                // adiciona o usu à lista de usus
            }
        return pes;
    }
    
    public PessoaFisica altera(PessoaFisica pes) throws SQLException{
        String sql = "UPDATE pe_pessoas SET pe_nome = ?, pe_cpf = ?, pe_tipo = ?, pe_email = ? WHERE pe_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,pes.getNome());
        stmt.setString(2,pes.getCpf());
        stmt.setString(3,pes.getTipo());
        stmt.setString(4,pes.getEmail());
        stmt.setInt(5,pes.getIdPessoa());

        // executa
        stmt.execute();
        stmt.close();
        return pes;
    }

    public PessoaFisica exclui(PessoaFisica pes) throws SQLException{
        String sql = "delete from pe_pessoas WHERE pe_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pes.getIdPessoa());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pes;
    }
    
    public PessoaFisica inseri(PessoaFisica pes) throws SQLException{
        String sql = "insert into pe_pessoas" + " (pe_nome, pe_cpf, pe_tipo, pe_email)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,pes.getNome());
        stmt.setString(2,pes.getCpf());
        stmt.setString(3,pes.getTipo());
        stmt.setString(4,pes.getEmail());
 
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pes.setIdPessoa(id);
        }
        stmt.close();
        return pes;
    }




}
