package oportunidades.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import oportunidades.model.Area;

public class AreaDAO {

	private Connection connection;

	public AreaDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excecao ao criar Conexao.");
			e.printStackTrace();
		}
	}

	public List<Area> buscaArea() {

		String sql = "SELECT id, nome, descricao FROM area";

		Statement stmt = null;
		ResultSet rs = null;
		List<Area> listaArea = new ArrayList<Area>();
		
		System.out.println("BuscaArea!");
		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}

				Area area = null;
				stmt = connection.createStatement();
				System.out.println("Buscando �reas");
				rs = stmt.executeQuery(sql);
				rs.beforeFirst();
				while (rs.next()) {

					area = new Area();
					Integer idArea = (Integer) rs.getObject("id");
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
			System.out.println("Exce��o ao buscar �reas.");
			e.printStackTrace();
		}
		return listaArea;
	}
}
