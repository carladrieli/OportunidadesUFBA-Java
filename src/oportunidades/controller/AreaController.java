package oportunidades.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.AreaDAO;
import oportunidades.model.Area;


@ManagedBean(name = "areaController")
public class AreaController {

	private Area area = new Area();
	private List<Area> listaArea = null;

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Area> buscaArea() throws Exception {
		AreaDAO daoArea = new AreaDAO();
		listaArea = daoArea.buscaArea();
		return listaArea;
	}

}
