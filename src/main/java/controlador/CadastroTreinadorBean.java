package controlador;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.Treinador;
import repositorio.TreinadorRepository;
import java.io.Serializable;

@Named
@SessionScoped
public class CadastroTreinadorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private TreinadorRepository repoTreinador;

	private Treinador treinador;

	public void salvar() {
		repoTreinador.salvar(treinador);
	}

}
