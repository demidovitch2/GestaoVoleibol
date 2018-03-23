package util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction tx = manager.getTransaction();
		boolean criador = false;

		try {
			if (!tx.isActive()) {
				tx.begin();
				tx.rollback();

				tx.begin();

				criador = true;

			}
			return context.proceed();
		} catch (Exception e) {
			if (tx != null && criador) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (tx != null && tx.isActive() && criador) {
				tx.commit();
			}
		}
	}

}
