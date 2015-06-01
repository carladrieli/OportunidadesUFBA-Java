package oportunidades.model;

public class Aluno extends Usuario {
	
	private Usuario usuario;
	private String semestre;
	private String matricula;
	private String previsao_conclusao;
	private Curso curso;
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getPrevisao_conclusao() {
		return previsao_conclusao;
	}
	public void setPrevisao_conclusao(String previsao_conclusao) {
		this.previsao_conclusao = previsao_conclusao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
