package br.com.fatec.controler;

import br.com.fatec.bean.Usuario;
import br.com.fatec.bean.Vacina;
import java.lang.Boolean;
import br.com.fatec.db.DaoVacina;
import java.sql.SQLException;
import java.util.List;

public class ControleVacina {
	
    public Vacina BuscarVacinaPorId(Vacina vac) throws SQLException, ClassNotFoundException {
    	DaoVacina vacDao = new DaoVacina();
        vac = vacDao.BuscaPorId(vac.GetId());
        return vac;
    }
    
    public Boolean AlterarVacina(Vacina vacModificado, Vacina vac) throws SQLException, ClassNotFoundException {
    	DaoVacina vacDao = new DaoVacina();
        return vacDao.Alterar(vacModificado, vac);
    }
	
    public Boolean ExcluirVacina(Vacina vac) throws SQLException, ClassNotFoundException {
        DaoVacina vacDao = new DaoVacina();
        Boolean valida = vacDao.Excluir(vac);
        return valida;
    }
    
    public List<Vacina> ListarVacinas() throws SQLException, ClassNotFoundException {
    	DaoVacina vacDao = new DaoVacina();
        List<Vacina> vacs = vacDao.Listar();
        return vacs;
    }
    
    public Boolean InserirVacina(Vacina vac) throws SQLException, ClassNotFoundException {
        DaoVacina vacDao = new DaoVacina();
        Boolean valida = vacDao.Inserir(vac);
        return valida;
    }    
}
