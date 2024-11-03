package br.com.fiap.dao;

import br.com.fiap.to.PecaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO extends Repository {

    public ArrayList<PecaTO> findAll() {
        ArrayList <PecaTO> pecas = new ArrayList<PecaTO>();
        String sql = "SELECT * FROM T_SLC_PECA ORDER BY ID_PECA";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PecaTO peca = new PecaTO();
                peca.setIdPeca(rs.getLong("id_peca"));
                peca.setNome(rs.getString("nm_peca"));
                peca.setNumeroDeSerie(rs.getDouble("nr_serie"));
                peca.setPreco(rs.getDouble("vl_preco"));
                pecas.add(peca);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pecas;
    }

    public PecaTO findById(Long id) {
        PecaTO peca = new PecaTO();
        String sql = "SELECT * FROM T_SLC_PECA WHERE ID_PECA = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                peca.setIdPeca(rs.getLong("id_peca"));
                peca.setNome(rs.getString("nm_peca"));
                peca.setNumeroDeSerie(rs.getDouble("nr_serie"));
                peca.setPreco(rs.getDouble("vl_preco"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return peca;
    }

    public PecaTO save(PecaTO peca) {
        String sql = "INSERT INTO T_SLC_PECA (NM_PECA, NR_SERIE, VL_PRECO) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNome());
            ps.setDouble(2, peca.getNumeroDeSerie());
            ps.setDouble(3, peca.getPreco());
            if (ps.executeUpdate() > 0) {
                return peca;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM T_SLC_PECA WHERE ID_PECA = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public PecaTO update(PecaTO peca) {
        String sql = "UPDATE T_SLC_PECA SET NM_PECA = ?, NR_SERIE = ?, VL_PRECO = ? WHERE ID_PECA = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNome());
            ps.setDouble(2, peca.getNumeroDeSerie());
            ps.setDouble(3, peca.getPreco());
            ps.setLong(4, peca.getIdPeca());
            if (ps.executeUpdate() > 0) {
                return peca;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }


}
