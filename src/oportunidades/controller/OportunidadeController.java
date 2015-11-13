package oportunidades.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import oportunidades.dao.CursoDAO;
import oportunidades.dao.OportunidadeDAO;
import oportunidades.model.Area;
import oportunidades.model.Curso;
import oportunidades.model.Oportunidade;

@ManagedBean (name = "oportunidadeController")
public class OportunidadeController {		 

		private Oportunidade oportunidade = new Oportunidade();
		private Curso curso = new Curso();
		private Area area = new Area();
		private List<Oportunidade> listaOportunidade = null;
		private List<Curso> listaCurso = null;
		private int areaId;

		
		public Oportunidade getOportunidade() {
			return oportunidade;
		}
		
		public void setOportunidade(Oportunidade oportunidade){
			this.oportunidade = oportunidade;
		}
			
		
		public Oportunidade insereOportunidade() throws Exception{
			OportunidadeDAO daoOportunidade = new OportunidadeDAO();
			oportunidade = daoOportunidade.insereOportunidade(oportunidade);
			return oportunidade;
			
		}
		
		public List<Oportunidade> buscaOportunidade() throws Exception{
			OportunidadeDAO daoOportunidade = new OportunidadeDAO();
			listaOportunidade = daoOportunidade.listaOportunidade();
			return listaOportunidade;
		}
		
		public List<Curso> buscaCurso() throws Exception {
			CursoDAO daoCurso = new CursoDAO();
			listaCurso = daoCurso.buscaCurso();
			return listaCurso;
		}
		
		public List<Curso> buscaCursoArea() throws Exception {
			CursoDAO daoCurso = new CursoDAO();
			System.out.println(areaId);
			listaCurso = daoCurso.buscaCursoArea(areaId);
			return listaCurso;
		}
		
		public void listaCursos(AjaxBehaviorEvent event) {
			CursoDAO daoCurso = new CursoDAO();
			System.out.println("Listacurso Oportunidade !!!");
			listaCurso = daoCurso.buscaCursoArea(areaId);
		}

		public int getAreaId() {
			return areaId;
		}

		public void setAreaId(int areaId) {
			this.areaId = areaId;
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

		public Area getArea() {
			return area;
		}

		public void setArea(Area area) {
			this.area = area;
		}

		public List<Oportunidade> getListaOportunidade() {
			return listaOportunidade;
		}

		public void setListaOportunidade(List<Oportunidade> listaOportunidade) {
			this.listaOportunidade = listaOportunidade;
		}
		
		
}
