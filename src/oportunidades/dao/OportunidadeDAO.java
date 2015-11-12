package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public Oportunidade insereOportunidade(Oportunidade oportunidade) {

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

			if (stmt.execute()) {
				return oportunidade;				
			}			

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excecao ao inserir Oportunidade.");
			e.printStackTrace();
			oportunidade = null;
		}
		return oportunidade;

	}
	
	public List<Oportunidade> listaOportunidade() {

		String sql = "SELECT id, nome, remuneracao, cargaHoraria, descricao FROM oportunidade";

		Statement stmt = null;
		ResultSet rs = null;
		List<Oportunidade> listaOportunidade = new ArrayList<Oportunidade>();

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			Oportunidade oportunidade = null;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();				
			while (rs.next()) {
				oportunidade = new Oportunidade();
				Integer id = (Integer) rs.getObject("id");				
				oportunidade.setId(id);				
				String nome = rs.getString("nome");				
				oportunidade.setNome(nome);				
				listaOportunidade.add(oportunidade);
			}
			stmt.close();		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excecao ao buscar Oportunidade.");
			e.printStackTrace();
		}
		
		return listaOportunidade;
	}
	

}
