/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.db;

import br.com.fatec.bean.FuncionarioDepartamento;
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
public class DaoFuncionarioDepartamento {
    
    private final Connection c;
    
    public DaoFuncionarioDepartamento() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public FuncionarioDepartamento altera(FuncionarioDepartamento funDepart) throws SQLException{
        String sql = "UPDATE funcionarios_departamentos SET idFun = ?, idDep = ?, observacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,funDepart.getIdFun());
        stmt.setInt(2,funDepart.getIdDepart());
        stmt.setString(3,funDepart.getObs());
        stmt.setInt(4,funDepart.getIdFunDep());

        // executa
        stmt.execute();
        stmt.close();
        return funDepart;
    }

    public FuncionarioDepartamento exclui(FuncionarioDepartamento funDepart) throws SQLException{
        String sql = "delete from funcionarios_departamentos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,funDepart.getIdFunDep());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return funDepart;
    }


    public FuncionarioDepartamento inseri(FuncionarioDepartamento funDepart) throws SQLException{

        String sql = "insert into funcionarios_departamentos" + " (idFun, idDep, observacao)" + " values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,funDepart.getIdFun());
        stmt.setInt(2,funDepart.getIdDepart());
        stmt.setString(3,funDepart.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            funDepart.setIdFunDep(id);
        }
        stmt.close();
        c.close();
        return funDepart;

    }
    
    public FuncionarioDepartamento busca(FuncionarioDepartamento funDepart) throws SQLException{
        String sql = "select * from funcionarios_departamentos WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,funDepart.getIdFunDep());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                funDepart.setIdFunDep(rs.getInt(1));
                funDepart.setIdFun(rs.getInt(2));
                funDepart.setIdDepart(rs.getInt(3));
                funDepart.setObs(rs.getString(4));
                // adiciona o usu à lista de usus
            }
        return funDepart;
    }
    
    public List<FuncionarioDepartamento> lista(FuncionarioDepartamento funDepart) throws SQLException{

        List<FuncionarioDepartamento> funDeparts = new ArrayList<>();
        
        String sql = "select * from funcionarios_departamentos where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + funDepart.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            FuncionarioDepartamento fundepart = new FuncionarioDepartamento(
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
