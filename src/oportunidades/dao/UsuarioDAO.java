package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oportunidades.model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuario"
				+ "(nome, senha, email, descricao)" + " values (?,?,?,?)";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo usuário");
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setInt(4, usuario.getTipo());

			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao inserir Usuário.");
			e.printStackTrace();
		}

	}

}
