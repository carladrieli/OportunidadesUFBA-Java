package oportunidades.model;

import java.io.Serializable;

public class Area implements Serializable,SampleEntity {
	
	private Integer id;
	private String nome;
	private String descricao;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public boolean equals(Object o){
	   return(o instanceof Area && ((Area)o).getId().equals(this.getId()));
	}
}
