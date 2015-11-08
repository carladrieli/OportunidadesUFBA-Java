package oportunidades.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.CursoDAO;
import oportunidades.model.Curso;


@ManagedBean(name = "cursoController")
public class CursoController {

	private Curso curso = new Curso();
	private List<Curso> listaCurso = null;

	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso){
		this.curso = curso;
	}
	
	public String insereCurso() throws Exception{
		CursoDAO daoCurso = new CursoDAO();
		daoCurso.insereCurso(curso);
		return curso.getNome();
		
	}
	public List<Curso> buscaCurso() throws Exception {
		CursoDAO daoCurso = new CursoDAO();
		listaCurso = daoCurso.buscaCurso();
		return listaCurso;
	}

}
