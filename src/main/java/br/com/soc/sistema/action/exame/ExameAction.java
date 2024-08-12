package br.com.soc.sistema.action.exame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarExames;
import br.com.soc.sistema.vo.ExameVo;

public class ExameAction extends Action {
	
	private static final long serialVersionUID = 2584225640687140130L;
	private List<ExameVo> exames = new ArrayList<>();
	private ExameBusiness business = new ExameBusiness();
	private ExameFilter filtrar = new ExameFilter();
	private ExameVo exameVo = new ExameVo();
	
	public String todos() {
		exames.addAll(business.trazerTodosOsExames());	

		return SUCCESS;
	}
	
	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;
		
		exames = business.filtrarExames(filtrar);
		
		return SUCCESS;
	}
	
	public String novo() {
	    if(exameVo.getNome() == null) {
	        return INPUT;
	    }
	    
	    try {
	        business.salvarExame(exameVo);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
	    
	    return REDIRECT;
	}
	
	public String editar() {
		if(exameVo.getRowid() == null)
			return REDIRECT;
		
		exameVo = business.buscarExamePor(exameVo.getRowid());
		
		return UPDATE;
	}
	
	public String alterar() {
	    if (exameVo.getNome() == null) {
	        addActionError("Nome do exame não pode ser nulo");
	        return UPDATE;
	    }
	    try {
	        business.alterarExame(exameVo);
	        addActionMessage("Exame atualizado com sucesso");
	    } catch (BusinessException e) {
	        addActionError(e.getMessage());
	        
	    }
	    return REDIRECT;
	}
	
	
	public String deletar() {
        if(exameVo.getRowid() == null) {
            return REDIRECT;
        }
        try {
            business.deletarExame(exameVo);
        } catch (BusinessException e) {
            addActionError(e.getMessage());
          
        }
        
        return REDIRECT;
    }
	
	
	public List<OpcoesComboBuscarExames> getListaOpcoesCombo(){
		return Arrays.asList(OpcoesComboBuscarExames.values());
	}
	
	public List<ExameVo> getExames() {
		return exames;
	}

	public void setExames(List<ExameVo> exames) {
		this.exames = exames;
	}

	public ExameFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(ExameFilter filtrar) {
		this.filtrar = filtrar;
	}

	public ExameVo getExameVo() {
		return exameVo;
	}

	public void setExameVo(ExameVo exameVo) {
		this.exameVo = exameVo;
	}
}
