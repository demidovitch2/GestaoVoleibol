package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Arbitro;
import util.Transactional;

public class ArbitroRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Arbitro arbitro) {
		manager.merge(arbitro);
	}

	@Transactional
	public void remove(Arbitro arbitro) {
		manager.remove(manager.merge(arbitro));
	}

	public Arbitro porId(Long id) {
		return manager.find(Arbitro.class, id);
	}

	public List<Arbitro> getArbitros() {
		return manager.createQuery("from Arbitro", Arbitro.class).getResultList();
	}
}
