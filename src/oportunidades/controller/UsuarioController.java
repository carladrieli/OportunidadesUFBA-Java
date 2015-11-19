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
		resetBean();
	}
	
	public String insereUsuarioProfessor() throws Exception {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		daoUsuario.insereUsuarioProfessor(usuario);
		return "painel_admin.xhtml?faces-redirect=true";
	}
	
	public String usuarioAutentica() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		daoUsuario.buscaUsuarioId(usuario);
		return "/painel_usuarios.xhtml";
	}
	
	public void resetBean() {
		usuario = new Usuario();
	}
	   
}
