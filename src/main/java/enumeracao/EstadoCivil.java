package enumeracao;

public enum EstadoCivil {

	CASADO("Casado/a"), SOLTEIRO("Solteiro/a"), VIUVO("Viúvo/a"), DIVORCIADO("Divorciado/a");

	private String descricao;

	private EstadoCivil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
