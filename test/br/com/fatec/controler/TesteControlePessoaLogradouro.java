/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controler;

import br.com.fatec.bean.PessoaLogradouro;
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
public class TesteControlePessoaLogradouro {
    
    public TesteControlePessoaLogradouro() {
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

    @Test
    public void inserir() throws SQLException, ClassNotFoundException {
          PessoaLogradouro peslog = new PessoaLogradouro(0,2,4,"TESTE RELACAO LOGRADOURO");
          ControlePessoaLogradouro contPesLog = new ControlePessoaLogradouro();
          peslog = contPesLog.inserirPessoaLogradouro(peslog);
          assertEquals(12, peslog.getId());
    }

    @Test
    public void busca() throws SQLException, ClassNotFoundException {
          PessoaLogradouro peslog = new PessoaLogradouro(2,0,0,"");
          ControlePessoaLogradouro contPesLog = new ControlePessoaLogradouro();
          peslog = contPesLog.buscarPessoaLogradouroPorId(peslog);
          assertEquals("TESTE LAIS", peslog.getObs());
    }

    @Test
    public void altera() throws SQLException, ClassNotFoundException {
          PessoaLogradouro peslog = new PessoaLogradouro(6,2,4,"TESTE TESTE TESTE");
          ControlePessoaLogradouro contPesLog = new ControlePessoaLogradouro();
          peslog = contPesLog.alterarPessoaLogradouro(peslog);
          assertEquals("TESTE TESTE TESTE", peslog.getObs());
    }

    @Test
    public void exclui() throws SQLException, ClassNotFoundException {
          PessoaLogradouro peslog = new PessoaLogradouro(8,0,0,"");
          ControlePessoaLogradouro contPesLog = new ControlePessoaLogradouro();
          peslog = contPesLog.excluirPessoaLogradouro(peslog);
          assertEquals(8, peslog.getId());
    }

    
    @Test
    public void lista() throws SQLException, ClassNotFoundException {
          PessoaLogradouro peslog = new PessoaLogradouro(0,0,0,"TESTE");
          ControlePessoaLogradouro contPesLog = new ControlePessoaLogradouro();
          List<PessoaLogradouro> listaPL = new ArrayList();
          listaPL = contPesLog.listarPessoaLogradouro(peslog);

          System.out.println("IMPRESSAO TESTE DE LISTA " + listaPL.get(0).toString());

          assertEquals(1, listaPL.get(0).getId());
    }

    
    
}
