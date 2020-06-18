/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.db;

import br.com.fatec.bean.FuncionarioDependente;
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
public class DaoFuncionarioDependente {
    
    private final Connection c;
    
    public DaoFuncionarioDependente() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public FuncionarioDependente altera(FuncionarioDependente funDep) throws SQLException{
        String sql = "UPDATE funcionarios_dependentes SET idFun = ?, idDepe = ?, observacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,funDep.getIdFun());
        stmt.setInt(2,funDep.getIdDep());
        stmt.setString(3,funDep.getObs());
        stmt.setInt(4,funDep.getIdFunDep());

        // executa
        stmt.execute();
        stmt.close();
        return funDep;
    }

    public FuncionarioDependente exclui(FuncionarioDependente funDep) throws SQLException{
        String sql = "delete from funcionarios_dependentes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,funDep.getIdFunDep());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return funDep;
    }


    public FuncionarioDependente inseri(FuncionarioDependente funDep) throws SQLException{

        String sql = "insert into funcionarios_dependentes" + " (idFun, idDepe, observacao)" + " values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,funDep.getIdFun());
        stmt.setInt(2,funDep.getIdDep());
        stmt.setString(3,funDep.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            funDep.setIdFunDep(id);
        }
        stmt.close();
        c.close();
        return funDep;

    }
    
    public FuncionarioDependente busca(FuncionarioDependente funDep) throws SQLException{
        String sql = "select * from funcionarios_dependentes WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,funDep.getIdFunDep());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                funDep.setIdFunDep(rs.getInt(1));
                funDep.setIdFun(rs.getInt(2));
                funDep.setIdDep(rs.getInt(3));
                funDep.setObs(rs.getString(4));
                // adiciona o usu à lista de usus
            }
        return funDep;
    }
    
    public List<FuncionarioDependente> lista(FuncionarioDependente funDep) throws SQLException{

        List<FuncionarioDependente> funDeparts = new ArrayList<>();
        
        String sql = "select * from funcionarios_dependentes where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + funDep.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            FuncionarioDependente fundepart = new FuncionarioDependente(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            funDeparts.add(fundepart);
        }
        
        rs.close();
        stmt.close();
        return funDeparts;
    }
    
}