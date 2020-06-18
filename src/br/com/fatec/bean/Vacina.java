package br.com.fatec.bean;

public class Vacina{
    
    private int id;
    private String nome;
    private int tipoCarteira;

    
    public Vacina (int id, String nome, int tipoCarteira) {
        this.id = id;
        this.nome = nome;
        this.tipoCarteira = tipoCarteira;
    }
    
    public int GetId() {
    	return this.id;
    }
    
    public void SetId(int id) {
    	this.id = id;
    }
    
    public String GetNome() {
    	return this.nome;
    }
    
    public void SetNome(String nome) {
    	this.nome = nome;
    }
    
    public int GetTipoCarteira() {
    	return this.tipoCarteira;
    }
    
    public void SetTipoCarteira(int tipoCarteira) {
    	this.tipoCarteira = tipoCarteira;
    }
}