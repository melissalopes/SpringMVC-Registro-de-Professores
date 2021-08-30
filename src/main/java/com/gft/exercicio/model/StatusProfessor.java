package com.gft.exercicio.model;

public enum StatusProfessor {
	ATIVO("Ativo"),
	INATIVO("Inativo"),
	APOSENTADO("Aposentado"),
	AFASTADO("Afastado");
	
	private String descricao;
	
	StatusProfessor(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
