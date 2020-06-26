package vacci.bean;

public class Vacina{
    
    private int id;
    private String nome;
    private TipoCarteira carteira;
    private int quantidade;
    
    public Vacina (int id, String nome, int carteiraTipo, String carteiraDescricao) {
        this.id = id;
        this.nome = nome;
        this.carteira = new TipoCarteira(carteiraTipo, carteiraDescricao);
        this.quantidade = 0;
    }

    public Vacina (int id, String nome, int carteiraTipo, String carteiraDescricao, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.carteira = new TipoCarteira(carteiraTipo, carteiraDescricao);
        this.quantidade = 0;
    }

    public Vacina(int id, String nome, int carteiraTipo){
        this.id = id;
        this.nome = nome;
        this.carteira = new TipoCarteira(carteiraTipo);
    }
    
    public Vacina() {
    	this.carteira = new TipoCarteira();
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

    public int GetCarteiraQuantidade(){
        return this.quantidade;
    }

    public void SetCarteiraQuantidade(int qtd){
        this.quantidade = qtd;
    }
    
    public String GetCarteiraDescricao() {
    	return this.carteira.descricao;
    }
    
    public void SetCarteiraDescricao(String carteiraDescricao) {
    	this.carteira.descricao = carteiraDescricao;
    }
}