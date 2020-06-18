/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.FuncionarioDepartamento;
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
public class TesteControleFuncionarioDepartamento {
    
    public TesteControleFuncionarioDepartamento() {
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
          FuncionarioDepartamento funDep = new FuncionarioDepartamento(0,4,1,"TESTE RELACAO");
          ControleFuncionarioDepartamento contFunDep = new ControleFuncionarioDepartamento();
          funDep = contFunDep.inserirFuncionarioDepartamento(funDep);
          assertEquals(2, funDep.getIdFunDep());
    }

    @Test
    public void lista() throws SQLException, ClassNotFoundException {
          FuncionarioDepartamento funDep = new FuncionarioDepartamento(0,0,0,"RELACAO");
          ControleFuncionarioDepartamento contFunDep = new ControleFuncionarioDepartamento();
          List<FuncionarioDepartamento> listaFP = new ArrayList();
          listaFP = contFunDep.listarFuncionarioDepartamento(funDep);
          assertEquals(1, listaFP.get(0).getIdFunDep());
    }

}
