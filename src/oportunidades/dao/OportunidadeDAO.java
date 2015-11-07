package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oportunidades.model.Oportunidade;

public class OportunidadeDAO {
	
	private Connection connection;

	public OportunidadeDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excecao ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereOportunidade(Oportunidade oportunidade) {

		String sql = "INSERT INTO oportunidade"
				+ "(nome, remuneracao, cargaHoraria, descricao)" + " values (?,?,?,?)";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo Oportunidade");
			stmt.setString(1, oportunidade.getNome());
			stmt.setFloat(2, oportunidade.getRemuneracao());
			stmt.setInt(3, oportunidade.getCarga_horaria());			
			stmt.setString(4, oportunidade.getDescricao());

			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excecao ao inserir Oportunidade.");
			e.printStackTrace();
		}

	}

}
