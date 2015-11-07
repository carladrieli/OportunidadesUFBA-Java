package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import oportunidades.model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excecao ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuario"
				+ "(nome, senha, email, tipo, descricaoPerfil)" + " values (?,?,?,?,?)";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo usuario");
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setInt(4, usuario.getTipo());
			stmt.setString(5, usuario.getDescricaoPerfil());

			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excecao ao inserir Usuario.");
			e.printStackTrace();
		}

	}
	
	public void insereUsuarioProfessor(Usuario usuario) {

		String sql = "INSERT INTO usuario"
				+ "(nome, senha, email, tipo, descricaoPerfil)" + " values (?,?,?,?,?)";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo professor");
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setInt(4, 3);
			stmt.setString(5, usuario.getDescricaoPerfil());

			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excecao ao inserir Professor.");
			e.printStackTrace();
		}

	}
	
	public Usuario buscaUsuarioId(Usuario usuario) {
		
		String sql = "SELECT id, email FROM usuario WHERE email = '" + usuario.getEmail() + "';";
		Usuario aux = null;
		
		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Buscando usuario id");
			while (rs.next()) {	
				aux = new Usuario();
				aux.setId(rs.getInt("id"));
			}
			
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Execao ao buscar usuario id.");
			e.printStackTrace();
		}
		
		return aux;
		
	}

}
