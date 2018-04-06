package controlador;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import enumeracao.AtletaEscalao;
import enumeracao.AtletaPosicao;
import enumeracao.DocumentoTipo;
import enumeracao.EstadoCivil;
import modelo.Atleta;
import modelo.Equipa;
import repositorio.AtletaRepository;
import repositorio.EquipaRepository;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CadastroAtletaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AtletaRepository atletaRepository;

	@Inject
	private EquipaRepository equipaRepository;

	@Inject
	private Atleta atleta;
	
	private Atleta atletaEscolhido = new Atleta();

	public Atleta getAtleta() {
		return this.atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
	public Atleta getAtletaEscolhido() {
		return this.atletaEscolhido;
	}

	public void setAtletaEscolhido(Atleta atletaEscolhido) {
		this.atletaEscolhido = atletaEscolhido;
	}

	public void salvar() {
		
		atletaRepository.salvar(atleta);

		this.atleta = new Atleta();
		
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atleta Adicionado com Sucesso", "Registo");

		context.addMessage(null, msg);
	}
	
	public void remover() {
		atletaRepository.remover(atletaEscolhido);
	}

	public List<Atleta> getAtletas() {
		return atletaRepository.getAtletas();
	}
	
	public List<Equipa> getEquipas() {
		return equipaRepository.equipas();
	}

	public AtletaEscalao[] getAtletasEscalao() {
		return AtletaEscalao.values();
	}

	public AtletaPosicao[] getAtletasPosicao() {
		return AtletaPosicao.values();
	}

	public DocumentoTipo[] getDocumentosTipo() {
		return DocumentoTipo.values();
	}

	public EstadoCivil[] getEstadosCivil() {
		return EstadoCivil.values();
	}
	
	public boolean isEditando() {
		return this.atleta.getId()!=null;
	}

}
