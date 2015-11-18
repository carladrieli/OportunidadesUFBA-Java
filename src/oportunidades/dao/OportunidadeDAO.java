package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oportunidades.model.Curso;
import oportunidades.model.Oportunidade;
import sun.misc.Cleaner;

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

	public Oportunidade insereOportunidade(Oportunidade oportunidade, String[] listaCursoSelecionados) {

		String sql = "INSERT INTO oportunidade (nome, remuneracao, cargaHoraria, descricao, instituicao_idinstituicao, instituicao_usuario_id)" + " values (?,?,?,?,?,?);";

		PreparedStatement stmt = null;

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			System.out.println("Inserindo Oportunidade");
			stmt.setString(1, oportunidade.getNome());
			stmt.setFloat(2, oportunidade.getRemuneracao());
			stmt.setInt(3, oportunidade.getCarga_horaria());			
			stmt.setString(4, oportunidade.getDescricao());
			stmt.setInt(5, 1);
			stmt.setInt(6, 1);
			
			stmt.execute();
			
			//pegando id de oportunidade
			Long id_oportunidade = null;
			try {
				ResultSet opt = stmt.getGeneratedKeys();
				if (opt.next()) {
					id_oportunidade = opt.getLong(1);
					System.out.println(id_oportunidade);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Buscar id erro" + e.getMessage());
			}			
			//curso_has_oportunidade
			String sql1 = "INSERT INTO curso_has_oportunidade (curso_id, oportunidade_id) VALUES (?,?);";
			System.out.println("Inserindo curso_has_oportunidade!");
			for (String i : listaCursoSelecionados) {
				PreparedStatement stmt1 = null;
				stmt1 = connection.prepareStatement(sql1);
				Integer id = new Integer(i);
				System.out.println("id_curso " + i);
				stmt1.setInt(1, id);
				stmt1.setLong(2, id_oportunidade);
				stmt1.execute();
				stmt1.close();
			}
			System.out.println("Inserido com sucesso oportunidade e curso_has_oportunidade");
			 
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
