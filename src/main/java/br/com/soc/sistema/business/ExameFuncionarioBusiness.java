package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.examesFuncionario.ExamesFuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameFuncionarioVo;

public class ExameFuncionarioBusiness {
	
	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private ExamesFuncionarioDao dao;
	
	public ExameFuncionarioBusiness() {
		this.dao = new ExamesFuncionarioDao();
	}
	
	
	public List<ExameFuncionarioVo> listarTodosExames(){
		return dao.todosExames();
	}
	
	
	public void inserirExameDosFuncionarios(ExameFuncionarioVo exameFuncionarioVo) {
		try {
		dao.inserirExameFuncionario(exameFuncionarioVo);
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel inserir o exame do funcionario");
		}
	}
	
	public void deletarExamesDoFuncionario(ExameFuncionarioVo exameFuncionarioVo) {
		dao.deleteExameFuncionario(exameFuncionarioVo);
	}
	
	public void deletarTodosExamesDoFuncionario (String rowid) {
		dao.deleteExamesFeitosPorFuncionario(rowid);
	}
	
	public void alterarExamesFeitoFuncionario (ExameFuncionarioVo atual, ExameFuncionarioVo novo) {
		dao.editarExameFuncionario(atual, novo);
	}
	
	
	
	public List<ExameFuncionarioVo> filtrarExamesFuncionario(String tFiltro, String vFiltro) {
		
		List<ExameFuncionarioVo> examesFuncionario = new ArrayList<ExameFuncionarioVo>();
		
			switch (tFiltro) {
			case "FuncionarioID": 
			
				try {
					examesFuncionario = dao.todosExamesPorIdFuncionario(vFiltro);
					return examesFuncionario;
				} catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			
				
			case "ExameID":
				try {
					examesFuncionario = dao.todosExamesPorIdExames(vFiltro);
					return examesFuncionario;
				} catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
				
			}
			return Collections.emptyList();		
	}
	
	
	public List<ExameFuncionarioVo> filtrarExamesPorPeriodo(String dInicial, String dFinal) {
		List<ExameFuncionarioVo> examesFuncionario = new ArrayList<ExameFuncionarioVo>();
		try {
			examesFuncionario.addAll(dao.todosExamesPorPeriodo(dInicial, dFinal));
			return examesFuncionario;
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel filtrar os exames realizados por periodo");
		}
	}

}
