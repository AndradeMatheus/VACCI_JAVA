package tests;

import vacci.controller.ControleVacina;
import vacci.bean.Carteira;
import vacci.bean.Vacina;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControleVacinaTest {

	@Test
	@Order(1)
	void testInsertVacina() throws ClassNotFoundException, SQLException {
		Vacina vac = new Vacina(0, "Teste", 3);
		
		ControleVacina vacController = new ControleVacina();
		Boolean valida = vacController.InserirVacina(vac);
		Vacina vacNova = vacController.ListarVacinas().get(vacController.ListarVacinas().size() -1);

		if(valida)
			assertEquals(vac.GetNome(), vacNova.GetNome());
		else
			assertTrue(false);
	}

	@Test
	@Order(2)
	void testListarVacinas() throws ClassNotFoundException, SQLException {
		ControleVacina vacController = new ControleVacina();
		List<Vacina> vacs = vacController.ListarVacinas();

		assertNotNull(vacs);
	}

	@Test
	@Order(3)
	void testListarVacinasPorTipo() throws ClassNotFoundException, SQLException {
		Carteira cart = new Carteira();
		cart.SetCarteiraTipo(1);

		ControleVacina vacController = new ControleVacina();
		List<Vacina> vacs = vacController.ListarVacinasPorTipo(cart);

		assertNotNull(vacs);
	}

	@Test
	@Order(4)
	void testBuscarVacinaPorId() throws ClassNotFoundException, SQLException {
		ControleVacina vacController = new ControleVacina();
		Vacina vac = vacController.BuscarVacinaPorId(new Vacina(1, "", 0));

		Vacina vacComparison = vacController.ListarVacinas().get(0);

		assertEquals(vac.GetNome(), vacComparison.GetNome());
	}

	@Test
	@Order(5)
	void testAlterarVacina() throws ClassNotFoundException, SQLException{
		ControleVacina vacController = new ControleVacina();

		Vacina vac = new Vacina();
		vac = vacController.ListarVacinas().get(vacController.ListarVacinas().size() -1);

		Vacina vacModificado = new Vacina();
		vacModificado.SetNome("TESTEALTERACAO");

		Boolean valida = vacController.AlterarVacina(vacModificado, vac);

		if(valida)
			assertEquals("TESTEALTERACAO", vacController.BuscarVacinaPorId(vac).GetNome());
		else
			assertTrue(false);
	}

	@Test
	@Order(6)
	void testExcluirVacina() throws ClassNotFoundException, SQLException{
		ControleVacina vacController = new ControleVacina();
		
		Vacina ultimaVacina = new Vacina();
		Vacina vac = vacController.ListarVacinas().get(vacController.ListarVacinas().size() -1);

		Boolean validaExclusao = vacController.ExcluirVacina(vac);

		if(validaExclusao)
			ultimaVacina = vacController.ListarVacinas().get(vacController.ListarVacinas().size() -1);

		assertNotEquals(ultimaVacina.GetNome(), vac.GetNome());
	}
}