package modelo;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enumeracao.AtletaEscalao;

@Table(name = "tb_atleta")
@Entity
public class Atleta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_atleta")
	private Long id;

	private String Posicao;

	@Enumerated(EnumType.STRING)
	private AtletaEscalao escalao;
	private double altura;
	private double peso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_equipa")
	private Equipa equipa;

	@Inject
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public String getPosicao() {
		return Posicao;
	}

	public void setPosicao(String posicao) {
		Posicao = posicao;
	}

	public AtletaEscalao getEscalao() {
		return escalao;
	}

	public void setEscalao(AtletaEscalao escalao) {
		this.escalao = escalao;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Equipa getEquipa() {
		return equipa;
	}

	public void setEquipa(Equipa equipa) {
		this.equipa = equipa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
