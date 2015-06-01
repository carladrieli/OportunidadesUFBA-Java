package oportunidades.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.AreaDAO;
import oportunidades.model.Area;

@ManagedBean(name = "areaController")
public class AreaController {

	private Area area = new Area();

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public ArrayList<Area> buscaArea() throws Exception {
		AreaDAO daoArea = new AreaDAO();
		return daoArea.buscaArea();
	}

}
