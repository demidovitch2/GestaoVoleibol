package controlador;

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
	}

	public void remover() {
		arbitroRepo.remove(arbitroEscolhido);
	}
}
