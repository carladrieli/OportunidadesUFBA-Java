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
	private int cursoId;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String insereCurso() throws Exception{
		System.out.println("chegando insereCurso!");
		CursoDAO daoCurso = new CursoDAO();
		System.out.println(cursoId);
		daoCurso.insereCurso(curso, cursoId);
		return "painel_admin.xhtml?faces-redirect=true";			
	}
	

	public List<Curso> buscaCurso() throws Exception {
		CursoDAO daoCurso = new CursoDAO();
		listaCurso = daoCurso.buscaCurso();
		return listaCurso;
	}

	
	public List<Curso> onAreaChange(Area area) {
		System.out.println("#####%$!@ opa onAreaChange!");
		
		List<Curso> listaCurso = new ArrayList<Curso>();

		if (area != null && !area.equals("")) {
			CursoDAO daoCurso = new CursoDAO();
			listaCurso = daoCurso.buscaCursoPorArea(area.getId());
			return listaCurso;
		} else
			return new ArrayList<Curso>();		
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

}
