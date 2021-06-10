package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



public interface DAO {
    

	
	public static Connection getConnection() {
		// Registro do driver do postgresql
	    try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager
					.getConnection("jdbc:postgresql://127.0.0.1:5432/livraria", "topicos1", "123456");
			return connection;
	    } catch (ClassNotFoundException e) {
			System.out.println("O Driver não foi encontrado.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Falha na conexao com o banco de dados.");
			e.printStackTrace();
		}
	    return null;
	}
	
	
	public static boolean  executaSql(String sql) {
		int linhaAlter=0;
		try {
			//executeUpdate: Retorna um inteiro que representa o número de linhas afetadas pela instrução SQL. 
			//Utilize este método se você estiver usando INSERT, DELETEou UPDATEinstruções SQL.
			
			Statement stm = DAO.getConnection().createStatement();
			
			//O metodo retorna aquantidade de linhas alteradas
			
			linhaAlter = stm.executeUpdate(sql) ;
			DAO.getConnection().close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		try {
			DAO.getConnection().close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	   	//SE LINHAS ALTERAS FOR <= ELE RETORNA FALSE
		return (linhaAlter <= 0) ? false: true;
      }
	
	public static ResultSet  executaBusca(String sql) {
		ResultSet resultado ;
		try {
			Statement stm = DAO.getConnection().createStatement();
			//executeQuery: Retorna um  objeto ResultSet.
			//Esse objeto equivalente a um resultado no banco, sendo que por meio do  res.next() você pode navegar entre as linhas
			
			resultado= stm.executeQuery(sql);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		try {
			DAO.getConnection().close();
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return resultado;
		
	}
	
}

