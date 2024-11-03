package br.com.fiap.dao;

import br.com.fiap.to.ServicoAgendadoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoAgendadoDAO extends Repository {

    public ArrayList<ServicoAgendadoTO> findAll() {
        ArrayList<ServicoAgendadoTO> servicosAgendados = new ArrayList<ServicoAgendadoTO>();
        String sql = "SELECT * FROM T_SLC_SERVICO_AGENDADO ORDER BY ID_SERV_AGEND";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ServicoAgendadoTO servicoAgendado = new ServicoAgendadoTO();
                    servicoAgendado.setIdServicoAgendado(rs.getLong("ID_SERV_AGEND"));
                    servicoAgendado.setTipoDeVeiculo(rs.getString("DS_SERVICO"));
                    servicoAgendado.setTipoDeServico(rs.getString("DS_TP_VEICULO"));
                    servicoAgendado.setData(rs.getDate("DT_AGENDADA").toLocalDate());
                    servicoAgendado.setIdOrcamento(rs.getLong("ID_ORCAMENTO"));
                    servicosAgendados.add(servicoAgendado);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os servicos agendados: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servicosAgendados;
    }

    public ServicoAgendadoTO findById(Long id) {
        ServicoAgendadoTO servicoAgendado = new ServicoAgendadoTO();
        String sql = "SELECT * FROM T_SLC_SERVICO_AGENDADO WHERE ID_SERV_AGEND = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                servicoAgendado.setIdServicoAgendado(rs.getLong("ID_SERV_AGEND"));
                servicoAgendado.setTipoDeVeiculo(rs.getString("DS_SERVICO"));
                servicoAgendado.setTipoDeServico(rs.getString("DS_TP_VEICULO"));
                servicoAgendado.setData(rs.getDate("DT_AGENDADA").toLocalDate());
                servicoAgendado.setIdOrcamento(rs.getLong("ID_ORCAMENTO"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o servico agendado: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servicoAgendado;
    }

    public ServicoAgendadoTO save(ServicoAgendadoTO servicoAgendado) {
        String sql = "INSERT INTO T_SLC_SERVICO_AGENDADO (DS_SERVICO, DS_TP_VEICULO, DT_AGENDADA, ID_ORCAMENTO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servicoAgendado.getTipoDeVeiculo());
            ps.setString(2, servicoAgendado.getTipoDeServico());
            ps.setDate(3, java.sql.Date.valueOf(servicoAgendado.getData()));
            ps.setLong(4, servicoAgendado.getIdOrcamento());
            if (ps.executeUpdate() == 1) {
                return servicoAgendado;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o servico agendado: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM T_SLC_SERVICO_AGENDADO WHERE ID_SERV_AGEND = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o servico agendado: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ServicoAgendadoTO update(ServicoAgendadoTO servicoAgendado) {
        String sql = "UPDATE T_SLC_SERVICO_AGENDADO SET DS_SERVICO = ?, DS_TP_VEICULO = ?, DT_AGENDADA = ?, ID_ORCAMENTO = ? WHERE ID_SERV_AGEND = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servicoAgendado.getTipoDeVeiculo());
            ps.setString(2, servicoAgendado.getTipoDeServico());
            ps.setDate(3, java.sql.Date.valueOf(servicoAgendado.getData()));
            ps.setLong(4, servicoAgendado.getIdOrcamento());
            ps.setLong(5, servicoAgendado.getIdServicoAgendado());
            if (ps.executeUpdate() == 1) {
                return servicoAgendado;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o servico agendado: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
