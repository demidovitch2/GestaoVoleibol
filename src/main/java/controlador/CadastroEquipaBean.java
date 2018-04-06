package controlador;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.Atleta;
import modelo.Equipa;
import modelo.Treinador;
import repositorio.AtletaRepository;
import repositorio.EquipaRepository;
import repositorio.TreinadorRepository;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CadastroEquipaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EquipaRepository equipaRepository;

	@Inject
	private TreinadorRepository treinadorRepo;
	
	@Inject
	private Equipa equipa;
	
	private List<Atleta> atletas;

	private List<Treinador> treinadores;

	private Equipa equipaEscolhida = new Equipa();

	private AtletaRepository atletaRepository;

	public Equipa getEquipa() {
		return this.equipa;
	}

	public void setEquipa(Equipa equipa) {
		this.equipa = equipa;
	}

	public List<Treinador> getTreinadores() {
		return treinadorRepo.treinadores();
	}
	
	public List<Equipa> getEquipas(){
		return equipaRepository.equipas();
	}

	
	public Equipa getEquipaEscolhido() {
		return this.equipaEscolhida;
	}

	public void setEquipaEscolhido(Equipa equipaEscolhido) {
		this.equipaEscolhida = equipaEscolhido;
	}

	public void salvar() {
		equipaRepository.salvar(equipa);

		this.equipa = new Equipa();
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Equipa Adicionada com Sucesso", "Registo");

		context.addMessage(null, msg);
	}
	
	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void carregarAtletasPorEquipas() {
		this.atletas = atletaRepository.getAtletasByEquipa(equipaEscolhida);
	}
	
	public void remover() {
		equipaRepository.remover(equipaEscolhida);
	}
	
	public boolean isEditando() {
		return this.equipa.getId()!=null;
	}


}
