package oportunidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public ArrayList<TipoUsuario> buscaTipoUsuario() {

		String sql = "SELECT id, descricao FROM tipoUsuario";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoUsuario> listaTipoUsuario = new ArrayList<TipoUsuario>();

		try {
			if (connection == null) {
				System.out.println("conexao null");
				this.connection = new ConexaoDAO().getConexao();
			}
			TipoUsuario tipoUsuario = new TipoUsuario();
			stmt = connection.prepareStatement(sql);
			System.out.println("Buscando tipo de usuários");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int idTipoUsuario = rs.getInt(1);
				tipoUsuario.setId(idTipoUsuario);
				String descricaoTipoUsuario = rs.getString(2);
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
