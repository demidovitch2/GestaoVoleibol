package enumeracao;

public enum DocumentoTipo {

	BILHETE_DE_IDENTIDADE("Bilhete de Identidade"), CARTA_DE_CONDUCAO("Carta de Condução"), CEDULA_PESSOAL(
			"Cédula pessoal"), PASSAPORTE("Passaporte");

	private String descricao;

	private DocumentoTipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
