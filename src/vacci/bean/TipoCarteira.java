package vacci.bean;

public class TipoCarteira{
    
    public int tipo;
    public String descricao;
	public int quantidade;
    
    public TipoCarteira(int tipo, String descricao) {
    	this.tipo = tipo;
    	this.descricao = descricao;
    }
    
    public TipoCarteira(int tipo) {
    	this.tipo = tipo;
    }
    
    public TipoCarteira(String descricao) {
    	this.descricao = descricao;
    }
    
    public TipoCarteira() {
    }
}