package oportunidades.bean;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.AreaDAO;
import oportunidades.model.Area;

@ManagedBean (name = "areaBean")
public class AreaBean {

	private Area area = new Area();

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String insereArea() {
		System.out.println("inserindo area BEAN");
		AreaDAO areaDao = new AreaDAO();
		areaDao.insereArea(area);
		resetArea();
		return "painel_admin.xhtml?faces-redirect=true";
	}
	
	public void resetArea() {
		area = new Area();
	}
}
