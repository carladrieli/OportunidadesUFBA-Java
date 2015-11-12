package oportunidades.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.CursoDAO;
import oportunidades.model.Area;
import oportunidades.model.Curso;

@ManagedBean(name = "cursoController")
public class CursoController {

	private Curso curso = new Curso();
	private List<Curso> listaCurso = null;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String insereCurso() throws Exception {
		CursoDAO daoCurso = new CursoDAO();
		daoCurso.insereCurso(curso);
		return curso.getNome();

	}

	public List<Curso> buscaCurso() throws Exception {
		CursoDAO daoCurso = new CursoDAO();
		listaCurso = daoCurso.buscaCurso();
		return listaCurso;
	}

	
	public List<Curso> onAreaChange(Area area) {
		
		List<Curso> listaCurso = new ArrayList<Curso>();

		if (area != null && !area.equals("")) {
			CursoDAO daoCurso = new CursoDAO();
			listaCurso = daoCurso.buscaCursoPorArea(area.getId());
			return listaCurso;
		} else
			return new ArrayList<Curso>();		
	}

}
