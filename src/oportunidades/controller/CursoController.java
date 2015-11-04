package oportunidades.controller;

import javax.faces.bean.ManagedBean;
import oportunidades.dao.CursoDAO;
import oportunidades.model.Curso;


@ManagedBean(name = "cursoController")
public class CursoController {

	private Curso curso = new Curso();

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

}
