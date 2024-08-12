package br.com.soc.sistema.dao.examesFuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ExameFuncionarioVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class ExamesFuncionarioDao extends Dao {
	
	public List<ExameFuncionarioVo> todosExames(){
		List<ExameFuncionarioVo> listaDeExames = new ArrayList<ExameFuncionarioVo>();
		
		String sql = "SELECT id_funcionario, id_exame, dataExame FROM exameFuncionario";

		try (Connection conn = getConexao();PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			
			while (rs.next()) {
				ExameFuncionarioVo exameFuncionarioVo = new ExameFuncionarioVo();
				FuncionarioVo funcionarioVo = new FuncionarioVo();
				ExameVo exameVo = new ExameVo();
				
				funcionarioVo.setRowid(rs.getString("id_funcionario"));
				exameVo.setRowid(rs.getString("id_exame"));
				exameFuncionarioVo.setDataDoExame(rs.getDate("dataExame"));
				exameFuncionarioVo.setFuncionarioVo(funcionarioVo);
				exameFuncionarioVo.setExameVo(exameVo);
				
				listaDeExames.add(exameFuncionarioVo);
			}
							
		    } catch (SQLException e) {
					e.printStackTrace();
				}
				
		return listaDeExames;
	}
	
	public void inserirExameFuncionario (ExameFuncionarioVo exameFuncionarioVo) {
		
		String sql = "INSERT INTO exameFuncionario (id_funcionario, id_exame, dataExame) values (?, ?, ?)";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try (Connection conn = getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, exameFuncionarioVo.getFuncionarioVo().getRowid());
			ps.setString(2, exameFuncionarioVo.getExameVo().getRowid());
			ps.setString(3, formatter.format(exameFuncionarioVo.getDataDoExame()));
			
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteExameFuncionario (ExameFuncionarioVo exameFuncionarioVo) {
		
		String sql = "DELETE FROM exameFuncionario WHERE id_funcionario = ? AND id_exame = ? AND dataExame = ?";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try (Connection conn = getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, exameFuncionarioVo.getFuncionarioVo().getRowid());
			ps.setString(2, exameFuncionarioVo.getExameVo().getRowid());
			ps.setString(3, sdf.format(exameFuncionarioVo.getDataDoExame()));
			
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteExamesFeitosPorFuncionario (String id_funcionario) {
		
		String sql = "DELETE FROM exameFuncionario WHERE id_funcionario = ?";
		
		try (Connection conn = getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, id_funcionario);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarExameFuncionario (ExameFuncionarioVo atual, ExameFuncionarioVo novo) {
		
		String sql = "UPDATE exameFuncionario SET  id_exame = ?, id_funcionario = ?, dataExame = ? "
				+ "WHERE  id_exame = ? AND id_funcionario = ? AND dataExame = ?";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try (Connection conn = getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, novo.getExameVo().getRowid());
			ps.setString(2, novo.getFuncionarioVo().getRowid());
			ps.setString(3, sdf.format(novo.getDataDoExame()));

			ps.setString(4, atual.getExameVo().getRowid());
			ps.setString(5, atual.getFuncionarioVo().getRowid());
			ps.setString(6, sdf.format(atual.getDataDoExame()));
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<ExameFuncionarioVo> todosExamesPorIdFuncionario(String rowid) {
		
		List<ExameFuncionarioVo> examesFuncionario = new ArrayList<ExameFuncionarioVo>();
		
		String sql = "SELECT id_funcionario, id_exame, dataExame from exameFuncionario WHERE id_funcionario = ?";
		
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, rowid);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ExameFuncionarioVo exameFuncionarioVo = new ExameFuncionarioVo();
					FuncionarioVo funcionarioVo = new FuncionarioVo();
					ExameVo exameVo = new ExameVo();
					
					funcionarioVo.setRowid(rs.getString("id_funcionario"));
					exameVo.setRowid(rs.getString("id_exame"));
					exameFuncionarioVo.setDataDoExame(rs.getDate("dataExame"));
					
					exameFuncionarioVo.setFuncionarioVo(funcionarioVo);
					exameFuncionarioVo.setExameVo(exameVo);
					examesFuncionario.add(exameFuncionarioVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesFuncionario;
	}
	
	public List<ExameFuncionarioVo> todosExamesPorIdExames(String rowid) {
		
		List<ExameFuncionarioVo> examesFuncionario = new ArrayList<ExameFuncionarioVo>();
		
		String query = "SELECT id_funcionario, id_exame, dataExame from exameFuncionario WHERE id_exame = ?";
		
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, rowid);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ExameFuncionarioVo exameFuncionarioVo = new ExameFuncionarioVo();
					FuncionarioVo funcionarioVo = new FuncionarioVo();
					ExameVo exameVo = new ExameVo();
					
					funcionarioVo.setRowid(rs.getString("id_funcionario"));
					exameVo.setRowid(rs.getString("id_exame"));
					exameFuncionarioVo.setDataDoExame(rs.getDate("dataExame"));
					exameFuncionarioVo.setFuncionarioVo(funcionarioVo);
					exameFuncionarioVo.setExameVo(exameVo);
					examesFuncionario.add(exameFuncionarioVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesFuncionario;
	}
	
	
	
	public List<ExameFuncionarioVo> todosExamesPorPeriodo (String dataInicial, String dataFinal) {
		
		List<ExameFuncionarioVo> examesFuncionario = new ArrayList<ExameFuncionarioVo>();
		
	    String query = "SELECT f.rowid AS id_funcionario, f.nm_funcionario, e.rowid AS id_exame, e.nm_exame, ef.dataExame " +
                "FROM exameFuncionario ef " +
                "JOIN funcionario f ON ef.id_funcionario = f.rowid " +
                "JOIN exame e ON ef.id_exame = e.rowid " +
                "WHERE ef.dataExame BETWEEN ? AND ?";
	    
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, dataInicial);
			ps.setString(2, dataFinal);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ExameFuncionarioVo exameFuncionarioVo = new ExameFuncionarioVo();
	                exameFuncionarioVo.setFuncionarioVo(new FuncionarioVo(rs.getString("id_funcionario"), rs.getString("nm_funcionario")));
	                exameFuncionarioVo.setExameVo(new ExameVo(rs.getString("id_exame"), rs.getString("nm_exame")));
	                exameFuncionarioVo.setDataDoExame(rs.getDate("dataExame"));
	                examesFuncionario.add(exameFuncionarioVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesFuncionario;
	}

	
}
