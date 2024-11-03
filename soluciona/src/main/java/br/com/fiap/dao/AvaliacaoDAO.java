package br.com.fiap.dao;

import br.com.fiap.to.AvaliacaoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvaliacaoDAO extends Repository {

    public ArrayList<AvaliacaoTO> findAll() {
        ArrayList<AvaliacaoTO> avaliacoes = new ArrayList<AvaliacaoTO>();
        String sql = "SELECT * FROM T_SLC_AVALIACAO ORDER BY ID_AVALIACAO";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                AvaliacaoTO avaliacao = new AvaliacaoTO();
                avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
                avaliacao.setNota(rs.getDouble("nr_nota"));
                avaliacao.setExperiencia(rs.getString("ds_experiencia"));
                avaliacao.setIdCliente(rs.getLong("id_cliente"));
                avaliacoes.add(avaliacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return avaliacoes;
    }

    public AvaliacaoTO findById(Long id) {
        AvaliacaoTO avaliacao = new AvaliacaoTO();
        String sql = "SELECT * FROM T_SLC_AVALIACAO WHERE ID_AVALIACAO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
                avaliacao.setNota(rs.getDouble("nr_nota"));
                avaliacao.setExperiencia(rs.getString("ds_experiencia"));
                avaliacao.setIdCliente(rs.getLong("id_cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return avaliacao;
    }

    public AvaliacaoTO save(AvaliacaoTO avaliacao) {
        String sql = "INSERT INTO T_SLC_AVALIACAO (NR_NOTA, DS_EXPERIENCIA, ID_CLIENTE) VALUES (?, ?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDouble(1, avaliacao.getNota());
            ps.setString(2, avaliacao.getExperiencia());
            ps.setLong(3, avaliacao.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return avaliacao;
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
        String sql = "DELETE FROM T_SLC_AVALIACAO WHERE ID_AVALIACAO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public AvaliacaoTO update(AvaliacaoTO avaliacao) {
        String sql = "UPDATE T_SLC_AVALIACAO SET NR_NOTA = ?, DS_EXPERIENCIA = ?, ID_CLIENTE = ? WHERE ID_AVALIACAO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDouble(1, avaliacao.getNota());
            ps.setString(2, avaliacao.getExperiencia());
            ps.setLong(3, avaliacao.getIdCliente());
            ps.setLong(4, avaliacao.getIdAvaliacao());
            ps.executeUpdate();
            if (ps.executeUpdate() > 0) {
                return avaliacao;
            } else {
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
