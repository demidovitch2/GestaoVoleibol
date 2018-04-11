package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Grupo;
import util.Transactional;

public class GrupoRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Grupo grupo) {
		manager.merge(grupo);
	}

	@Transactional
	public void remover(Grupo grupo) {
		manager.remove(grupo);
	}

	public List<Grupo> getGrupos() {
		return manager.createQuery("from Grupo", Grupo.class).getResultList();
	}

	public Grupo porId(Long id) {
		return manager.find(Grupo.class, id);
	}
}
