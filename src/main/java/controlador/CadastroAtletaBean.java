package controlador;

import javax.enterprise.context.SessionScoped;
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
	
	@Inject
	private Atleta atletaEscolhido;

	private List<Equipa> equipas;

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
	public Atleta getAtletaEscolhido() {
		return atletaEscolhido;
	}

	public void setAtletaEscolhido(Atleta atletaEscolhido) {
		this.atletaEscolhido = atletaEscolhido;
	}

	public void salvar() {
		atletaRepository.salvar(atleta);

		atleta = new Atleta();
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
