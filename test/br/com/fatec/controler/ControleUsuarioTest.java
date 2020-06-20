package br.com.fatec.controler;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import br.com.fatec.bean.Usuario;
import java.util.List;

class ControleUsuarioTest {
	@Test
	void testInserirUsuario() throws ClassNotFoundException, SQLException {
		Usuario user = new Usuario(0,
				"teste",
				"login1",
				"senha",
				1,
				"",
				"01234-567",
				21);
		
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
		Boolean valida = userController.ValidaLogin("login1", "senha");

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
		Usuario user = userController.BuscarUsuarioPorId(new Usuario(1,
			"",
			"",
			"",
			0,
			"",
			"",
			0));

		Usuario userComparison = userController.ListarUsuarios().get(1);

		assertEquals(user.GetNome(), userComparison.GetNome());
	}

	@Test
	void testAlterarUsuario() throws ClassNotFoundException, SQLException{
		ControleUsuario userController = new ControleUsuario();

		Usuario user = new Usuario();
		user.SetId(1);
		user = userController.BuscarUsuarioPorId(user);

		Usuario userModificado = new Usuario();
		userModificado.SetNome("validacaoTESTE");

		Boolean valida = userController.AlterarUsuario(userModificado, user);

		if(valida)
			assertEquals(userModificado.GetNome(), userController.BuscarUsuarioPorId(user).GetNome());
		else
			assertTrue(false);
	}

	@Test
	void testExcluirUsuario() throws ClassNotFoundException, SQLException{
		Boolean validaExclusao;
		Usuario ultimoUsuario = new Usuario();

		Usuario user = new Usuario(0,
		"TESTEEXCLUSAO",
		"TESTEEXCLUSAO",
		"TESTEEXCLUSAO",
		1,
		"",
		"01234-567",
		21);

		ControleUsuario userController = new ControleUsuario();
		Boolean validaInsercao = userController.InserirUsuario(user);

		if(validaInsercao){
			validaExclusao = userController.ExcluirUsuario(user);
			if(validaExclusao){
				ultimoUsuario = userController.ListarUsuarios().get(userController.ListarUsuarios().size() -1);
			}
		}

		assertNotEquals(ultimoUsuario.GetNome(), user.GetNome());
	}
}
