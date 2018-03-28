package controlador;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import enumeracao.DocumentoTipo;
import modelo.Arbitro;
import repositorio.ArbitroRepository;

import java.io.Serializable;

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

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public DocumentoTipo[] getDocumentosTipo() {
		return DocumentoTipo.values();
	}

	public void salvar() {
		arbitroRepo.salvar(arbitro);

		arbitro = new Arbitro();
	}
}
