/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.db;

import br.com.fatec.bean.Departamento;
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
public class DaoDepartamento {
    
    private final Connection c;
    
    public DaoDepartamento() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public Departamento busca (Departamento dep) throws SQLException {
        String sql = "select * from departamentos WHERE id = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,dep.getIdDepart());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                dep.setIdDepart(rs.getInt(1));
                dep.setNomeDepart(rs.getString(2));
                // adiciona o usu à lista de usus
            }
            stmt.close();
            c.close();
        return dep;
    }

    public Departamento inseri (Departamento dep) throws SQLException {

        String sql = "insert into departamentos" + " (nome)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,dep.getNomeDepart());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            dep.setIdDepart(id);
        }
        stmt.close();
        c.close();
        return dep;
    }

    public Departamento altera (Departamento dep) throws SQLException {

        String sql = "UPDATE departamentos SET nome = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,dep.getNomeDepart());
        stmt.setInt(2,dep.getIdDepart());

        // executa
        stmt.execute();
        stmt.close();
        return dep;
    }

    public Departamento exclui (Departamento dep) throws SQLException {
        String sql = "select * from departamentos WHERE id = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,dep.getIdDepart());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                dep.setIdDepart(rs.getInt(1));
                dep.setNomeDepart(rs.getString(2));
                // adiciona o usu à lista de usus
            }
        return dep;
    }

    public List<Departamento> lista (Departamento dep) throws SQLException {
        String sql = "select * from departamentos WHERE id = ?";
        List<Departamento> lista = new ArrayList<>();
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,dep.getIdDepart());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	Departamento depList = new Departamento();
                // criando o objeto Usuario
                depList.setIdDepart(rs.getInt(1));
                depList.setNomeDepart(rs.getString(2));
                lista.add(depList);
                // adiciona o usu à lista de usus
            }
        return lista;  
    }
}
