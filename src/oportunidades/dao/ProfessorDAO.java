package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oportunidades.model.Professor;

public class ProfessorDAO {
	private Connection connection;

	public ProfessorDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereAluno(Professor professor) {

		String sql = "INSERT INTO professor" + "(idusuario, siape)"	+ " values (?,?)";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo Professor");
			stmt.setInt(1, professor.getUsuario().getId());
			stmt.setString(2, professor.getSiape());
			

			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao inserir Professor.");
			e.printStackTrace();
		}

	}

}
