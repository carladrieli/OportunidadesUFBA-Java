package oportunidades.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoDAO {
	
		
	public Connection getConexao()  throws Exception{
						 
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			return DriverManager.getConnection("jdbc:mysql://localhost/oportunidadesufba", "root", "root");
			
		} catch (Exception e) {
			System.out.println("Excecao com.mysql");
			throw new Exception(e.getMessage());
		}		
	
	}	
	
}
