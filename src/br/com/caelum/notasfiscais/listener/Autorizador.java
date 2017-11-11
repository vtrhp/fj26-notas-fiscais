package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.mb.UsuarioLogadoBean;

public class Autorizador implements PhaseListener{
	
	@Inject 
	private UsuarioLogadoBean usuarioLogado;
	
	public PhaseId getPhaseId(){
		return PhaseId.RESTORE_VIEW; /*Define que nosso Autorizador deve estar associado � fase RESTORE_VIEW*/
	}

	
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();  // TODO Auto-generated method stub
		
		if("/login.xhtml".equals(context.getViewRoot().getViewId())){
			return;
		}
		//Verifica��o
		if(!usuarioLogado.isLogado()){
			NavigationHandler handler = context.getApplication()
					.getNavigationHandler();
			
			handler.handleNavigation(context, null, "login?faces-redirect=true");			
			//Efetua a renderiza��o da tela
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
