package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oportunidades.model.Curso;

public class CursoDAO {
	
	private Connection connection;

	public CursoDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereCurso(Curso curso) {

		String sql = "INSERT INTO curso"
				+ "(nome, idArea)" + " values (?,?)";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo curso");
			stmt.setString(1, curso.getNome());
			stmt.setLong(2, curso.getArea().getId());
			
			System.out.println(curso.getArea().getId());
			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao inserir Curso.");
			e.printStackTrace();
		}

	}


}
