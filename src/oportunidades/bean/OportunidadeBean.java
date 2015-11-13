package oportunidades.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import oportunidades.dao.AreaDAO;
import oportunidades.dao.CursoDAO;
import oportunidades.dao.OportunidadeDAO;
import oportunidades.model.Area;
import oportunidades.model.Curso;
import oportunidades.model.Oportunidade;

@ManagedBean (name = "oportunidadeBean")
public class OportunidadeBean {
	
	private Oportunidade oportunidade = new Oportunidade();;
	private Curso curso = new Curso();;
	private Area area = new Area();;
	private List<Curso> listaCurso = null;
	private List<Area> listaArea = null;
	private int areaId;
	
	public Oportunidade getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

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

	public List<Area> getListaArea() {
		return listaArea;
	}

	public void setListaArea(List<Area> listaArea) {
		this.listaArea = listaArea;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public List<Area> buscaArea() throws Exception {
		System.out.println("BUSCA AREA!! ");
		AreaDAO daoArea = new AreaDAO();
		listaArea = daoArea.buscaArea();
		return listaArea;
	}
	
	public void listaCursos(final AjaxBehaviorEvent event) {
		CursoDAO daoCurso = new CursoDAO();
		System.out.println("Lista cursos OportunidadeBean+ !!!");
		System.out.println(areaId);
		listaCurso = daoCurso.buscaCursoArea(areaId);
	}
	
	public Oportunidade insereOportunidade() throws Exception{
		OportunidadeDAO daoOportunidade = new OportunidadeDAO();
		oportunidade = daoOportunidade.insereOportunidade(oportunidade);
		return oportunidade;
	}

}
