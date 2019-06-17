package br.com.epidemic.enums;

public enum Perfil {
	SUPORTE("ROLE_SUPORTE"), PROGRAMADOR("ROLE_PROGRAMADOR");

	private String descricao;

	Perfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
