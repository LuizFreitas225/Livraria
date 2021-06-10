package application;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Session {
	private static Session session = null;
	
	
	private Session() {
		
	}
    public static Session  getInstance() {
    	 if( session  == null) {
    		 session = new Session();
    		 
    	 }
    	 return session;
    }
    
    private ExternalContext getExternalContext() {
    	if(FacesContext.getCurrentInstance() == null)   {
    		throw new RuntimeException("Voc� n�o est� rodando a aplica��o em um servidor web.");
    	}
    	return FacesContext.getCurrentInstance().getExternalContext();
    }
    
    public void setAttibute(String key, Object value ) {
    	getExternalContext().getSessionMap().put(key, value);
    }
    
    public Object get(String key) {
    	return getExternalContext().getSessionMap().get(key);
    }
}
