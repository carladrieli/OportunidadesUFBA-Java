package oportunidades.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import oportunidades.model.TipoUsuario;

public class TipoUsuarioDAO {
	
	private Connection connection;

	public TipoUsuarioDAO() {

		try {
			connection = new ConexaoDAO().getConexao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção ao criar Conexao.");
			e.printStackTrace();
		}
	}

	public List<TipoUsuario> buscaTipoUsuario() {
		
		String sql = "SELECT id, descricao FROM tipoUsuario";	
		
		Statement stmt = null;
		ResultSet rs = null;
		List<TipoUsuario> listaTipoUsuario = new ArrayList<TipoUsuario>();

		try {
			TipoUsuario tipoUsuario = null;
			stmt = connection.createStatement();
			System.out.println("Buscando tipo de usuários");
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				tipoUsuario = new TipoUsuario();
				int idTipoUsuario = rs.getInt("id");
				System.out.println(idTipoUsuario);
				tipoUsuario.setId(idTipoUsuario);
				
				String descricaoTipoUsuario = rs.getString("descricao");
				System.out.println(descricaoTipoUsuario);
				tipoUsuario.setDescricao(descricaoTipoUsuario);
				
				listaTipoUsuario.add(tipoUsuario);
			}
			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceção ao buscar tipo de usuários.");
			e.printStackTrace();
		}
		return listaTipoUsuario;
	}

}
