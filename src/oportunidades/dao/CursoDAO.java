package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Curso> buscaCurso() {

		String sql = "SELECT id, nome, idArea FROM curso";

		Statement stmt = null;
		ResultSet rs = null;
		List<Curso> listaCurso = new ArrayList<Curso>();
			

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}
			
			Curso curso = null;
			stmt = connection.createStatement();
			System.out.println("Buscando cursos");
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();				
			while (rs.next()) {
							
				curso = new Curso();
				Integer id = (Integer) rs.getObject("id");				
				curso.setId(id);				
				String nome = rs.getString("nome");				
				curso.setNome(nome);
				
				
				listaCurso.add(curso);
				
			}
			stmt.close();			 

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao buscar cursos.");
			e.printStackTrace();
		}
		return listaCurso;
	}

	public List<Curso> buscaCursoPorArea(int idArea) {

		String sql = "SELECT id, nome FROM curso WHERE area_id = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Curso> listaCurso = new ArrayList<Curso>();
			

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}
			
			Curso curso = null;
			stmt = connection.prepareStatement(sql);
			System.out.println("Buscando cursos");
			stmt.setInt(1, idArea);
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();				
			while (rs.next()) {
							
				curso = new Curso();
				Integer id = (Integer) rs.getObject("id");				
				curso.setId(id);				
				String nome = rs.getString("nome");				
				curso.setNome(nome);
				
				
				listaCurso.add(curso);
				
			}
			stmt.close();			 

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao buscar cursos.");
			e.printStackTrace();
		}
		return listaCurso;
	}

	
	
	
	
}
