package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@RequestScoped
public class ProdutoBean {
	private Produto produto = new Produto();
	@Inject
	private ProdutoDao dao;
	
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
	
	public void remove(){				
		dao.remove(produto);		
		produtos = dao.listaTodos();	
		this.produto = new Produto();
	}

}
