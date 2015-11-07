package oportunidades.model;

import java.util.List;

import javax.faces.bean.ManagedProperty;

public class Aluno extends Usuario {
	
	private Usuario usuario;
	private String semestre;
	private String matricula;
	private String previsaoConclusao;
	private Curso curso;
	private List<Contato> contato;
	
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
	public String getPrevisaoConclusao() {
		return previsaoConclusao;
	}
	public void setPrevisaoConclusao(String previsaoConclusao) {
		this.previsaoConclusao = previsaoConclusao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public List<Contato> getContato() {
		return contato;
	}
	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}
}
