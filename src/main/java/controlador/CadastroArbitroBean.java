package controlador;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import enumeracao.DocumentoTipo;
import modelo.Arbitro;
import repositorio.ArbitroRepository;
import util.FacesUtil;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CadastroArbitroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ArbitroRepository arbitroRepo;

	private Arbitro arbitro = new Arbitro();

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
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Árbitro Adicionado com Sucesso");
	}

	public void remover() {
		arbitroRepo.remove(arbitroEscolhido);
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Árbitro Removido com Sucesso");
	}

	public boolean isEditando() {
		return this.arbitro.getId() != null;
	}
}
