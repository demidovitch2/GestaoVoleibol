package enumeracao;

public enum AtletaEscalao {

	JUVENIL("Juvenil"), JUNIOR("Júnior"), SENIOR("Sénior"), VETERANO("Veterano");

	private String descricao;

	private AtletaEscalao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
