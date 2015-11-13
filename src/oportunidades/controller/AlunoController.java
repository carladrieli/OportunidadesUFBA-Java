package oportunidades.controller;

import javax.faces.bean.ManagedBean;

import oportunidades.dao.AlunoDAO;
import oportunidades.model.Aluno;

@ManagedBean(name = "alunoController")
public class AlunoController {

	private Aluno aluno = new Aluno();
	private int cursoId;

	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}
	
	public String insereAluno() throws Exception{
		System.out.println("Inser aqui Aluno!!!");
		AlunoDAO daoAluno = new AlunoDAO();
		daoAluno.insereAluno(aluno, cursoId);
		return "painel_admin.xhtml";
		
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

}
