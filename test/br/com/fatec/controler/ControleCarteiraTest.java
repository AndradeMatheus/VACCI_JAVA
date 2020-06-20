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

		assertEquals(cart.GetUsuarioId(), cartComparison.GetUsuarioId());
	}

	@Test
	void testAlterarCarteira() throws ClassNotFoundException, SQLException{
		ControleCarteira cartController = new ControleCarteira();

		Carteira cart = new Carteira();
		cart = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);

		Carteira cartModificado = new Carteira();
		cartModificado.SetCarteiraTipo(2);

		Boolean valida = cartController.AlterarCarteira(cartModificado, cart);

		if(valida)
			assertEquals(2, cartController.BuscarCarteiraPorId(cart).GetCarteiraTipo());
		else
			assertTrue(false);
	}

	@Test
	void testExcluirCarteira() throws ClassNotFoundException, SQLException{
		ControleCarteira cartController = new ControleCarteira();
		
		Carteira ultimaCarteira = new Carteira();
		Carteira cart = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);

		Boolean validaExclusao = cartController.ExcluirCarteira(cart);

		if(validaExclusao)
			ultimaCarteira = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);

		assertNotEquals(ultimaCarteira.GetUsuarioId(), cart.GetUsuarioId());
	}
}