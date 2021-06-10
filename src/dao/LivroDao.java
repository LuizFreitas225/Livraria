package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Capa;
import model.Categoria;
import model.Livro;
import model.ModoDeBusca;

public class LivroDao implements DAO {
   
int ultimoId=0;
	

	public boolean inserir(Livro obj) {
		
		
		
		
	
        String sql ="INSERT INTO livro ( descricao,preco,categoria,capa,autor,nome,qt_paginas, data_publicacao,estoque)"
        		+ "VALUES('" +obj.getDescricao()+ "' ,'" +obj.getPreco()+"' ,'" 
        				+obj.getCategoria().getValue()+"', '"+obj.getCapa().getValue()+"','" +obj.getAutor()+ "' ,'" +obj.getNome()+
        						"','" +obj.getQtPaginas()+ " ','" +obj.getDataPublicacao()+"' , '"+obj.getEstoque() +"' )"; 
        
        						 
        				
        
		return DAO.executaSql(sql);
	}

	
	public boolean alterar(Livro obj) {
		
		String sql= "UPDATE livro SET   descricao = ' "+ obj.getDescricao() + " ',"
				+ " capa= ' "+ obj.getCapa().getValue() + " ', Categoria= ' " +obj.getCategoria().getValue() + " ',"
						+ "preco= ' "+ obj.getPreco() + " ', nome= ' "+ obj.getNome() + " ', qt_paginas= ' "+ obj.getQtPaginas()+
						"' , data_publicacao=  '" +obj.getDataPublicacao()+"' , estoque=  '" +obj.getEstoque()+"' WHERE id=" +obj.getId();
	
		  return DAO.executaSql(sql);
		
	}

	
	public boolean excluir(Integer id) {
		String sql= "DELETE FROM livro WHERE id= " +  id ;
		try {
			DAO.executaSql(sql);

		}catch( Exception e) {
			
		  e.printStackTrace();
		  return false;
		}
		return true;
	}


	
	public List<Livro> obterTodos() {
		ResultSet res= DAO.executaBusca("SELECT * FROM livro");
		Livro objAux = new Livro();
		List<Livro> listLivro = new ArrayList<Livro>();
		try {
			
			while(res.next()) {
				
				//SE  E COMENTE SE ESSE ID AINDA NÃO CONSTAR NO BANCO 
				//ESSE PRODUTO SERÁ INSERIDO
				objAux.setId(res .getInt("id"));			
				objAux.setNome(res.getString("nome"));
				objAux.setDescricao(res.getString("descricao"));
				objAux.setCapa(Capa.buscarPorValue(res.getInt("capa")));
				objAux.setCategoria(Categoria.buscarPorValue(res.getInt("categoria")));
				objAux.setPreco(res.getInt("preco"));
				objAux.setAutor(res.getString("autor"));
				objAux.setEstoque(res.getInt("estoque"));
				objAux.setQtPaginas(res.getInt("qt_paginas"));
				//se data_ublicação for igual a null data recebe true
				Boolean data= (res.getDate("data_publicacao").toLocalDate() == null);
				//se data for true DataPublicacao receve null se nao recebe o valor do no banco
				objAux.setDataPublicacao(data ? null: res.getDate("data_publicacao").toLocalDate()); 
				listLivro.add(objAux.getClone());
			    
				
               }
			
			
        
		}catch( Exception e) {
			
		  e.printStackTrace();
		  return null;
		}

		return listLivro;
	}
	
	public Livro obterPorId(Integer id) {
		ResultSet res= DAO.executaBusca("SELECT * FROM livro WHERE id = "+ id);
		Livro objAux = new Livro();
		
		try {
			
			while(res.next()) {
				
				objAux.setId(res .getInt("id"));			
				objAux.setNome(res.getString("nome"));
				objAux.setDescricao(res.getString("descricao"));
				objAux.setCapa(Capa.buscarPorValue(res.getInt("capa")));
				objAux.setCategoria(Categoria.buscarPorValue(res.getInt("categoria")));
				objAux.setPreco(res.getInt("preco"));
				objAux.setAutor(res.getString("autor"));
				objAux.setEstoque(res.getInt("estoque"));
				objAux.setQtPaginas(res.getInt("qt_paginas"));
				//se data_ublicação for igual a null data recebe true
				Boolean data= (res.getDate("data_publicacao").toLocalDate() == null);
				//se data for true DataPublicacao receve null se nao recebe o valor do no banco
				objAux.setDataPublicacao(data ? null: res.getDate("data_publicacao").toLocalDate()); 
				
			    
				
               }
			
			
        
		}catch( Exception e) {
			
		  e.printStackTrace();
		  return null;
		}

		return objAux;
	}


	public List<Livro> filtrar(String texto, ModoDeBusca modo) {
		String sql= "";
		 if( modo == null || texto == null || texto.equals("")) {
			 sql = "select * from livro";
			 
		 }
		 else if ( modo == ModoDeBusca.AUTOR) {
			  sql = "select * from livro where autor ilike '%" +texto +"%'";
				 
		 }
		 else if ( modo == ModoDeBusca.NOME) {
			 sql = "select * from livro where nome ilike '%" +texto+"%'";
			 
		 }
		
		 ResultSet res=  DAO.executaBusca(sql);
		 Livro objAux = new Livro();
			List<Livro> listLivro = new ArrayList<Livro>();
			try {
				
				while(res.next()) {
					
					//SE  E COMENTE SE ESSE ID AINDA NÃO CONSTAR NO BANCO 
					//ESSE PRODUTO SERÁ INSERIDO
					objAux.setId(res .getInt("id"));			
					objAux.setNome(res.getString("nome"));
					objAux.setDescricao(res.getString("descricao"));
					objAux.setCapa(Capa.buscarPorValue(res.getInt("capa")));
					objAux.setCategoria(Categoria.buscarPorValue(res.getInt("categoria")));
					objAux.setPreco(res.getInt("preco"));
					objAux.setAutor(res.getString("autor"));
					objAux.setEstoque(res.getInt("estoque"));
					objAux.setQtPaginas(res.getInt("qt_paginas"));
					//se data_ublicação for igual a null data recebe true
					Boolean data= (res.getDate("data_publicacao").toLocalDate() == null);
					//se data for true DataPublicacao receve null se nao recebe o valor do no banco
					objAux.setDataPublicacao(data ? null: res.getDate("data_publicacao").toLocalDate()); 
					listLivro.add(objAux.getClone());
				 
					
	               }
	        
			}catch( Exception e) {
				
			  e.printStackTrace();
			  return null;
			}

			return listLivro;
	}
	
	
	
}
