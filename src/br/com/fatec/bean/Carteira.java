package br.com.fatec.bean;

public class Carteira{
    
    private int id;
    private Usuario usuario;
    private TipoCarteira carteira;

    
    public Carteira (int id, Usuario usuario, int carteiraTipo, String carteiraDescricao) {
        this.id = id;
        this.usuario = new Usuario();
        this.carteira = new TipoCarteira(carteiraTipo, carteiraDescricao);
    }
    
    public Carteira(){        
    }

    public int GetId() {
    	return this.id;
    }
    
    public void SetId(int id) {
    	this.id = id;
    }
    
    public int GetUsuarioId() {
    	return this.usuario.GetId();
    }
    
    public void SetUsuarioId(int idUsuario) {
    	this.usuario.SetId(idUsuario);
    }
    
    public String GetUsuarioNome(){
        return this.usuario.GetNome();
    }

    public void SetUsuarioNome(String nomeUsuario){
        this.usuario.SetNome(nomeUsuario);
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