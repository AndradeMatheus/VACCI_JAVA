package br.com.fatec.bean;

public enum TipoCarteira {
	CRIANCA(1),
	ADOLESCENTE(2),
	ADULTO(3);
	
	public final int tipoCarteiraCode;
	
	TipoCarteira (int tipoCarteiraCode) {
		this.tipoCarteiraCode = tipoCarteiraCode;
	}
}
