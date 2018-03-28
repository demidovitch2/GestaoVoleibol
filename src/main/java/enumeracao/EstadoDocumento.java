package enumeracao;

public enum EstadoDocumento {

	NORMAL("Normal"), VITALICIO("Vitalício");

	private String descricao;

	private EstadoDocumento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
