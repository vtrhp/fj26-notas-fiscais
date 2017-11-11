package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	public void efetuaLogin(){
		UsuarioDao dao = new UsuarioDao();
		boolean loginValido = dao.existe(usuario);
		System.out.println("O login era valido? " + loginValido);
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}

}
