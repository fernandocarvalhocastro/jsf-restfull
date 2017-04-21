package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@SequenceGenerator(name="seqConsultor",
sequenceName="SQ_TB_CONSULTOR",allocationSize=1)
public class Consultor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqConsultor")
	private int codigo;
	
	private String nome;
	
	private String cpf;
	
	private String telefone;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
