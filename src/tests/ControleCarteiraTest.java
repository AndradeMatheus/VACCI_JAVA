package tests;

import vacci.controller.ControleCarteira;
import vacci.bean.Carteira;
import vacci.bean.CarteiraVacina;
import vacci.bean.Usuario;
import vacci.bean.Vacina;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControleCarteiraTest {
	
	@Test
	@Order(1)
	void testInserirCarteira() throws ClassNotFoundException, SQLException {		
		Carteira cart = new Carteira(0, 1, 3);
		
		ControleCarteira cartController = new ControleCarteira();
		Boolean valida = cartController.InserirCarteira(cart);
		
		Carteira cartNova = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);

		if(valida)
			assertEquals(cart.GetCarteiraTipo(), cartNova.GetCarteiraTipo());
		else
			assertTrue(false);
	}

	@Test
	@Order(2)
	void testListarCarteiras() throws ClassNotFoundException, SQLException {
		ControleCarteira cartController = new ControleCarteira();
		List<Carteira> carts = cartController.ListarCarteiras();

		assertNotNull(carts);
	}

	@Test
	@Order(3)
	void testBuscarCarteiraPorId() throws ClassNotFoundException, SQLException {
		ControleCarteira cartController = new ControleCarteira();
		Carteira cart = cartController.BuscarCarteiraPorId(new Carteira(1, 0, 0));

		Carteira cartComparison = cartController.ListarCarteiras().get(0);

		assertEquals(cart.GetUsuarioNome(), cartComparison.GetUsuarioNome());
	}
	
	@Test
	@Order(4)
	void testBuscarCarteiraPorUsuarioTipoCarteira() throws ClassNotFoundException, SQLException {
		Usuario user = new Usuario();
		user.SetId(1);
		ControleCarteira cartController = new ControleCarteira();
		Carteira cart = cartController.BuscarCarteiraPorUsuarioTipoCarteira(
				user,
				new Carteira(0, 0, 3)
		);

		Carteira cartComparison = cartController.ListarCarteiras().get(0);

		assertEquals(cart.GetUsuarioNome(), cartComparison.GetUsuarioNome());
	}

	@Test
	@Order(5)
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
	@Order(6)
	void testRegistrarCarteiraVacina() throws ClassNotFoundException, SQLException{
		ControleCarteira cartController = new ControleCarteira();
		
		Carteira cart = new Carteira();
		cart = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);
		Vacina vac = new Vacina();
		vac.SetId(1);

		assertTrue(cartController.RegistrarCarteiraVacina(cart, vac));
	}

	@Test
	@Order(7)
	void testListarCarteiraVacinas() throws ClassNotFoundException, SQLException{
		ControleCarteira cartController = new ControleCarteira();
		List<CarteiraVacina> cartVacs = cartController
			.ListarCarteiraVacinas(cartController.ListarCarteiras()
			.get(cartController.ListarCarteiras().size() -1));

		assertNotNull(cartVacs);
	}

	@Test
	@Order(8)
	void testExcluirCarteira() throws ClassNotFoundException, SQLException{
		ControleCarteira cartController = new ControleCarteira();
		
		Carteira ultimaCarteira = new Carteira();
		Carteira cart = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);

		Boolean validaExclusao = cartController.ExcluirCarteira(cart);

		if(validaExclusao)
			ultimaCarteira = cartController.ListarCarteiras().get(cartController.ListarCarteiras().size() -1);

		assertNotEquals(ultimaCarteira.GetId(), cart.GetId());
	}
}