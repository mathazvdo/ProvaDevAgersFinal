package br.com.soc.sistema.dao.exames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameVo;

public class ExameDao extends Dao {

    public void insertExame(ExameVo exameVo) {
        String query = "INSERT INTO exame (nm_exame) values (?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, exameVo.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException("Erro ao inserir o exame", e);
        }
    }

    public List<ExameVo> findAllExames() {
        String query = "SELECT rowid id, nm_exame nome FROM exame";
        List<ExameVo> exames = new ArrayList<>();
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ExameVo vo = new ExameVo();
                vo.setRowid(rs.getString("id"));
                vo.setNome(rs.getString("nome"));
                exames.add(vo);
            }
        } catch (SQLException e) {
            throw new BusinessException("Erro ao buscar todos os exames", e);
        }
        return exames.isEmpty() ? Collections.emptyList() : exames;
    }

    public List<ExameVo> findAllByNome(String nome) {
        String query = "SELECT rowid id, nm_exame nome FROM exame WHERE lower(nm_exame) like lower(?)";
        List<ExameVo> exames = new ArrayList<>();
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, "%" + nome + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ExameVo vo = new ExameVo();
                    vo.setRowid(rs.getString("id"));
                    vo.setNome(rs.getString("nome"));
                    exames.add(vo);
                }
            }
        } catch (SQLException e) {
            throw new BusinessException("Erro ao buscar exames por nome", e);
        }
        return exames.isEmpty() ? Collections.emptyList() : exames;
    }

    public ExameVo findByCodigo(Integer codigo) {
        String query = "SELECT rowid id, nm_exame nome FROM exame WHERE rowid = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ExameVo vo = new ExameVo();
                    vo.setRowid(rs.getString("id"));
                    vo.setNome(rs.getString("nome"));
                    return vo;
                }
            }
        } catch (SQLException e) {
            throw new BusinessException("Erro ao buscar exame por código", e);
        }
        return null;
    }

    public void updateExame(ExameVo exameVo) {
        String query = "UPDATE exame SET nm_exame = ? WHERE rowid = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, exameVo.getNome());
            ps.setString(2, exameVo.getRowid());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException("Não foi possível realizar a atualização do registro", e);
        }
    }

    public void deleteByCodigo(Integer codigo) {
        String query = "DELETE FROM exame WHERE rowid = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException("Erro ao deletar o exame", e);
        }
    }
}
