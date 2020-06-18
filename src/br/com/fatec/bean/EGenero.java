package br.com.fatec.bean;

public enum EGenero {
	MASCULINO(1),
	FEMININO(2),
	OUTROS(3);
	
	public final int generoCode;
	
	EGenero (int generoCode) {
		this.generoCode = generoCode;
	}
}
