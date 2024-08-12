package br.com.soc.sistema.action.funcionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarFuncionarios;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioAction extends Action {
	private static final long serialVersionUID = 5621789179455899871L;
	private List<FuncionarioVo> funcionarios = new ArrayList<>();
	private FuncionarioBusiness business = new FuncionarioBusiness();
	private FuncionarioFilter filtrar = new FuncionarioFilter();
	private FuncionarioVo funcionarioVo = new FuncionarioVo();


	public String todos() {
		funcionarios.addAll(business.trazerTodosOsFuncionarios());	

		return SUCCESS;
	}
	
	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;
		
		funcionarios = business.filtrarFuncionarios(filtrar);
		
		return SUCCESS;
	}
	
	public String novo() {
	    if(funcionarioVo.getNome() == null) {
	        return INPUT;
	    }
	    
	    try {
	        business.salvarFuncionario(funcionarioVo);
	        System.out.println("Funcionario salvo com sucesso: " + funcionarioVo);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ERROR;
	    }
	    
	    return REDIRECT;
	}
	
	public String editar() {
		if(funcionarioVo.getRowid() == null)
			return REDIRECT;
		
		funcionarioVo = business.buscarFuncionarioPor(funcionarioVo.getRowid());
		
		return UPDATE;
	}
	
	public String alterar() {
		if(funcionarioVo.getNome() == null) {
			return UPDATE;
		}
		
		business.alterarFuncionario(funcionarioVo);
		return REDIRECT;
	}
	
	
	public String deletar() {
        if(funcionarioVo.getRowid() == null) {
            return REDIRECT;
        }
        System.out.println("Deletando o funcionario com rowid: " + funcionarioVo.getRowid());
        try {
            business.deletarFuncionario(funcionarioVo);
        } catch (BusinessException e) {
            addActionError(e.getMessage());
            return ERROR;
        }
        
        return REDIRECT;
    }
	
	
	public List<OpcoesComboBuscarFuncionarios> getListaOpcoesCombo(){
		return Arrays.asList(OpcoesComboBuscarFuncionarios.values());
	}
	
	public List<FuncionarioVo> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVo> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public FuncionarioFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(FuncionarioFilter filtrar) {
		this.filtrar = filtrar;
	}

	public FuncionarioVo getFuncionarioVo() {
		return funcionarioVo;
	}

	public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
		this.funcionarioVo = funcionarioVo;
	}
	
}
