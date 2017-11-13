package br.com.caelum.notasfiscais.mb;



import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private UsuarioDao dao;
	
	private Usuario usuario = new Usuario();
	
	public String efetuaLogin(){		
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido){
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		}else{
			usuarioLogado.deslogar(usuario);
			this.usuario = new Usuario();
			return "login";
		}
		
	}
	
	public void deslogar(Usuario usuario){
		this.usuario = null;
	}
	
	
	public Usuario getUsuario(){
		return this.usuario;
	}

}
