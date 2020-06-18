package br.com.fatec.bean;

public enum ETipoCarteira {
	CRIANCA(1),
	ADOLESCENTE(2),
	ADULTO(3);
	
	public final int tipoCarteiraCode;
	
	ETipoCarteira (int tipoCarteiraCode) {
		this.tipoCarteiraCode = tipoCarteiraCode;
	}
}
