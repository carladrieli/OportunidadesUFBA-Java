package oportunidades.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import oportunidades.dao.AreaDAO;
import oportunidades.dao.CursoDAO;
import oportunidades.dao.OportunidadeDAO;
import oportunidades.model.Area;
import oportunidades.model.Curso;
import oportunidades.model.Oportunidade;

@ManagedBean (name = "oportunidadeBean")
@SessionScoped
public class OportunidadeBean {
	
	private Oportunidade oportunidade = new Oportunidade();
	private Curso curso = new Curso();
	private Area area = new Area();
	private List<Curso> listaCurso = null;
	private List<Area> listaArea = null;
	private String[] listaCursoSelecionados;
	private int areaId;

	public OportunidadeBean () {

	}

	public String[] getListaCursoSelecionados() {
		return listaCursoSelecionados;
	}

	public void setListaCursoSelecionados(String[] listaCursoSelecionados) {
		this.listaCursoSelecionados = listaCursoSelecionados;
	}

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
		if (listaCurso == null){
			listaCurso = new ArrayList<Curso>();
		}
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
		listaCurso = daoCurso.buscaCursoArea(areaId);
	}
	
	
	public String insereOportunidade() {
		System.out.println("InsereOportunidade BeaN			!");
		int a = listaCursoSelecionados.length;
		System.out.println("Quantidad de cursos: " + a);
		OportunidadeDAO daoOportunidade = new OportunidadeDAO();
		oportunidade = daoOportunidade.insereOportunidade(oportunidade, listaCursoSelecionados);
		return "painel_admin.xhtml?faces-redirect=true";
		
	}

}