/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Dependente;
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
public class TesteControleDependente {
    
    public TesteControleDependente() {
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
         Dependente dep = new Dependente(0,"TESTE DEPENDENTE");
         ControleDependente contDep = new ControleDependente();
         dep = contDep.inseriDependente(dep);
         assertEquals(5, dep.getIdDep());
   }


    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
          Dependente dep = new Dependente(4,"");
          ControleDependente contDep = new ControleDependente();
          dep = contDep.excluiDependente(dep);
          assertEquals(4, dep.getIdDep());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          Dependente dep = new Dependente(5,"");
          ControleDependente contDep = new ControleDependente();
          dep = contDep.buscaDependentePorId(dep);
          assertEquals("TESTE DEPENDENTE", dep.getNomeDep());
    }

    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
          Dependente dep = new Dependente(5,"TESTE DE ALTERAÇÃO 5");
          ControleDependente contDep = new ControleDependente();
          dep = contDep.alteraDependente(dep);
          assertEquals("TESTE DE ALTERAÇÃO 5", dep.getNomeDep());
    }
    
    
    

}
