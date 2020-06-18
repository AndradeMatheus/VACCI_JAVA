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
import br.com.fatec.bean.TipoFuncionario;
import java.sql.Statement;

/**
 *
 * @author ProfAlexandre
 */
public class DaoTipoFuncionario {

    private final Connection c;
    
    public DaoTipoFuncionario() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    
    public TipoFuncionario busca(TipoFuncionario tpfun) throws SQLException{
        String sql = "select * from tipo_funcionarios WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,tpfun.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                tpfun.setId(rs.getInt(1));
                tpfun.setDesc(rs.getString(2));
                // adiciona o usu à lista de usus
            }
        
            stmt.close();
            c.close();
            
        return tpfun;
    }
    
    public TipoFuncionario altera(TipoFuncionario tpfun) throws SQLException{
        String sql = "UPDATE tipo_funcionarios SET desctipo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,tpfun.getDesc());
        stmt.setInt(2,tpfun.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return tpfun;
    }

    public TipoFuncionario exclui(TipoFuncionario tpfun) throws SQLException{
        String sql = "delete from tipo_funcionarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,tpfun.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return tpfun;
    }
    
       
    public List<TipoFuncionario> lista(TipoFuncionario tpfunEnt) throws SQLException{
         // usus: array armazena a lista de registros

        List<TipoFuncionario> tpfuncs = new ArrayList<>();
        
        String sql = "select * from tipo_funcinarios where desctipo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + tpfunEnt.getDesc()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            TipoFuncionario tpfun = new TipoFuncionario(rs.getInt(1),rs.getString(2));
            // adiciona o usu à lista de usus
            tpfuncs.add(tpfun);
        }
        
        rs.close();
        stmt.close();
        return tpfuncs;
        
    }
    
    public TipoFuncionario inseri(TipoFuncionario tpfun) throws SQLException{
        String sql = "insert into tipo_funcionarios" + "(desctipo)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,tpfun.getDesc());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            tpfun.setId(id);
        }
        stmt.close();
        c.close();
        return tpfun;
    }

}
