package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.Atleta;
import modelo.Equipa;
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
	
	public List<Atleta> getAtletasByEquipa(Equipa equipa) {
		String jpql = "select a from Atleta a where a.equipa = :equipa";

        TypedQuery<Atleta> query = manager.createQuery(jpql, Atleta.class);
        query.setParameter("equipa", equipa);
        
        List<Atleta> atletas = query.getResultList();
        
        return atletas;
	}

}
