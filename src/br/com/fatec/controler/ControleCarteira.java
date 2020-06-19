package br.com.fatec.controler;

import br.com.fatec.bean.Carteira;
import java.lang.Boolean;
import br.com.fatec.db.DaoCarteira;
import java.sql.SQLException;
import java.util.List;

public class ControleCarteira {
	
    public Carteira BuscarCarteiraPorId(Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        cart = cartDao.BuscaPorId(cart.GetId());
        return cart;
    }
    
    public Boolean AlterarVacina(Carteira cartModificado, Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        return cartDao.Alterar(cartModificado, cart);
    }
	
    public Boolean ExcluirVacina(Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        Boolean valida = cartDao.Excluir(cart);
        return valida;
    }
    
    public List<Carteira> ListarVacinas() throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        List<Carteira> carts = cartDao.Listar();
        return carts;
    }
    
    public Boolean InserirVacina(Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        Boolean valida = cartDao.Inserir(cart);
        return valida;
    }    
}
