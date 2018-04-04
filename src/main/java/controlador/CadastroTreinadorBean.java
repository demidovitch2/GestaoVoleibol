package controlador;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import enumeracao.DocumentoTipo;
import modelo.Treinador;
import repositorio.TreinadorRepository;
import java.io.Serializable;
import java.util.List;

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
	
	private Treinador treinadorEscolhido;

	public Treinador getTreinador() {
		return this.treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public DocumentoTipo[] getDocumentosTipo() {
		return DocumentoTipo.values();
	}
	
	public Treinador getTreinadorEscolhido() {
		return treinadorEscolhido;
	}

	public void setTreinadorEscolhido(Treinador treinadorEscolhido) {
		this.treinadorEscolhido = treinadorEscolhido;
	}

	public void salvar() {
		repoTreinador.salvar(treinador);

		this.treinador = new Treinador();
	}

	public void remover() {
		repoTreinador.remover(treinador);
	}

	public List<Treinador> getTreinadores() {
		return repoTreinador.treinadores();
	}

}
