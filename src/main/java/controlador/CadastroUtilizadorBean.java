package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.Grupo;
import modelo.Utilizador;
import repositorio.GrupoRepository;
import repositorio.UtilizadorRepository;
import util.FacesUtil;

@Named
@SessionScoped
public class CadastroUtilizadorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UtilizadorRepository repository;

	@Inject
	private GrupoRepository grupoRepository;

	private Utilizador utilizador = new Utilizador();
	private Utilizador utilizadorEscolhido = new Utilizador();
	private Grupo grupo = new Grupo();
	@SuppressWarnings("unused")
	private List<Utilizador> utilizadores = new ArrayList<>();
	private Set<Grupo> gruposSeleccionados = new HashSet<>();

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public Utilizador getUtilizadorEscolhido() {
		return utilizadorEscolhido;
	}

	public void setUtilizadorEscolhido(Utilizador utilizadorSeleccionado) {
		this.utilizadorEscolhido = utilizadorSeleccionado;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Utilizador> getUtilizadores() {
		return repository.utilizadores();
	}

	public void setUtilizadores(List<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public Set<Grupo> getGruposSeleccionados() {
		return gruposSeleccionados;
	}

	public void setGruposSeleccionados(Set<Grupo> gruposSeleccionados) {
		this.gruposSeleccionados = gruposSeleccionados;
	}

	public void salvar() {
		for(Grupo g: gruposSeleccionados)
		utilizador.getGrupos().add(g);
		repository.salvar(utilizador);
		

		this.utilizador = new Utilizador();
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Utilizador Adicionado com Sucesso");
	}

	public void remover() {
		repository.remover(utilizadorEscolhido);
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Utilizador Removido com Sucesso");
	}

	public boolean isEditando() {
		return this.utilizador.getId() != null;
	}

	public List<Grupo> getGrupos() {
		return grupoRepository.getGrupos();
	}

}
