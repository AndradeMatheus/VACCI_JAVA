package vacci.db;

import vacci.util.ConexaoDB;
import vacci.bean.Carteira;
import vacci.bean.CarteiraVacina;
import vacci.bean.Vacina;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class DaoCarteira {

    private final Connection c;
    
    public DaoCarteira() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public Carteira BuscaPorId(int id) throws SQLException{
        String sql = "SELECT c.id_carteira, u.nm_usuario, dc.nm_carteira" + 
                    "FROM carteira c JOIN usuario u ON c.id_usuario = u.id_usuario" +
                    "JOIN dom_carteira dc ON dc.tp_carteira = c.tp_carteira WHERE c.id_carteira = ? ";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Carteira ret = new Carteira();
            
            while (rs.next()) {
                ret.SetId(rs.getInt(1));
                ret.SetUsuarioNome(rs.getString(2));
                ret.SetCarteiraDescricao(rs.getString(3));
            }
            
            rs.close();
            stmt.close();
            c.close();
            
        return ret;
    }
    
    public Boolean Alterar(Carteira cartModificado, Carteira cart) throws SQLException{
        String sql = "UPDATE carteira SET id_usuario = ?, tp_carteira = ? WHERE id_carteira = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1, cartModificado.GetUsuarioId() == 0 ? cart.GetUsuarioId() : cartModificado.GetUsuarioId());
        stmt.setInt(2, cartModificado.GetCarteiraTipo() == 0 ? cart.GetCarteiraTipo() : cartModificado.GetCarteiraTipo());
        stmt.setInt(3, cart.GetId());

        try {
            stmt.execute();
        }catch(Exception ex) {
        	return false;
        }finally {
            stmt.close();
            c.close();
        }
        
        return true;
    }

    public Boolean Excluir(Carteira cart) throws SQLException{
        String sql = "DELETE FROM carteira_vacina WHERE id_carteira = ? ; " + 
                "DELETE FROM carteira WHERE id_carteira = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1, cart.GetId());
        stmt.setInt(2, cart.GetId());
        
        try {
        	stmt.execute();	
        }catch(Exception ex) {
        	return false;
        }finally {
            stmt.close();
            c.close();
        }
               
        return true;
    }
    
    public List<Carteira> Listar() throws SQLException{
        List<Carteira> carts = new ArrayList<Carteira>();
        
        String sql = "SELECT c.id_carteira, u.nm_usuario, dc.nm_carteira" + 
                "FROM carteira c JOIN usuario u ON c.id_usuario = u.id_usuario" +
                "JOIN dom_carteira dc ON dc.tp_carteira = c.tp_carteira";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Carteira cart = new Carteira();
            
            cart.SetId(rs.getInt(1));
            cart.SetUsuarioNome(rs.getString(2));
            cart.SetCarteiraDescricao(rs.getString(3));
            
            carts.add(cart);
        }
        
        rs.close();
        stmt.close();
        c.close();
        return carts; 
    }
    
    public Boolean Inserir(Carteira cart) throws SQLException{
        String sql = "INSERT INTO carteira(id_usuario, tp_carteira) values (?,?)";
    
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, cart.GetUsuarioId());
        stmt.setInt(2, cart.GetCarteiraTipo());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        stmt.close();
        c.close();
        		
        if (rs.next())
        	return true;
        else
        	return false;
    }

    public List<CarteiraVacina> ListarVacinas(Carteira cart) throws SQLException{
        List<CarteiraVacina> cartVacs = new ArrayList<CarteiraVacina>();
        
        String sql = "SELECT id_carteira, id_vacina FROM carteira_vacina WHERE id_carteira = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            CarteiraVacina cartVac = new CarteiraVacina();
            
            cartVac.SetCarteiraId(rs.getInt(1));
            cartVac.SetVacinaId(rs.getInt(2));
            
            cartVacs.add(cartVac);
        }
        
        rs.close();
        stmt.close();
        c.close();
        return cartVacs; 
    }

    public Boolean RegistrarVacina(Carteira cart, Vacina vac) throws SQLException{
        String sql = "INSERT INTO carteira_vacina(id_carteira, id_vacina) VALUES (?,?)";

        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, cart.GetId());
        stmt.setInt(2, vac.GetId());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        stmt.close();
        c.close();

        if(rs.next())
            return true;
        else
            return false;
    }
}