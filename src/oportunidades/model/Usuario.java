package oportunidades.model;


public class Usuario {
	
	private int id;
	private String nome;
	private String senha;
	private String email;
	private int tipo_id;
	private String descricaoPerfil;
	private Contato contato_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTipo() {
		return tipo_id;
	}
	public void setTipo(int tipo) {
		this.tipo_id = tipo;
	}
	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}
	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	public Contato getContato_id() {
		return contato_id;
	}
	public void setContato_id(Contato contato_id) {
		this.contato_id = contato_id;
	}
	

}
