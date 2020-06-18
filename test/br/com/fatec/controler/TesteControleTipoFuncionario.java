/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.TipoFuncionario;
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
public class TesteControleTipoFuncionario {
    
    public TesteControleTipoFuncionario() {
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
          int idE = 0;
          TipoFuncionario tpfun = new TipoFuncionario(idE,"TESTE TIPO FUNCIONARIO");
          ControleTipoFuncionario contTpFun = new ControleTipoFuncionario();
          tpfun = contTpFun.inseriTipoFuncionario(tpfun);
          assertEquals(1, tpfun.getId());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          TipoFuncionario tpfun = new TipoFuncionario(1,"");
          ControleTipoFuncionario contTpFun = new ControleTipoFuncionario();
          tpfun = contTpFun.buscaTipoFuncionarioPorId(tpfun);
          assertEquals("TESTE TIPO FUNCIONARIO", tpfun.getDesc());
    }

    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
          TipoFuncionario tpfun = new TipoFuncionario(1,"TESTE DE ALTERAÇÃO TIPO_FUN XPTO");
          ControleTipoFuncionario contTpFun = new ControleTipoFuncionario();
          tpfun = contTpFun.alteraTipoFuncionario(tpfun);
          assertEquals("TESTE DE ALTERAÇÃO TIPO_FUN XPTO", tpfun.getDesc());
    }
    
    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
          TipoFuncionario tpfun = new TipoFuncionario(2,"");
          ControleTipoFuncionario contTipoFun = new ControleTipoFuncionario();
          tpfun = contTipoFun.excluiTipoFuncionario(tpfun);
          assertEquals(1, tpfun.getId());
    }
}

