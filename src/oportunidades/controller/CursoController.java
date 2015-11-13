package oportunidades.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import oportunidades.dao.CursoDAO;
import oportunidades.model.Area;
import oportunidades.model.Curso;

@ManagedBean(name = "cursoController")
public class CursoController {

	private Curso curso = new Curso();
	private Area area = new Area();
	private List<Curso> listaCurso = null;
	private int cursoId;
	private int areaId; 

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

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
		return "index.xhtml";			
	}
	

	public List<Curso> buscaCurso() throws Exception {
		CursoDAO daoCurso = new CursoDAO();
		listaCurso = daoCurso.buscaCurso();
		return listaCurso;
	}
	
	public List<Curso> buscaCursoArea() throws Exception {
		CursoDAO daoCurso = new CursoDAO();
		System.out.println(areaId);
		listaCurso = daoCurso.buscaCursoArea(area.getId());
		return listaCurso;
	}

	public void listaCursos(AjaxBehaviorEvent event) {
		CursoDAO daoCurso = new CursoDAO();
		System.out.println();
		listaCurso = daoCurso.buscaCursoArea(curso.getArea().getId());
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

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

}
