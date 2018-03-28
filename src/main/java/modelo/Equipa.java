package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_equipa")
public class Equipa implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos da Classe

	@Id
	@GeneratedValue
	@Column(name = "id_equipa")
	private Long id;

	private String nome;
	private String codigo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_treinador")
	private Treinador treinador;
	private String medico;
	private String fisioterapeuta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_treinadorAdjunto")
	private Treinador treinadorAdjunto;
	private String presidente;
	private String delegado;

	@OneToMany(targetEntity = Atleta.class, mappedBy = "equipa", fetch = FetchType.EAGER)
	private List<Atleta> atletas;

	// M�todos Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getFisioterapeuta() {
		return fisioterapeuta;
	}

	public void setFisioterapeuta(String fisioterapeuta) {
		this.fisioterapeuta = fisioterapeuta;
	}

	public Treinador getTreinadorAdjunto() {
		return treinadorAdjunto;
	}

	public void setTreinadorAdjunto(Treinador treinadorAdjunto) {
		this.treinadorAdjunto = treinadorAdjunto;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getDelegado() {
		return delegado;
	}

	public void setDelegado(String delegado) {
		this.delegado = delegado;
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	@Override
	public String toString() {
		return nome;
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
		Equipa other = (Equipa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
