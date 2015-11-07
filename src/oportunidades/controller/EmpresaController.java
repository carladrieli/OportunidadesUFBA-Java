package oportunidades.controller;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.EmpresaDAO;
import oportunidades.model.Empresa;

@ManagedBean(name = "empresaController")
public class EmpresaController {

	private Empresa empresa = new Empresa();

	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa){
		this.empresa = empresa;
	}
	
	public String insereEmpresa() throws Exception{
		EmpresaDAO daoEmpresa = new EmpresaDAO();
		daoEmpresa.insereEmpresa(empresa);
		return empresa.getEndereco();
	}

}
