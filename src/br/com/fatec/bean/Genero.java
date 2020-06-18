package br.com.fatec.bean;

public class Genero{
    
    public int tipo;
    public String descricao;
    
    public Genero(int tipo, String descricao) {
    	this.tipo = tipo;
    	this.descricao = descricao;
    }
    
    public Genero(int tipo) {
    	this.tipo = tipo;
    }
    
    public Genero(String descricao) {
    	this.descricao = descricao;
    }
    
    public Genero() {
    }
}