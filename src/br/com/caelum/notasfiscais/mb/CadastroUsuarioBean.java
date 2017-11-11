package br.com.caelum.notasfiscais.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class CadastroUsuarioBean {
	@Inject 
	private Usuario usuario;
	
	@Inject 
	private UsuarioDao dao;
	
	public void grava(Usuario usuario){
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido){			
			System.out.println("O usuario já existe"); 
		}else{
				dao.adiciona(usuario);
		}
	}

}
