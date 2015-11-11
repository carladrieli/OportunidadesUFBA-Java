package oportunidades.controller;


import javax.faces.bean.ManagedBean;
import oportunidades.dao.UsuarioDAO;
import oportunidades.model.Usuario;


@ManagedBean (name = "usuarioController")
public class UsuarioController {
	
	private Usuario usuario = new Usuario();
	

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}	
	
	
	public void insereUsuario() throws Exception {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		daoUsuario.insereUsuario(usuario);		
	}
	
	public String usuarioAutentica() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		daoUsuario.buscaUsuarioId(usuario);
		return "/painel.xhtml";
	}
	   
}
