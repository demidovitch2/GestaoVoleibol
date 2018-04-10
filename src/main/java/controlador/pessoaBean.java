package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import modelo.Pessoa;
import repositorio.PessoaRepository;

@Named
@ViewScoped
public class pessoaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaRepository pessoaRepository;

	private Pessoa pessoa = new Pessoa();
	private Pessoa pessoaEscolhida = new Pessoa();

	private List<Pessoa> pessoas = new ArrayList<>();

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoaEscolhida() {
		return pessoaEscolhida;
	}

	public void setPessoaEscolhida(Pessoa pessoaEscolhida) {
		this.pessoaEscolhida = pessoaEscolhida;
	}

	public void remover() {
		pessoaRepository.remover(pessoaEscolhida);
	}

	public List<Pessoa> getPessoas() {
		return pessoaRepository.getPessoas();
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
