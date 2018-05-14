package seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import modelo.Utilizador;

public class UtilizadorSistema extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilizador utilizador= new Utilizador();

	public UtilizadorSistema(Utilizador utilizador, Collection<? extends GrantedAuthority> authorities) {
		super(utilizador.getEmail(), utilizador.getSenha(), authorities);
		this.utilizador = utilizador;
	}

	public Utilizador getUtilizador() {
		return this.utilizador;
	}

}
