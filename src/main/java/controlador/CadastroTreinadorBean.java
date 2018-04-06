package controlador;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
		
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Treinador Adicionada com Sucesso", "Registo");

		context.addMessage(null, msg);
	}

	public void remover() {
		repoTreinador.remover(treinadorEscolhido);
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Treinador Removido com Sucesso", "Registo");

		context.addMessage(null, msg);
	}

	public List<Treinador> getTreinadores() {
		return repoTreinador.treinadores();
	}
	
	public boolean isEditando() {
		return this.treinador.getId()!=null;
	}

}
