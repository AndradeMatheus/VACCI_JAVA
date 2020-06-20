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
        try{
            String sql = "SELECT c.id_carteira, c.id_usuario, u.nm_usuario, c.tp_carteira, dc.nm_carteira " + 
            "FROM carteira c JOIN usuario u ON c.id_usuario = u.id_usuario " +
            "JOIN dom_carteira dc ON dc.tp_carteira = c.tp_carteira WHERE c.id_carteira = ? ";

            PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Carteira ret = new Carteira();
            
            while (rs.next()) {
                ret.SetId(rs.getInt(1));
                ret.SetUsuarioId(rs.getInt(2));
                ret.SetUsuarioNome(rs.getString(3));
                ret.SetCarteiraTipo(rs.getInt(4));
                ret.SetCarteiraDescricao(rs.getString(5));
            }

            return ret;

        }catch(Exception ex){
            Carteira falha = new Carteira();
            falha.SetCarteiraDescricao("ERRO AO EXECUTAR A AÇÃO");
            return(falha);

        }finally{
            c.close();
        }
    }
    
    public Boolean Alterar(Carteira cartModificado, Carteira cart) throws SQLException{
        try{
            String sql = "UPDATE carteira SET id_usuario = ?, tp_carteira = ? WHERE id_carteira = ?";
        
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setInt(1, cartModificado.GetUsuarioId() == 0 ? cart.GetUsuarioId() : cartModificado.GetUsuarioId());
            stmt.setInt(2, cartModificado.GetCarteiraTipo() == 0 ? cart.GetCarteiraTipo() : cartModificado.GetCarteiraTipo());
            stmt.setInt(3, cart.GetId());
            stmt.execute();

            return true;

        }catch(Exception ex){
            return false;

        }finally{
            c.close();
        }
    }

    public Boolean Excluir(Carteira cart) throws SQLException{
        try{
            String sql1 = "DELETE FROM carteira_vacina WHERE id_carteira = ?";
            String sql2 = "DELETE FROM carteira WHERE id_carteira = ?";

            PreparedStatement stmt1 = c.prepareStatement(sql1);
            PreparedStatement stmt2 = c.prepareStatement(sql2);

            stmt1.setInt(1, cart.GetId());
            stmt2.setInt(1, cart.GetId());
            
            stmt1.execute();
            stmt2.execute();

            return true;

        }catch(Exception ex){
            return false;

        }finally{
            c.close();
        }
    }
    
    public List<Carteira> Listar() throws SQLException{
        try{
            List<Carteira> carts = new ArrayList<Carteira>();
        
            String sql = "SELECT c.id_carteira, c.id_usuario, u.nm_usuario, c.tp_carteira, dc.nm_carteira " + 
                    "FROM carteira c JOIN usuario u ON c.id_usuario = u.id_usuario " +
                    "JOIN dom_carteira dc ON dc.tp_carteira = c.tp_carteira";
            
            PreparedStatement stmt = this.c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {      
                Carteira cart = new Carteira();
                
                cart.SetId(rs.getInt(1));
                cart.SetUsuarioId(rs.getInt(2));
                cart.SetUsuarioNome(rs.getString(3));
                cart.SetCarteiraTipo(rs.getInt(4));
                cart.SetCarteiraDescricao(rs.getString(5));
                
                carts.add(cart);
            }

            return carts; 

        }catch(Exception ex){
            return new ArrayList<Carteira>();

        }finally{
            c.close();
        }
    }
    
    public Boolean Inserir(Carteira cart) throws SQLException{
        try{
            String sql = "INSERT INTO carteira(id_usuario, tp_carteira) values (?,?)";
    
            PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
            stmt.setInt(1, cart.GetUsuarioId());
            stmt.setInt(2, cart.GetCarteiraTipo());
    
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next())
        	    return true;
            else
        	    return false;

        }catch(Exception ex){
            return false;

        }finally{
            c.close();
        }
    }

    public List<CarteiraVacina> ListarVacinas(Carteira cart) throws SQLException{
        try{
            List<CarteiraVacina> cartVacs = new ArrayList<CarteiraVacina>();
        
            String sql = "SELECT cv.id_carteira, cv.id_vacina, v.nm_vacina " +
                "FROM carteira_vacina cv " +
                "JOIN vacinas v ON cv.id_vacina = v.id_vacina WHERE id_carteira = ?";

            PreparedStatement stmt = this.c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {      
                CarteiraVacina cartVac = new CarteiraVacina();
                
                cartVac.SetCarteiraId(rs.getInt(1));
                cartVac.SetVacinaId(rs.getInt(2));
                cartVac.SetVacinaNome(rs.getString(3));
                
                cartVacs.add(cartVac);
            }

            return cartVacs; 

        }catch(Exception ex){
            return new ArrayList<CarteiraVacina>();

        }finally{
            c.close();
        }
    }

    public Boolean RegistrarVacina(Carteira cart, Vacina vac) throws SQLException{
        try{
            String sql = "INSERT INTO carteira_vacina(id_carteira, id_vacina) VALUES (?,?)";

            PreparedStatement stmt = c.prepareStatement(sql);
    
            stmt.setInt(1, cart.GetId());
            stmt.setInt(2, vac.GetId());
    
            stmt.executeUpdate();

            return true;

        }catch(Exception ex){
            return false;

        }finally{
            c.close();
        }
    }
}