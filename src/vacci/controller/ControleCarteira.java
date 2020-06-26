package vacci.controller;

import vacci.bean.Carteira;
import vacci.bean.CarteiraVacina;
import vacci.bean.Usuario;
import vacci.bean.Vacina;
import vacci.db.DaoCarteira;
import java.lang.Boolean;
import java.sql.SQLException;
import java.util.List;

public class ControleCarteira {
	
    public Carteira BuscarCarteiraPorId(Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        cart = cartDao.BuscaPorId(cart.GetId());
        return cart;
    }

    public Carteira BuscarCarteiraPorUsuarioTipoCarteira(Usuario user, Carteira cart) throws SQLException, ClassNotFoundException{
        DaoCarteira cartDao = new DaoCarteira();
        cart = cartDao.BuscarPorUsuarioTipoCarteira(user.GetId(), cart.GetCarteiraTipo());
        return cart;
    }
    
    public Boolean AlterarCarteira(Carteira cartModificado, Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        return cartDao.Alterar(cartModificado, cart);
    }
	
    public Boolean ExcluirCarteira(Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        Boolean valida = cartDao.Excluir(cart);
        return valida;
    }
    
    public List<Carteira> ListarCarteiras() throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        List<Carteira> carts = cartDao.Listar();
        return carts;
    }
    
    public Boolean InserirCarteira(Carteira cart) throws SQLException, ClassNotFoundException {
    	DaoCarteira cartDao = new DaoCarteira();
        Boolean valida = cartDao.Inserir(cart);
        return valida;
    }
    
    public List<CarteiraVacina> ListarCarteiraVacinas(Carteira cart) throws SQLException, ClassNotFoundException {
        DaoCarteira cartDao = new DaoCarteira();
        List<CarteiraVacina> cartVacs = cartDao.ListarVacinas(cart);
        return cartVacs;        
    }

    public Boolean RegistrarCarteiraVacina(Carteira cart, Vacina vac) throws SQLException, ClassNotFoundException{
        DaoCarteira cartDao = new DaoCarteira();
        Boolean valida = cartDao.RegistrarVacina(cart, vac);
        return valida;
    }
}