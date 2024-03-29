package br.start.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="venda_produto")
public class VendaProduto {
	
	@EmbeddedId
	private VendaProdutofk id;
	
	@Column(name="preco")
	private double preco;
	
	@Column(name="quantidade")
	private int quantidade;
	
	
	//Getters And Setters
	
	public VendaProdutofk getId() {
		return id;
	}
	
	public void setId(VendaProdutofk id) {
		this.id = id;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//Chave composta
	@Embeddable
	public class VendaProdutofk implements Serializable{
			
		private static final long serialVersionUID = 1L;

		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name = "id_venda")
		private Venda venda;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name = "id_produto")
		private Produto produto;

		public VendaProdutofk(){
			this.venda = new Venda();
			this.produto = new Produto();
		}
		
		
		//Getters and Setters
		public Venda getVenda() {
			return venda;
		}
		public void setVenda(Venda venda) {
			this.venda = venda;
		}
		
		public Produto getProduto() {
			return produto;
		}
		public void setProduto(Produto produto) {
			this.produto = produto;
		}

	}

}
