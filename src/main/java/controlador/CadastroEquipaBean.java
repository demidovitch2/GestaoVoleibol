package controlador;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.Atleta;
import modelo.Equipa;
import modelo.Treinador;
import repositorio.AtletaRepository;
import repositorio.EquipaRepository;
import repositorio.TreinadorRepository;
import util.FacesUtil;

import java.io.Serializable;
import java.util.ArrayList;
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

	private Equipa equipa = new Equipa();
	private Equipa equipaEscolhida = new Equipa();

	private List<Atleta> atletas;
	private List<Treinador> treinadores = new ArrayList<>();

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

	public List<Equipa> getEquipas() {
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
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Equipa Adicionada com Sucesso");
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void carregarAtletasPorEquipas() {
		this.atletas = atletaRepository.getAtletasByEquipa(equipaEscolhida);
	}

	public void remover() {
		equipaRepository.remover(equipaEscolhida);
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Equipa Removida com Sucesso");
	}

	public boolean isEditando() {
		return this.equipa.getId() != null;
	}

}
