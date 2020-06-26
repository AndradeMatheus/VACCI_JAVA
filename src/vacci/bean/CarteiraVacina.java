package vacci.bean;

public class CarteiraVacina {
    
    public int idCarteira;
    public Vacina vacina;

    public CarteiraVacina(int idCarteira, int vacinaId, String vacinaNome){
        this.idCarteira = idCarteira;
        this.vacina = new Vacina();
        this.vacina.SetId(vacinaId);
        this.vacina.SetNome(vacinaNome);
    }

    public CarteiraVacina(){
        this.vacina = new Vacina();
    }

    public int GetCarteiraId(){
        return this.idCarteira;
    }

    public void SetCarteiraId(int id){
        this.idCarteira = id;
    }

    public int GetVacinaId(){
        return this.vacina.GetId();
    }

    public void SetVacinaId(int id){
        this.vacina.SetId(id);
    }

    public String GetVacinaNome(){
        return this.vacina.GetNome();
    }

    public void SetVacinaNome(String nome){
        this.vacina.SetNome(nome);
    }
}