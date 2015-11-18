package oportunidades.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import oportunidades.dao.OportunidadeDAO;
import oportunidades.model.Oportunidade;

@ManagedBean (name = "oportunidadeController")
public class OportunidadeController {		 

		private Oportunidade oportunidade = new Oportunidade();
		private List<Oportunidade> listaOportunidade = null;

		public Oportunidade getOportunidade() {
			return oportunidade;
		}
		
		public void setOportunidade(Oportunidade oportunidade){
			this.oportunidade = oportunidade;
		}
		
		public List<Oportunidade> buscaOportunidade() throws Exception{
			OportunidadeDAO daoOportunidade = new OportunidadeDAO();
			listaOportunidade = daoOportunidade.listaOportunidade();
			return listaOportunidade;
		}
}
