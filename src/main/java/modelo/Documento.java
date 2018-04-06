package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import enumeracao.DocumentoTipo;

@Table(name = "tb_documento")
@Entity
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_documento")
	private Long id;

	@NotEmpty(message="Campo Obrigatório")
	private String numero;
	@NotNull(message="Campo Obrigatório")
	private DocumentoTipo tipo;
	@NotEmpty(message="Campo Obrigatório")
	private String estadoDocumento;
	@NotNull(message="Campo Obrigatório")
	private Date dataEmissao;
	private Date dataValidade;
	private String fotoFrontalPath;
	private String fotoTraseiraPath;
	private byte[] fotoFrontal;
	private byte[] fotoTraseira;
	@NotEmpty(message="Campo Obrigatório")
	private String localEmissao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public DocumentoTipo getTipo() {
		return tipo;
	}

	public void setTipo(DocumentoTipo tipo) {
		this.tipo = tipo;
	}

	public String getEstadoDocumento() {
		return estadoDocumento;
	}

	public void setEstadoDocumento(String estadoDocumento) {
		this.estadoDocumento = estadoDocumento;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getFotoFrontalPath() {
		return fotoFrontalPath;
	}

	public void setFotoFrontalPath(String fotoFrontalPath) {
		this.fotoFrontalPath = fotoFrontalPath;
	}

	public String getFotoTraseiraPath() {
		return fotoTraseiraPath;
	}

	public void setFotoTraseiraPath(String fotoTraseiraPath) {
		this.fotoTraseiraPath = fotoTraseiraPath;
	}

	public byte[] getFotoFrontal() {
		return fotoFrontal;
	}

	public void setFotoFrontal(byte[] fotoFrontal) {
		this.fotoFrontal = fotoFrontal;
	}

	public byte[] getFotoTraseira() {
		return fotoTraseira;
	}

	public void setFotoTraseira(byte[] fotoTraseira) {
		this.fotoTraseira = fotoTraseira;
	}

	public String getLocalEmissao() {
		return localEmissao;
	}

	public void setLocalEmissao(String localEmissao) {
		this.localEmissao = localEmissao;
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
		Documento other = (Documento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
