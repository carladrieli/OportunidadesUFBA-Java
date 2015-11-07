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
	
	public String novoUsuario(){
		this.usuario = new Usuario();
		return "/cadastro-rapido.xhtml";
	}
	
	public String insereUsuario() throws Exception{
		UsuarioDAO daoUsuario = new UsuarioDAO();
		daoUsuario.insereUsuario(usuario);
		return usuario.getNome();
		
	}
	
	public String insereUsuarioProfessor() throws Exception{
		UsuarioDAO daoUsuario = new UsuarioDAO();
		daoUsuario.insereUsuarioProfessor(usuario);
		return usuario.getNome();
		
	}

}
