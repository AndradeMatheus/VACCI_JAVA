package vacci.db;

import vacci.util.ConexaoDB;
import vacci.bean.Vacina;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class DaoVacina {

    private final Connection c;
    
    public DaoVacina() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public Vacina BuscaPorId(int id) throws SQLException{
        try{
            String sql = "SELECT v.id_vacina, v.nm_vacina, v.tp_carteira, dc.nm_carteira " + 
            "FROM vacinas v JOIN dom_carteira dc ON v.tp_carteira = dc.tp_carteira WHERE v.id_vacina = ? ";
    
            PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
        
            Vacina ret = new Vacina();
        
            while (rs.next()) {
                ret.SetId(rs.getInt(1));
                ret.SetNome(rs.getString(2));
                ret.SetCarteiraTipo(rs.getInt(3));
                ret.SetCarteiraDescricao(rs.getString(4));
            }

            return ret;

        }catch(Exception ex){
            Vacina falha = new Vacina();
            falha.SetNome("ERRO AO EXECUTAR A AÇÃO");
            return(falha);

        }finally{
            c.close();
        }
    }
    
    public Boolean Alterar(Vacina vacModificado, Vacina vac) throws SQLException{
        try{
            String sql = "UPDATE vacinas SET nm_vacina = ?, tp_carteira = ? WHERE id_vacina = ?";
        
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, vacModificado.GetNome() == null ? vac.GetNome() : vacModificado.GetNome());
            stmt.setInt(2, vacModificado.GetCarteiraTipo() == 0 ? vac.GetCarteiraTipo() : vacModificado.GetCarteiraTipo());
            stmt.setInt(3, vac.GetId());

            stmt.execute();

            return true;

        }catch(Exception ex){
            return false;

        }finally{
            c.close();
        }
    }

    public Boolean Excluir(Vacina vac) throws SQLException{
        try{
            String sql1 = "DELETE FROM carteira_vacina WHERE id_vacina = ?";
            String sql2 = "DELETE FROM vacinas WHERE id_vacina = ?";

            PreparedStatement stmt1 = c.prepareStatement(sql1);
            PreparedStatement stmt2 = c.prepareStatement(sql2);

            stmt1.setInt(1, vac.GetId());
            stmt2.setInt(1, vac.GetId());

            stmt1.execute();
            stmt2.execute();

            return true;
            
        }catch(Exception ex){
            return false;

        }finally{
            c.close();
        }
    }
    
    public List<Vacina> Listar() throws SQLException{
        try{
            List<Vacina> vacs = new ArrayList<Vacina>();
        
            String sql = "SELECT v.id_vacina, v.nm_vacina, v.tp_carteira, dc.nm_carteira " + 
                    "FROM vacinas v JOIN dom_carteira dc ON v.tp_carteira = dc.tp_carteira";
            
            PreparedStatement stmt = this.c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {      
                Vacina vac = new Vacina(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
                vacs.add(vac);
            }

            return vacs; 

        }catch(Exception ex){
            return new ArrayList<Vacina>();

        }finally{
            c.close();
        }
    }
    
    public Boolean Inserir(Vacina vac) throws SQLException{
        try{
            String sql = "INSERT INTO vacinas(nm_vacina, tp_carteira) values (?,?)";
    
            PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    
            stmt.setString(1, vac.GetNome());
            stmt.setInt(2, vac.GetCarteiraTipo());
    
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
}