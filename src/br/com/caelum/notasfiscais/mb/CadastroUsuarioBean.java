package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class CadastroUsuarioBean implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private UsuarioDao dao;
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void grava(){

			dao.adiciona(usuario);
		}

	



}
