package controlador;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.Grupo;
import repositorio.GrupoRepository;
import util.FacesUtil;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CadastroGrupoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoRepository grupoRepository;
	private Grupo grupo = new Grupo();
	private Grupo grupoEscolhido = new Grupo();

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Grupo getGrupoEscolhido() {
		return grupoEscolhido;
	}

	public void setGrupoEscolhido(Grupo grupoEscolhido) {
		this.grupoEscolhido = grupoEscolhido;
	}

	public void salvar() {
		grupoRepository.salvar(grupo);
		this.grupo = new Grupo();
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Grupo adicionado com Sucesso");
	}

	public void remover() {
		grupoRepository.remover(grupoEscolhido);
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Grupo Removido com Sucesso");
	}

	public List<Grupo> getGrupos() {
		return grupoRepository.getGrupos();
	}

	public boolean isEditando() {
		return this.grupo.getId() != null;
	}

}
