package br.com.fatec.bean;

public class Vacina{
    
    private int id;
    private String nome;
    private TipoCarteira carteira;

    
    public Vacina (int id, String nome, int carteiraTipo, String carteiraDescricao) {
        this.id = id;
        this.nome = nome;
        this.carteira = new TipoCarteira(carteiraTipo, carteiraDescricao);
    }

    public Vacina(int id, String nome, int carteiraTipo){
        this.id = id;
        this.nome = nome;
        this.carteira = new TipoCarteira(carteiraTipo);
    }
    
    public Vacina() {
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
    
    public void SetCarteira(int carteiraTipo, String carteiraDescricao){
    	this.carteira.tipo = carteiraTipo;
    	this.carteira.descricao = carteiraDescricao;
    }
    
    public int GetCarteiraTipo() {
    	return this.carteira.tipo;
    }
    
    public void SetCarteiraTipo(int carteiraTipo) {
    	this.carteira.tipo = carteiraTipo;
    }
    
    public String GetCarteiraDescricao() {
    	return this.carteira.descricao;
    }
    
    public void SetCarteiraDescricao(String carteiraDescricao) {
    	this.carteira.descricao = carteiraDescricao;
    }
}