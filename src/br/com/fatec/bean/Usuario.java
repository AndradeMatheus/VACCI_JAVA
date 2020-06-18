package br.com.fatec.bean;

public class Usuario{
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String genero;
    private String cep;
    private int idade;
    
    public Usuario (int id, String nome,String login, String senha, String status, String tipo, String genero, String cep, int idade) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.genero = genero;
        this.cep = cep;
        this.idade = idade;
    }
    
    public Usuario() {
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
    
    public String GetLogin() {
    	return this.login;
    }
    
    public void SetLogin(String login) {
    	this.login = login;
    }
    
    public String GetGenero() {
    	return this.genero;
    }
    
    public void SetGenero(String genero) {
    	this.genero = genero;
    }
    
    public String GetCep() {
    	return this.cep;
    }
    
    public void SetCep(String cep) {
    	this.cep = cep;
    }
    
    public int GetIdade() {
    	return this.idade;
    }
    
    public void SetIdade(int idade) {
    	this.idade = idade;
    }

	public String GetSenha() {
		return senha;
	}

	public void SetSenha(String senha) {
		this.senha = senha;
	}
}