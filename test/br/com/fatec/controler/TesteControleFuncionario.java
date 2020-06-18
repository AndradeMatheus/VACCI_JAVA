/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Funcionario;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ProfAlexandre
 */
public class TesteControleFuncionario {
    
    public TesteControleFuncionario() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void inserir() throws SQLException, ClassNotFoundException {
          Funcionario fun = new Funcionario(0,"TESTE FUNCIONARIO");
          ControleFuncionario contFun = new ControleFuncionario();
          fun = contFun.inseriFuncionario(fun);
          assertEquals(4, fun.getIdFunc());
    }

    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
          Funcionario fun = new Funcionario(3,"");
          ControleFuncionario contFun = new ControleFuncionario();
          fun = contFun.excluiFuncionario(fun);
          assertEquals(3, fun.getIdFunc());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          Funcionario fun = new Funcionario(4,"");
          ControleFuncionario contFun = new ControleFuncionario();
          fun = contFun.buscaFuncionarioPorId(fun);
          assertEquals(4, fun.getIdFunc());
    }

    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
          Funcionario fun = new Funcionario(4,"TESTE DE ALTERAÇÃO 4");
          ControleFuncionario contFun = new ControleFuncionario();
          fun = contFun.alteraFuncionario(fun);
          assertEquals("TESTE DE ALTERAÇÃO 4", fun.getNomeFunc());
    }


}
