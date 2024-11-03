package br.com.fiap.dao;

import br.com.fiap.to.OrcamentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrcamentoDAO extends Repository {

    public ArrayList<OrcamentoTO> findAll() {
        ArrayList<OrcamentoTO> orcamentos = new ArrayList<OrcamentoTO>();
        String sql = "SELECT * FROM T_SLC_ORCAMENTO ORDER BY ID_ORCAMENTO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    OrcamentoTO orcamento = new OrcamentoTO();
                    orcamento.setIdOrcamento(rs.getLong("ID_ORCAMENTO"));
                    orcamento.setData(rs.getDate("DT_CRIACAO").toLocalDate());
                    orcamento.setMaoDeObra(rs.getDouble("VL_MAO_OBRA"));
                    orcamento.setIdOficina(rs.getLong("ID_OFICINA"));
                    orcamento.setIdScanner(rs.getLong("ID_SCANNER"));
                    orcamento.setIdPeca(rs.getLong("ID_PECA"));
                    orcamentos.add(orcamento);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orçamentos: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamentos;
    }

    public OrcamentoTO findById(Long id) {
        OrcamentoTO orcamento = new OrcamentoTO();
        String sql = "SELECT * FROM T_SLC_ORCAMENTO WHERE ID_ORCAMENTO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                orcamento.setIdOrcamento(rs.getLong("ID_ORCAMENTO"));
                orcamento.setData(rs.getDate("DT_CRIACAO").toLocalDate());
                orcamento.setMaoDeObra(rs.getDouble("VL_MAO_OBRA"));
                orcamento.setIdOficina(rs.getLong("ID_OFICINA"));
                orcamento.setIdScanner(rs.getLong("ID_SCANNER"));
                orcamento.setIdPeca(rs.getLong("ID_PECA"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orçamento: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamento;
    }

    public OrcamentoTO save(OrcamentoTO orcamento) {
        String sql = "INSERT INTO T_SLC_ORCAMENTO (DT_CRIACAO, VL_MAO_OBRA, ID_OFICINA, ID_SCANNER, ID_PECA) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDate(1, java.sql.Date.valueOf(orcamento.getData()));
            ps.setDouble(2, orcamento.getMaoDeObra());
            ps.setLong(3, orcamento.getIdOficina());
            ps.setLong(4, orcamento.getIdScanner());
            ps.setLong(5, orcamento.getIdPeca());
            if (ps.executeUpdate() > 0) {
                return orcamento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir orçamento: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM T_SLC_ORCAMENTO WHERE ID_ORCAMENTO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar orçamento: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public OrcamentoTO update(OrcamentoTO orcamento) {
        String sql = "UPDATE T_SLC_ORCAMENTO SET DT_CRIACAO = ?, VL_MAO_OBRA = ?, ID_OFICINA = ?, ID_SCANNER = ?, ID_PECA = ? WHERE ID_ORCAMENTO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDate(1, java.sql.Date.valueOf(orcamento.getData()));
            ps.setDouble(2, orcamento.getMaoDeObra());
            ps.setLong(3, orcamento.getIdOficina());
            ps.setLong(4, orcamento.getIdScanner());
            ps.setLong(5, orcamento.getIdPeca());
            ps.setLong(6, orcamento.getIdOrcamento());
            if (ps.executeUpdate() > 0) {
                return orcamento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar orçamento: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
