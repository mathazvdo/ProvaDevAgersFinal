package br.com.soc.sistema.action.relatorio;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.ExameFuncionarioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.relatorio.ExamesFuncionarioRelatorio;
import br.com.soc.sistema.vo.ExameFuncionarioVo;

public class RelatorioAction extends Action {
	private static final long serialVersionUID = 8267960507778853942L;
	private List<ExameFuncionarioVo> examesFuncionarios = new ArrayList<ExameFuncionarioVo>();
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private ExamesFuncionarioRelatorio relatorio = new ExamesFuncionarioRelatorio();
	private String dInicial;
	private String dFinal;
	

	public String listar () {
		
		return SUCCESS;
	}
	
	public String filtrar () {
		examesFuncionarios = business.filtrarExamesPorPeriodo(dInicial, dFinal);
		relatorio.gerarRelatorioExames(examesFuncionarios);
		return SUCCESS;
		
	}


	public List<ExameFuncionarioVo> getExamesFuncionarios() {
		return examesFuncionarios;
	}

	public void setExamesFuncionarios(List<ExameFuncionarioVo> examesFuncionarios) {
		this.examesFuncionarios = examesFuncionarios;
	}

	public ExameFuncionarioBusiness getBusiness() {
		return business;
	}

	public void setBusiness(ExameFuncionarioBusiness business) {
		this.business = business;
	}

	public ExamesFuncionarioRelatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(ExamesFuncionarioRelatorio relatorio) {
		this.relatorio = relatorio;
	}

	public String getdInicial() {
		return dInicial;
	}

	public void setdInicial(String dInicial) {
		this.dInicial = dInicial;
	}

	public String getdFinal() {
		return dFinal;
	}

	public void setdFinal(String dFinal) {
		this.dFinal = dFinal;
	}

}
