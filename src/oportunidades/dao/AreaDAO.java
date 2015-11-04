package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oportunidades.model.Area;


public class AreaDAO {

	private Connection connection;

	public AreaDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção ao criar Conexao.");
			e.printStackTrace();
		}
	}

	public ArrayList<Area> buscaArea() {

		String sql = "SELECT id, nome, descricao FROM area";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Area> listaArea = new ArrayList<Area>();

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}
			Area area = new Area();
			stmt = connection.prepareStatement(sql);
			System.out.println("Buscando áreas");
			rs = stmt.executeQuery();
			while (rs.next()) {
				/*int idArea = rs.getInt(1);
				area.setId(idArea);
				String nomeArea = rs.getString(2);
				area.setNome(nomeArea);
				String descricaoArea = rs.getString(3);
				area.setDescricao(descricaoArea);
				listaArea.add(area);*/
				
				
				area = new Area();
				int idArea = rs.getInt("id");
				System.out.println(idArea);
				area.setId(idArea);
				
				String nomeArea = rs.getString("nome");
				System.out.println(nomeArea);
				area.setNome(nomeArea);
				
				listaArea.add(area);
				
			}
			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao buscar áreas.");
			e.printStackTrace();
		}
		return listaArea;
	}
}
