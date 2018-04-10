package seguranca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import modelo.Grupo;
import modelo.Utilizador;
import repositorio.UtilizadorRepository;
import servico.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UtilizadorRepository utilizadorRepository = CDIServiceLocator.getBean(UtilizadorRepository.class);
		Utilizador utilizador = utilizadorRepository.porEmail(email);
		UtilizadorSistema user = null;

		if (utilizador != null) {
			user = new UtilizadorSistema(utilizador, getGrupos(utilizador));
		}
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Utilizador utilizador) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Grupo grupo : utilizador.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}

		return authorities;

	}

}
