package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.Utilizador;
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

	private Utilizador utilizador = new Utilizador();
	private Utilizador utilizadorEscolhido = new Utilizador();
	private List<Utilizador> utilizadores = new ArrayList<>();

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

	public List<Utilizador> getUtilizadores() {
		return repository.utilizadores();
	}

	public void setUtilizadores(List<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public void salvar() {
		repository.salvar(utilizador);

		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Utilizador Adicionado com Sucesso");
	}

	public void remover() {
		repository.remover(utilizadorEscolhido);
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Utilizador Removido com Sucesso");
	}

}
