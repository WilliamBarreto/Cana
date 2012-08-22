package br.start.managedBean;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;

import br.start.beans.Produto;
import br.start.persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class ProdutoManagedBean {
	
	private Produto produto;
	private List<Produto> produtos;
	byte[] foto;
	String arquivo;
	
	
	public ProdutoManagedBean(){
		this.produto = new Produto();
		this.produtos = new ProdutoDAO().listar();
	}
	
	
	public String listar(){
		this.produtos = new ProdutoDAO().listar();
		return "produtoLista";
	}
	
	public String salvar(){
		new ProdutoDAO().salvar(this.produto);
		return "produtoForm";
	}
	
	
public void uploadAction (FileUploadEvent event){
		
		try {
			
			
			// pegando a foto
			foto = event.getFile().getContents();
			Date data = new Date();
			//pegando o nome da foto com o caminho
			String nome = (data.getTime() + ".jpg");
			
			//pegando o caminho que a foto vai ser gravada
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();  
			arquivo = scontext.getRealPath("/resources/images/" + nome);
			
			//setando o nome da foto no banco
			this.produto.setUrl(nome);
			
			if(foto != null) {  
	            FacesMessage msg = new FacesMessage("Sucesso", event.getFile().getFileName() + "Foi upada!");  
	            FacesContext.getCurrentInstance().addMessage(null, msg);  
	        }  

		}catch (Exception ex){
			FacesMessage msg = new FacesMessage("ERRO", event.getFile().getFileName() + "Não foi upada!");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
		//gravar imagen na aplicacao
		public void gravar(){
			FileOutputStream fos;
			try {
			//passando o caminho;	
			fos = new FileOutputStream(arquivo);
			//passando o arquivo;
			fos.write(foto);
			fos.close();
			
			} catch (FileNotFoundException ex) {
			Logger.getLogger(ProdutoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
			Logger.getLogger(ProdutoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
			}
	}

	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
