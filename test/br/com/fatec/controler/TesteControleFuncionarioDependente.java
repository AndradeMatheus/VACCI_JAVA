package br.com.fatec.controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.fatec.bean.FuncionarioDependente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class TesteControleFuncionarioDependente {
    
    public TesteControleFuncionarioDependente() {
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
          FuncionarioDependente funDepe = new FuncionarioDependente(0,2,3,"TESTE RELACAO");
          ControleFuncionarioDependente contFunDep = new ControleFuncionarioDependente();
          funDepe = contFunDep.inserirFuncionarioDependente(funDepe);
          assertEquals(5, funDepe.getIdFunDep());
    }

    @Test
    public void busca() throws SQLException, ClassNotFoundException {
          FuncionarioDependente funDep = new FuncionarioDependente(1,0,0,"");
          ControleFuncionarioDependente contFunDep = new ControleFuncionarioDependente();
          funDep = contFunDep.buscarFuncionarioDependentePorId(funDep);
          
          System.out.println("IMPRESSAO TESTE DE BUSCA " + funDep.toString());
          
          assertEquals(1, funDep.getIdFunDep());
    }

    
    @Test
    public void lista() throws SQLException, ClassNotFoundException {
          FuncionarioDependente funDep = new FuncionarioDependente(0,0,0,"RELACAO");
          ControleFuncionarioDependente contFunDep = new ControleFuncionarioDependente();
          List<FuncionarioDependente> listaFP = new ArrayList();
          listaFP = contFunDep.listarFuncionarioDependente(funDep);

          System.out.println("IMPRESSAO TESTE DE LISTA " + listaFP.get(0).toString());


          assertEquals(1, listaFP.get(0).getIdFunDep());
    }

    
}
