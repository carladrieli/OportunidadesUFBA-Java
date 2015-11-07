package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oportunidades.model.Aluno;
import oportunidades.model.Empresa;
import oportunidades.model.Usuario;

public class EmpresaDAO {

	private Connection connection;

	public EmpresaDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excecao ao criar Conexao.");
			e.printStackTrace();
		}

	}
	
	public void insereEmpresa(Empresa empresa) {
		
		String sql = "INSERT INTO empresa"
				+ "(idusuario, endereco)"
				+ " values (?,?)";
		
		PreparedStatement stmt = null;
		//Usuario aux = null;

		try {
			System.out.println("Inserindo empresa");
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}
			
			//UsuarioDAO usuarioDAO = new UsuarioDAO();
			//busca idusuarioEmpresa			
		//	aux = usuarioDAO.buscaUsuarioId(usuario);
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, 1);
			stmt.setString(2, empresa.getEndereco());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excecao ao inserir Empresa.");
			e.printStackTrace();
		}
	}

}
