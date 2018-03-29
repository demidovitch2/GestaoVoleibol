package controlador;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import enumeracao.DocumentoTipo;
import modelo.Treinador;
import repositorio.TreinadorRepository;
import java.io.Serializable;

@Named
@SessionScoped
public class CadastroTreinadorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private TreinadorRepository repoTreinador;

	@Inject
	private Treinador treinador;

	public Treinador getTreinador() {
		return this.treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public DocumentoTipo[] getDocumentosTipo() {
		return DocumentoTipo.values();
	}

	public void salvar() {
		repoTreinador.salvar(treinador);

		this.treinador = new Treinador();
	}

}
