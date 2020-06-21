package tests;

import vacci.controller.ControleUsuario;
import vacci.bean.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControleUsuarioTest {
	
	@Test
	@Order(1)
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
	@Order(2)
	void testValidaLogin() throws ClassNotFoundException, SQLException {
		ControleUsuario userController = new ControleUsuario();
		Boolean valida = userController.ValidaLogin("LOGINTESTE", "SENHATESTE");

		assertTrue(valida);
	}

	@Test
	@Order(3)
	void testListarUsuarios() throws ClassNotFoundException, SQLException {
		ControleUsuario userController = new ControleUsuario();
		List<Usuario> users = userController.ListarUsuarios();

		assertNotNull(users);
	}

	@Test
	@Order(4)
	void testBuscarUsuarioPorId() throws ClassNotFoundException, SQLException {
		ControleUsuario userController = new ControleUsuario();
		Usuario user = userController.BuscarUsuarioPorId(new Usuario(1, "", "", "", 0, "", "", 0));

		Usuario userComparison = userController.ListarUsuarios().get(0);

		assertEquals(user.GetNome(), userComparison.GetNome());
	}
	
	@Test
	@Order(5)
	void testBuscarUsuarioPorLogin() throws ClassNotFoundException, SQLException {
		ControleUsuario userController = new ControleUsuario();
		Usuario user = userController.BuscarUsuarioPorLogin("admin");

		Usuario userComparison = userController.ListarUsuarios().get(0);

		assertEquals(user.GetNome(), userComparison.GetNome());
	}


	@Test
	@Order(6)
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
	@Order(7)
	void testExcluirUsuario() throws ClassNotFoundException, SQLException{
		ControleUsuario userController = new ControleUsuario();
		
		Usuario ultimoUser = new Usuario();
		Usuario user = userController.ListarUsuarios().get(userController.ListarUsuarios().size() -1);

		Boolean validaExclusao = userController.ExcluirUsuario(user);
			
		if(validaExclusao)
			ultimoUser = userController.ListarUsuarios().get(userController.ListarUsuarios().size() -1);

		assertNotEquals(ultimoUser.GetNome(), user.GetNome());
	}
}