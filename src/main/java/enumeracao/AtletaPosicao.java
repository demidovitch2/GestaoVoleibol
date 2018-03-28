package enumeracao;

public enum AtletaPosicao {
	OPOSTO("Oposto"), LIBERO("Líbero"), PONTA("Ponta"), PASSADOR("Passador"), CENTRAL("Central");

	private String descricao;

	private AtletaPosicao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
