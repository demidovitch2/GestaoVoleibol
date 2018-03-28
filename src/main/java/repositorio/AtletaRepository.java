package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Atleta;
import util.Transactional;

public class AtletaRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Atleta atleta) {
		manager.merge(atleta);
	}

	@Transactional
	public void remover(Atleta atleta) {
		manager.remove(manager.merge(atleta));
	}

	public Atleta porId(Long id) {
		return manager.find(Atleta.class, id);
	}

	public List<Atleta> getAtletas() {
		return manager.createQuery("from Atleta", Atleta.class).getResultList();
	}

}
