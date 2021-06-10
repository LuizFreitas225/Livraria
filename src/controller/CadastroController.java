package controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.FlashEasy;
import dao.LivroDao;
import model.Capa;
import model.Categoria;
import model.Livro;

@Named
@ViewScoped
public class CadastroController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8050794200595677235L;
	private Livro livro;
	LivroDao daoLivro =new LivroDao();
	
	
	
	public CadastroController() {
		super();
		 Flash flash = FlashEasy.getInstance();
			flash.keep("livro");
			setLivro((Livro)flash.get("livro"));
	}

	public void incluir() {
	       if(daoLivro.inserir(livro)){
	    	   FacesContext.getCurrentInstance().addMessage(null,
	   				new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão realizada com sucesso.", null));
	        }else {
	        	 FacesContext.getCurrentInstance().addMessage(null,
	        				new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão falhou.", null));
	        }
		
		}
	
	public void alterar() {
		if(daoLivro.alterar(getLivro())) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração realizada com sucesso.", null));
		}else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração falhou.", null));
		}
	
	}
	
	public void limpar() {
		System.out.println("Entrou no metódo limpar");
		this.setLivro(null);
	}

	
	public Livro getLivro() {
		if (livro ==null)
			livro = new Livro();
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public LivroDao getDaoLivro() {
		return daoLivro;
	}
	public void setDaoLivro(LivroDao daoLivro) {
		this.daoLivro = daoLivro;
	}
	
	
	public Capa[] getListarCapa(){
		return Capa.values();
	}
	
	public Categoria[] getListarCategoria(){
		return Categoria.values();
	}
	



	
      
}
