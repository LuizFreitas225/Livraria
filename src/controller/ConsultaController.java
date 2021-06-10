package controller;

import java.io.Serializable;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.FlashEasy;
import dao.LivroDao;

import model.Livro;
import model.ModoDeBusca;

@Named
@RequestScoped
public class ConsultaController implements Serializable  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2545799755164934515L;
	private Livro livro;
	LivroDao daoLivro =new LivroDao();
	List<Livro> listLivro;
    private String textoFiltro="";
	private ModoDeBusca modo ;
	
	
	
	public String editar(Livro obj) {
     Livro book = daoLivro.obterPorId(obj.getId());
		
		Flash flash = FlashEasy.getInstance();
		flash.keep("livro");
		flash.put("livro",book);
		
		return "cadastro.xhtml?faces-redirect=true";
	}
	
   public void excluir(Livro livro) {
	   if(daoLivro.excluir(livro.getId())) {
		   FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão realizada com sucesso.", null));
		   
	   }else {
		  
			   FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão falhou.", null)); 
	   }
		
	}
	
	
	
	public List<Livro> getFiltrar() {
		List<Livro>  listFiltrada = daoLivro.filtrar(textoFiltro, modo);
		if(listFiltrada == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "A buscar falhou, tente novamente.", null));
			return getListLivro();
			
		}
		else
			return listFiltrada;
	}
	
	public List<Livro> getListLivro() {
		
			listLivro = daoLivro.obterTodos();
		return listLivro;
	}
	public void setListLivro(List<Livro> listLivro) {
		this.listLivro = listLivro;
	}
	
	
	public ModoDeBusca[] getListarModoDeBusca() {
		return ModoDeBusca.values();
	}
	
	public Livro getLivro() {
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
	public String getTextoFiltro() {
		return textoFiltro;
	}
	public void setTextoFiltro(String textoFiltro) {
		this.textoFiltro = textoFiltro;
	}

	public ModoDeBusca getModo() {
		return modo;
	}

	public void setModo(ModoDeBusca modo) {
		this.modo = modo;
	}
	
	
}
