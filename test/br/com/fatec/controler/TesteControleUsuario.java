/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.Usuario;
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
public class TesteControleUsuario {
    
    public TesteControleUsuario() {
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
    public void testeLogin() throws SQLException, ClassNotFoundException {
          Usuario usu = new Usuario(0,"","BITTENCOURT","ABFABF010101","","");
          ControleUsuario usucont = new ControleUsuario();
          usu = usucont.validaUsuario(usu);
          assertEquals("ADM", usu.getTipo());
    }

    @Test
    public void testebuscaUsuario() throws SQLException, ClassNotFoundException {
          Usuario usu = new Usuario(13,"","","","","");
          ControleUsuario usucont = new ControleUsuario();
          usu = usucont.buscarUsuario(usu);
          assertEquals("123", usu.getSenha());
    }


}
