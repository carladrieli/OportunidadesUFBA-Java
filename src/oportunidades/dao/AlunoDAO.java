package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oportunidades.model.Aluno;
import oportunidades.model.Usuario;

public class AlunoDAO {

	private Connection connection;

	public AlunoDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excecao ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereAluno(Aluno aluno, int cursoId) {
		
		String sql = "INSERT INTO aluno"
				+ "(semestre, matricula, previsaoConclusao, usuario_id, curso_id)"
				+ " values (?,?,?,?,?)";

		PreparedStatement stmt = null;
		Usuario aux = null;

		try {
			System.out.println("Inserindo aluno");
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			aluno.setTipo(1);
			System.out.println("Inserindo Usuario");
			usuarioDAO.insereUsuario(aluno);
			
			aux = usuarioDAO.buscaUsuarioId(aluno);
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, aluno.getSemestre());
			stmt.setString(2, aluno.getMatricula());
			stmt.setString(3, aluno.getPrevisaoConclusao());
			stmt.setInt(4, aux.getId());
			stmt.setInt(5, cursoId);

			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excecao ao inserir Aluno.");
			e.printStackTrace();
		}

	}
}
