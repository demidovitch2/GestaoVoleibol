package controlador;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import enumeracao.DocumentoTipo;
import modelo.Treinador;
import repositorio.TreinadorRepository;
import util.FacesUtil;

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
	private Treinador treinador = new Treinador();

	private Treinador treinadorEscolhido = new Treinador();

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
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Treinador Adicionado com Sucesso");
	}

	public void remover() {
		repoTreinador.remover(treinadorEscolhido);
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Treinador Removido com Sucesso");
	}

	public List<Treinador> getTreinadores() {
		return repoTreinador.treinadores();
	}

	public boolean isEditando() {
		return this.treinador.getId() != null;
	}

}
