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
			System.out.println("Exce��o ao criar Conexao.");
			e.printStackTrace();
		}

	}

	public void insereCurso(Curso curso, int cursoId) {

		String sql = "INSERT INTO curso"
				+ "(nome, area_id)" + " values (?,?)";

		PreparedStatement stmt = null;
		System.out.println("inserindo!");
		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

			stmt = connection.prepareStatement(sql);
			System.out.println("Inserindo curso");
			stmt.setString(1, curso.getNome());
			System.out.println(cursoId);
			stmt.setInt(2, cursoId);
			stmt.execute();

			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exce��o ao inserir Curso.");
			e.printStackTrace();
		}

	}

	public List<Curso> buscaCurso() {

		String sql = "SELECT id, nome, area_id FROM curso";

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
			System.out.println("Exce��o ao buscar cursos.");
			e.printStackTrace();
		}
		return listaCurso;
	}
	
	public List<Curso> buscaListaCursoHasOportunidade(int oportunidade_id) {

		String sql = "SELECT curso_id FROM curso_has_oportunidade WHERE oportunidade_id = " + oportunidade_id +";";

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
			System.out.println("Buscando curso_has_oportunidade");
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();				
			while (rs.next()) {
							
				curso = new Curso();
				Integer id = (Integer) rs.getObject("curso_id");				
				
				//curso.setId(id);
				
				String sql1 = "SELECT nome FROM curso WHERE id = " + id +";";
				Statement stmt1 = null;
				ResultSet rs1 = null;
				stmt1 = connection.createStatement();
				
				System.out.println("Buscando curso id");
				rs1 = stmt1.executeQuery(sql1);
				rs1.beforeFirst();	
				
				while (rs1.next()) {
					System.out.println("Buscando curso nome####");
					String nome = rs1.getString("nome");
					System.out.println(nome);
					curso.setNome(nome);
				}
				
				stmt1.close();
				System.out.println("Adicionando Lista cursos nome");
				listaCurso.add(curso);
			}
			
			stmt.close();			 
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exce��o ao buscar cursos has oportunidade.");
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
			System.out.println("Exce��o ao buscar cursos.");
			e.printStackTrace();
		}
		return listaCurso;
	}
	
public List<Curso> buscaCursoArea(int area_id) {
		
		String sql = "SELECT id, nome FROM curso WHERE area_id = " + area_id;

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
			System.out.println("Buscando cursos pela Area");
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
			System.out.println("Exce��o ao buscar cursos.");
			e.printStackTrace();
		}
		return listaCurso;
	}

	
	
	
	
}
