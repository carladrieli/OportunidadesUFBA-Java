package oportunidades.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

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
	private List<Oportunidade> listaOportunidade = null;
	private String[] listaCursoSelecionados;
	private int areaId;

	public OportunidadeBean () {

	}
	 

	public List<Oportunidade> getListaOportunidade() {
		System.out.println("Getting Lista Oporutnidade");
		if (listaOportunidade == null){
			OportunidadeDAO daoOportunidade = new OportunidadeDAO();
			this.listaOportunidade = daoOportunidade.listaOportunidade();
			System.out.println(listaOportunidade);
		}
		return listaOportunidade;
	}


	public void setListaOportunidade(List<Oportunidade> listaOportunidade) {
		System.out.println("Setting ListandoOportunidades !");
		this.listaOportunidade = listaOportunidade;
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
		OportunidadeDAO daoOportunidade = new OportunidadeDAO();
		oportunidade = daoOportunidade.insereOportunidade(oportunidade, listaCursoSelecionados);
		resetBean();
		return "painel_admin.xhtml?faces-redirect=true";
	}
	
	public List<Oportunidade> listaOportunidade() {
		System.out.println("ListandoOportunidades !");
		return getListaOportunidade();
	}
	
	public void resetBean() {
		oportunidade = new Oportunidade();
		curso = new Curso();
		area = new Area();
		listaCurso = null;
		listaArea = null;
		listaCursoSelecionados = null;
		areaId = 0;
	}

}