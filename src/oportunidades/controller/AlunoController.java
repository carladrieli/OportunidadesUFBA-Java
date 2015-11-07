package oportunidades.controller;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.AlunoDAO;
import oportunidades.model.Aluno;

@ManagedBean(name = "alunoController")
public class AlunoController {

	private Aluno aluno = new Aluno();

	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}
	
	public String insereAluno() throws Exception{
		AlunoDAO daoAluno = new AlunoDAO();
		daoAluno.insereAluno(aluno);
		return aluno.getNome();
		
	}

}
