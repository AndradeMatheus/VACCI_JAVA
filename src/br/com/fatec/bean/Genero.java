package br.com.fatec.bean;

public enum Genero {
	MASCULINO(1),
	FEMININO(2),
	OUTROS(3);
	
	public final int generoCode;
	
	Genero (int generoCode) {
		this.generoCode = generoCode;
	}
}
