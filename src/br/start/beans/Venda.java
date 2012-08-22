package br.start.beans;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda {
	
	private int id;
	private Cliente cliente;
	private Collection<VendaProduto>vendaProdutoList;
	
	
	
	//Getters and Setters 
	@Id
	@GeneratedValue
	@Column(name="id_venda")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="id.venda")
	public Collection<VendaProduto> getVendaProdutoList() {
		return vendaProdutoList;
	}
	public void setVendaProdutoList(Collection<VendaProduto> vendaProdutoList) {
		this.vendaProdutoList = vendaProdutoList;
	}
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
