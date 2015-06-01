package oportunidades.controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

import oportunidades.dao.TipoUsuarioDAO;
import oportunidades.model.TipoUsuario;;

@ManagedBean(name = "tuc")
public class TipoUsuarioController {
	
	private TipoUsuario tipoUsuario = new TipoUsuario();

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public ArrayList<TipoUsuario> buscaTipoUsuario() throws Exception {
		TipoUsuarioDAO daoTipoUsuario = new TipoUsuarioDAO();
		return daoTipoUsuario.buscaTipoUsuario();
	}
}
