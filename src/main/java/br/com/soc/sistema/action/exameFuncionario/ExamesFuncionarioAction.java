package br.com.soc.sistema.action.exameFuncionario;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.ExameFuncionarioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ExameFuncionarioVo;

public class ExamesFuncionarioAction extends Action{

	private static final long serialVersionUID = -1980797046352686060L;
	private List<ExameFuncionarioVo> exameFuncionarioList = new ArrayList<ExameFuncionarioVo>();
	private ExameFuncionarioVo exameFuncionarioVo = new ExameFuncionarioVo();
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private ExameFuncionarioVo novoExameFuncionarioVo = new ExameFuncionarioVo();
	private String tipoFiltro;
	private String valorFiltro;


	public String todos() {	
		exameFuncionarioList = business.listarTodosExames();	
		return SUCCESS;
	
	}
	
	public String novo() {
		return INPUT;
	}
	
	
	public String salvar() {
		business.inserirExameDosFuncionarios(exameFuncionarioVo);	
		return REDIRECT;
		
	}
	
	public String excluir() {		
		business.deletarExamesDoFuncionario(exameFuncionarioVo);
		return REDIRECT;
	}
	
	
	public String editar() {
		
		return UPDATE;
	}
	
	public String salvarEdicao () {
		
		business.alterarExamesFeitoFuncionario(exameFuncionarioVo, novoExameFuncionarioVo);
		
		return REDIRECT;
	}
	
	
	public String filtrar() {
		
		
		if (valorFiltro.isEmpty()) {
			return REDIRECT;
		}
		exameFuncionarioList = business.filtrarExamesFuncionario(tipoFiltro, valorFiltro);
		return SUCCESS;
	}
	
	
	
	
	public List<ExameFuncionarioVo> getExameFuncionarioList() {
		return exameFuncionarioList;
	}

	public void setExameFuncionarioList(List<ExameFuncionarioVo> exameFuncionarioList) {
		this.exameFuncionarioList = exameFuncionarioList;
	}


	public ExameFuncionarioVo getExameFuncionarioVo() {
		return exameFuncionarioVo;
	}


	public void setExameFuncionarioVo(ExameFuncionarioVo exameFuncionarioVo) {
		this.exameFuncionarioVo = exameFuncionarioVo;
	}


	public ExameFuncionarioBusiness getBusiness() {
		return business;
	}


	public void setBusiness(ExameFuncionarioBusiness business) {
		this.business = business;
	}

	public ExameFuncionarioVo getNovoExameFuncionarioVo() {
		return novoExameFuncionarioVo;
	}

	public void setNovoExameFuncionarioVo(ExameFuncionarioVo novoExameFuncionarioVo) {
		this.novoExameFuncionarioVo = novoExameFuncionarioVo;
	}

	public String getTipoFiltro() {
		return tipoFiltro;
	}

	public void setTipoFiltro(String tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	public String getValorFiltro() {
		return valorFiltro;
	}

	public void setValorFiltro(String valorFiltro) {
		this.valorFiltro = valorFiltro;
	}
	
}
