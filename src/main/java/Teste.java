import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Utilizador;

public class Teste {
	
	public static void main(String[]args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestaoVoleibolPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Utilizador utilizador = new Utilizador();
		utilizador.setSenha("1234");
		utilizador.setNome("boris");
		manager.persist(utilizador);
		
		tx.commit();
		
	}

}
