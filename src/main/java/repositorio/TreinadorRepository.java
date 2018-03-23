package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Treinador;

public class TreinadorRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Treinador treinador) {

	}

	public Treinador porId(Long id) {
		return manager.find(Treinador.class, id);
	}

	public List<Treinador> treinadores() {
		return manager.createQuery("from Treinador", Treinador.class).getResultList();
	}

}
