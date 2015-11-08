package oportunidades.model;

import java.io.Serializable;

public class Curso implements Serializable,SampleEntity{
	
	private Integer id;
	private String nome;
	private Area area;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
}
