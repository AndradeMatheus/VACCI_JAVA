package br.com.fatec.bean;

public class Usuario{
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private Genero genero;
    private String cep;
    private int idade;
    
    public Usuario (int id, String nome,String login, String senha, int tipoGenero, String descricaoGenero, String cep, int idade) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.genero = new Genero(tipoGenero, descricaoGenero);
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
    
    public void SetGenero(int tipo, String descricao) {
    	this.genero.tipo = tipo;
    	this.genero.descricao = descricao;
    }
    
    public int GetGeneroTipo() {
    	return this.genero.tipo;
    }
    
    public void SetGeneroTipo(int tipo) {
    	this.genero.tipo = tipo;
    }
    
    public String GetGeneroDescricao() {
    	return this.genero.descricao;
    }
    
    public void SetGeneroDescricao(String descricao) {
    	this.genero.descricao = descricao;
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