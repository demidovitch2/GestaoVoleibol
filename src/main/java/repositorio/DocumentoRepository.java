package repositorio;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Documento;

public class DocumentoRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Documento porId(Long id) {
		return manager.find(Documento.class, id);
	}

}
