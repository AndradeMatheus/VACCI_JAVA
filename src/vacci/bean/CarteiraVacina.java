package vacci.bean;

public class CarteiraVacina {
    
    public int idCarteira;
    public int idVacina;

    public CarteiraVacina(int idCarteira, int idVacina){
        this.idCarteira = idCarteira;
        this.idVacina = idVacina;
    }

    public CarteiraVacina(){
    }

    public int GetCarteiraId(){
        return this.idCarteira;
    }

    public void SetCarteiraId(int id){
        this.idCarteira = id;
    }

    public int GetVacinaId(){
        return this.idVacina;
    }

    public void SetVacinaId(int id){
        this.idVacina = id;
    }
}