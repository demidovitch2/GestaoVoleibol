package controlador;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import enumeracao.DocumentoTipo;
import modelo.Arbitro;
import repositorio.ArbitroRepository;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CadastroArbitroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ArbitroRepository arbitroRepo;

	@Inject
	private Arbitro arbitro;

	private Arbitro arbitroEscolhido = new Arbitro();

	public Arbitro getArbitro() {
		return this.arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Arbitro getArbitroEscolhido() {
		return this.arbitroEscolhido;
	}

	public void setArbitroEscolhido(Arbitro arbitroEscolhido) {
		this.arbitroEscolhido = arbitroEscolhido;
	}

	public DocumentoTipo[] getDocumentosTipo() {
		return DocumentoTipo.values();
	}

	public List<Arbitro> getArbitros() {
		return arbitroRepo.getArbitros();
	}

	public void salvar() {
		arbitroRepo.salvar(arbitro);

		this.arbitro = new Arbitro();
		
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Árbitro Adicionado com Sucesso", "Registo");

		context.addMessage(null, msg);
	}

	public void remover() {
		arbitroRepo.remove(arbitroEscolhido);
		
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Árbitro Removido com Sucesso", "Registo");

		context.addMessage(null, msg);
	}
	
	public boolean isEditando() {
		return this.arbitro.getId()!=null;
	}
}
