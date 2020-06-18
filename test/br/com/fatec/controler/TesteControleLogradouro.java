/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Logradouro;
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
public class TesteControleLogradouro {
    
    public TesteControleLogradouro() {
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
          Logradouro log = new Logradouro(0,"02210-000","TESTE");
          ControleLogradouro contLog = new ControleLogradouro();
          log = contLog.inseriLogradouro(log);
          assertEquals("02210-000", log.getCod());
    }

    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
          Logradouro log = new Logradouro(4,"","");
          ControleLogradouro contLog = new ControleLogradouro();
          log = contLog.excluiLogradouro(log);
          assertEquals(4, log.getId());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          Logradouro log = new Logradouro(1,"","");
          ControleLogradouro contLog = new ControleLogradouro();
          log = contLog.buscaLogradouroPorId(log);
          assertEquals("02323-000", log.getCod());
    }

    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
          Logradouro log = new Logradouro(2,"02525-000","TESTE DE ALTERACAO");
          ControleLogradouro contLog = new ControleLogradouro();
          log = contLog.alteraLogradouro(log);
          assertEquals("02525-000", log.getCod());
    }

}
