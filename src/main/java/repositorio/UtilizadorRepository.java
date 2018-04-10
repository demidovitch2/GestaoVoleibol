package repositorio;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import modelo.Utilizador;
import util.FacesUtil;
import util.Transactional;

public class UtilizadorRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Utilizador utilizador) {
		manager.merge(utilizador);
	}

	@Transactional
	public void remover(Utilizador utilizador) {
		manager.remove(utilizador);
	}

	public List<Utilizador> utilizadores() {
		return manager.createQuery("from Utilizador", Utilizador.class).getResultList();
	}

	public Utilizador porId(Long id) {
		return manager.find(Utilizador.class, id);
	}

	public Utilizador porEmail(String email) {
		Utilizador utilizador = null;
		try {
			utilizador = this.manager.createQuery("from Utilizador where lower(email)=:email", Utilizador.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
					"Nenhum Utilizador encontrado com o E-mail introduzido");
		}
		return utilizador;
	}

}
