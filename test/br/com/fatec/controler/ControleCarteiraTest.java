package br.com.fatec.controler;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import br.com.fatec.bean.Carteira;
import java.util.List;

class ControleCarteiraTest {

	@Test
	void testInserirCarteira() throws ClassNotFoundException, SQLException {
		Carteira cart = new Carteira(0, 24, 1);
		
		ControleCarteira cartController = new ControleCarteira();
		Boolean valida = cartController.InserirCarteira(cart);
		Carteira cartNova = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);

		if(valida)
			assertEquals(cart.GetUsuarioId(), cartNova.GetUsuarioId());
		else
			assertTrue(false);
	}

	@Test
	void testListarCarteiras() throws ClassNotFoundException, SQLException {
		ControleCarteira cartController = new ControleCarteira();
		List<Carteira> carts = cartController.ListarCarteiras();

		assertNotNull(carts);
	}

	@Test
	void testBuscarCarteiraPorId() throws ClassNotFoundException, SQLException {
		ControleCarteira cartController = new ControleCarteira();
		Carteira cart = cartController.BuscarCarteiraPorId(new Carteira(1, 0, 0));

		Carteira cartComparison = cartController.ListarCarteiras().get(1);

		assertEquals(cart.GetId(), cartComparison.GetId());
	}

	@Test
	void testAlterarUsuario() throws ClassNotFoundException, SQLException{
		ControleCarteira cartController = new ControleCarteira();

		Carteira cart = new Carteira();
		cart.SetId(1);
		cart = cartController.BuscarCarteiraPorId(cart);

		Carteira cartModificado = new Carteira();
		cartModificado.SetCarteiraTipo(2);

		Boolean valida = cartController.AlterarCarteira(cartModificado, cart);

		if(valida)
			assertEquals(cartModificado.GetCarteiraTipo(), cartController.BuscarCarteiraPorId(cart).GetCarteiraTipo());
		else
			assertTrue(false);
	}

	@Test
	void testExcluirUsuario() throws ClassNotFoundException, SQLException{
		Boolean validaExclusao;
		Carteira ultimaCarteira = new Carteira();

		Carteira cart = new Carteira(0, 33, 3);

		ControleCarteira cartController = new ControleCarteira();
		Boolean validaInsercao = cartController.InserirCarteira(cart);

		if(validaInsercao){
			validaExclusao = cartController.ExcluirCarteira(cart);
			if(validaExclusao){
				ultimaCarteira = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);
			}
		}

		assertNotEquals(ultimaCarteira.GetUsuarioId(), cart.GetUsuarioId());
	}
}
