package oportunidades.controller;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.OportunidadeDAO;
import oportunidades.model.Oportunidade;

@ManagedBean (name = "oportunidadeController")
public class OportunidadeController {		 

		private Oportunidade oportunidade = new Oportunidade();

		public Oportunidade getOportunidade() {
			return oportunidade;
		}
		
		public void setOportunidade(Oportunidade oportunidade){
			this.oportunidade = oportunidade;
		}
			
		
		public String insereOportunidade() throws Exception{
			OportunidadeDAO daoOportunidade = new OportunidadeDAO();
			daoOportunidade.insereOportunidade(oportunidade);
			return oportunidade.getNome();
			
		}
}
