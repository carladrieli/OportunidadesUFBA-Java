package oportunidades.model;

public class Empresa {
	
	private Usuario usuario;
	private Usuario empresa;
	private String endereco;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Usuario getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Usuario empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
