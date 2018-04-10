package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Pessoa;
import util.Transactional;

public class PessoaRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Pessoa pessoa) {
		manager.merge(pessoa);
	}

	@Transactional
	public void remover(Pessoa pessoa) {
		manager.remove(pessoa);
	}

	public List<Pessoa> getPessoas() {
		return manager.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

}
