package br.com.fatec.bean;

public class Carteira{
    
    private int id;
    private String usuario;
    private int tipo;

    
    public Carteira (int id, String usuario, int tipo) {
        this.id = id;
        this.usuario = usuario;
        this.tipo = tipo;
    }
    
    public int GetId() {
    	return this.id;
    }
    
    public void SetId(int id) {
    	this.id = id;
    }
    
    public String GetUsuario() {
    	return this.usuario;
    }
    
    public void SetUsuario(String usuario) {
    	this.usuario = usuario;
    }
    
    public int GetTipo() {
    	return this.tipo;
    }
    
    public void SetTipo(int tipo) {
    	this.tipo = tipo;
    }
}