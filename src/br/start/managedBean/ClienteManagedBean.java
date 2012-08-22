package br.start.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.start.beans.Cliente;
import br.start.persistencia.ClienteDAO;

@ManagedBean
@SessionScoped
public class ClienteManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<Cliente> clientes;
	
	public ClienteManagedBean(){
		this.cliente = new Cliente();
		this.clientes = new ClienteDAO().listar();
	}
	
	public String salvar(){
		
		new ClienteDAO().salvar(this.cliente);
		return listar();
	}
	
	
	public String listar(){
		this.clientes = new ClienteDAO().listar();
		return "clienteLista.jsf";
	}
	
	public String incluir(){
		
		return "clienteForm";
	}
	
	
	//Getters and Setters
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

}
