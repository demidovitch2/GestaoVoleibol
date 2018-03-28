package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Equipa;
import util.Transactional;

public class EquipaRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Equipa equipa) {
		manager.merge(equipa);
	}

	public Equipa porId(Long id) {
		return manager.find(Equipa.class, id);
	}

	public List<Equipa> equipas() {
		return manager.createQuery("from Equipa", Equipa.class).getResultList();
	}

	@Transactional
	public void remover(Equipa equipa) {
		manager.remove(manager.merge(equipa));
	}
}
