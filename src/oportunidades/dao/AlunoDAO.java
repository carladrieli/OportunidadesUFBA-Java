package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oportunidades.model.Aluno;

public class AlunoDAO {

	private Connection connection;

	public AlunoDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereAluno(Aluno aluno) {

		String sql = "INSERT INTO aluno"
				+ "(idusuario, semestre, previsao_conclusao, idcurso)"
				+ " values (?,?,?,?)";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo aluno");
			stmt.setInt(1, aluno.getUsuario().getId());
			stmt.setString(2, aluno.getSemestre());
			stmt.setString(3, aluno.getPrevisao_conclusao());
			stmt.setInt(4, aluno.getCurso().getId());

			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao inserir Aluno.");
			e.printStackTrace();
		}

	}
}
