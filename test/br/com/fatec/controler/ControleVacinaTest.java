package br.com.fatec.controler;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import br.com.fatec.bean.Vacina;
import java.util.List;

class ControleVacinaTest {

	@Test
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
	void testListarVacinas() throws ClassNotFoundException, SQLException {
		ControleVacina vacController = new ControleVacina();
		List<Vacina> vacs = vacController.ListarVacinas();

		assertNotNull(vacs);
	}

	@Test
	void testBuscarVacinaPorId() throws ClassNotFoundException, SQLException {
		ControleVacina vacController = new ControleVacina();
		Vacina vac = vacController.BuscarVacinaPorId(new Vacina(1, "", 0));

		Vacina vacComparison = vacController.ListarVacinas().get(1);

		assertEquals(vac.GetNome(), vacComparison.GetNome());
	}

	@Test
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