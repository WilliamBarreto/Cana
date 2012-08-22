package br.start.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String cep;
	private Date dataNasc;
	private String telefone;
	

	
	//Getters and Setters
	@Id
	@GeneratedValue
	@Column(name="id_cliente")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="cpf")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}	
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="logradouro")
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(name="bairro")
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name="cidade")
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name="cep")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name="dataNasc")
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Column(name="telefone")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
