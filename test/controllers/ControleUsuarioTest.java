package controllers;

import vacci.controller.ControleUsuario;
import vacci.bean.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import java.util.List;

class ControleUsuarioTest {
	@Test
	void testInserirUsuario() throws ClassNotFoundException, SQLException {
		Usuario user = new Usuario(0,
				"USUARIOTESTE",
				"LOGINTESTE",
				"SENHATESTE",
				3,
				"",
				"99999-999",
				99);
		
		ControleUsuario userController = new ControleUsuario();
		Boolean valida = userController.InserirUsuario(user);
		Usuario usuarioNovo = userController.ListarUsuarios().get(userController.ListarUsuarios().size() -1);

		if(valida)
			assertEquals(user.GetNome(), usuarioNovo.GetNome());
		else
			assertTrue(false);
	}

	@Test
	void testValidaLogin() throws ClassNotFoundException, SQLException {
		ControleUsuario userController = new ControleUsuario();
		Boolean valida = userController.ValidaLogin("LOGINTESTE", "SENHATESTE");

		assertTrue(valida);
	}

	@Test
	void testListarUsuarios() throws ClassNotFoundException, SQLException {
		ControleUsuario userController = new ControleUsuario();
		List<Usuario> users = userController.ListarUsuarios();

		assertNotNull(users);
	}

	@Test
	void testBuscarUsuarioPorId() throws ClassNotFoundException, SQLException {
		ControleUsuario userController = new ControleUsuario();
		Usuario user = userController.BuscarUsuarioPorId(new Usuario(1, "", "", "", 0, "", "", 0));

		Usuario userComparison = userController.ListarUsuarios().get(1);

		assertEquals(user.GetNome(), userComparison.GetNome());
	}

	@Test
	void testAlterarUsuario() throws ClassNotFoundException, SQLException{
		ControleUsuario userController = new ControleUsuario();

		Usuario user = new Usuario();
		user = userController.ListarUsuarios().get(userController.ListarUsuarios().size() -1);

		Usuario userModificado = new Usuario();
		userModificado.SetNome("VALIDACAOTESTE");

		Boolean valida = userController.AlterarUsuario(userModificado, user);

		if(valida)
			assertEquals("VALIDACAOTESTE", userController.BuscarUsuarioPorId(user).GetNome());
		else
			assertTrue(false);
	}

	@Test
	void testExcluirUsuario() throws ClassNotFoundException, SQLException{
		ControleUsuario userController = new ControleUsuario();
		
		Usuario ultimoUser = new Usuario();
		Usuario user = userController.ListarUsuarios().get(userController.ListarUsuarios().size() -1);

		Boolean validaExclusao = userController.InserirUsuario(user);
			
		if(validaExclusao)
			ultimoUser = userController.ListarUsuarios().get(userController.ListarUsuarios().size() -1);

		assertNotEquals(ultimoUser.GetNome(), user.GetNome());
	}
}