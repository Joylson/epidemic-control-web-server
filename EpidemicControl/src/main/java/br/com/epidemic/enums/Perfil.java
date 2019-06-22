package br.com.epidemic.enums;

public enum Perfil {
	ADMIN("ROLE_ADMIN"), USUARIO("ROLE_USUARIO"), COPERADOR("ROLE_COPERADOR");

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
