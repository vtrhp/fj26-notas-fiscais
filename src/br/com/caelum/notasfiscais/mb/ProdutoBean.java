package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@SessionScoped
public class ProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Produto produto = new Produto();
	@Inject
	private ProdutoDao dao;
	
	/*public ProdutoDao getDao() {
		return dao;
	}

	public void setDao(ProdutoDao dao) {
		this.dao = dao;
	}*/ //teste metodo remove

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	private List<Produto> produtos;
	
	public List<Produto> getProdutos(){
		if(produtos == null){
			System.out.println("Carregando produtos");
			produtos = dao.listaTodos();			
		}
		
		return produtos;
	}
	
	public Produto getProduto(){
		return this.produto;
	}
	
	public String grava(){
				
		if(produto.getId() == null){
			dao.adiciona(produto);
		}else{
			dao.atualiza(produto);
		}
		produtos = dao.listaTodos();
		this.produto = new Produto();
		
		return "produto?faces-redirect=true";
		
	}
	
	public void remove(Produto produto){				
		this.dao.remove(produto);		
		this.produtos = dao.listaTodos();				
	}

}
