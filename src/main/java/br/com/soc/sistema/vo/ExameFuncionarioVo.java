package br.com.soc.sistema.vo;

import java.util.Date;

public class ExameFuncionarioVo {
	
	private ExameVo exameVo;
	private FuncionarioVo funcionarioVo;
	private Date dataDoExame;
	
	public ExameFuncionarioVo() {}
		
	public ExameFuncionarioVo(ExameVo exameVo, FuncionarioVo funcionarioVo, Date dataDoExame) {
		this.exameVo = exameVo;
		this.funcionarioVo = funcionarioVo;
		this.dataDoExame = dataDoExame;
	}

	
	
	public ExameVo getExameVo() {
		return exameVo;
	}

	public void setExameVo(ExameVo exameVo) {
		this.exameVo = exameVo;
	}

	public FuncionarioVo getFuncionarioVo() {
		return funcionarioVo;
	}

	public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
		this.funcionarioVo = funcionarioVo;
	}

	public Date getDataDoExame() {
		return dataDoExame;
	}

	public void setDataDoExame(Date dataDoExame) {
		this.dataDoExame = dataDoExame;
	}

	@Override
	public String toString() {
		return "ExameFuncionarioVo [exameVo=" + exameVo + ", funcionarioVo=" + funcionarioVo + ", dataDoExame="
				+ dataDoExame + "]";
	}

	
}
