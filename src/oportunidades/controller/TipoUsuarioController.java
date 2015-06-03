package oportunidades.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.TipoUsuarioDAO;
import oportunidades.model.TipoUsuario;


@ManagedBean(name = "tuc")
public class TipoUsuarioController {
	
	private TipoUsuario tipoUsuario = new TipoUsuario();
	private List<TipoUsuario> listaTipoUsuario = null;

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String novoTipoUsuario(){
		this.tipoUsuario = new TipoUsuario();
		return "/cadastro-rapido.xhtml";
	}

	public List<TipoUsuario> buscaTipoUsuario() throws Exception {
		TipoUsuarioDAO daoTipoUsuario = new TipoUsuarioDAO();
		listaTipoUsuario = daoTipoUsuario.buscaTipoUsuario();
		return listaTipoUsuario;
	}
}
