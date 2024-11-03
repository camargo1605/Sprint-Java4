package br.com.fiap.dao;


import br.com.fiap.to.VeiculoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends Repository {

    public ArrayList<VeiculoTO> findAll() {
        ArrayList<VeiculoTO> clientes = new ArrayList<VeiculoTO>();
        String sql = "SELECT * FROM T_SLC_VEICULO ORDER BY ID_VEICULO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VeiculoTO veiculo = new VeiculoTO();
                    veiculo.setIdVeiculo(rs.getLong("ID_VEICULO"));
                    veiculo.setPlaca(rs.getString("NR_PLACA"));
                    veiculo.setMarca(rs.getString("NM_MARCA"));
                    veiculo.setModelo(rs.getString("NM_MODELO"));
                    veiculo.setAno(rs.getInt("NR_ANO_MODELO"));
                    veiculo.setIdCliente(rs.getLong("ID_CLIENTE"));
                    clientes.add(veiculo);
                }
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao buscar veículos: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public VeiculoTO findByPlaca(String placa) {
        VeiculoTO veiculo = new VeiculoTO();
        String sql = "SELECT * FROM T_SLC_VEICULO WHERE NR_PLACA = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                veiculo.setIdVeiculo(rs.getLong("ID_VEICULO"));
                veiculo.setPlaca(rs.getString("NR_PLACA"));
                veiculo.setMarca(rs.getString("NM_MARCA"));
                veiculo.setModelo(rs.getString("NM_MODELO"));
                veiculo.setAno(rs.getInt("NR_ANO_MODELO"));
                veiculo.setIdCliente(rs.getLong("ID_CLIENTE"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculo;
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        String sql = "INSERT INTO T_SLC_VEICULO (NR_PLACA, NM_MARCA, NM_MODELO, NR_ANO_MODELO, ID_CLIENTE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setInt(4, veiculo.getAno());
            ps.setLong(5, veiculo.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return veiculo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(String placa) {
        String sql = "DELETE FROM T_SLC_VEICULO WHERE NR_PLACA = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, placa);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public VeiculoTO update(VeiculoTO veiculo) {
        String sql = "UPDATE T_SLC_VEICULO SET NR_PLACA = ?, NM_MARCA = ?, NM_MODELO = ?, NR_ANO_MODELO = ?, ID_CLIENTE = ? WHERE NR_PLACA = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setInt(4, veiculo.getAno());
            ps.setLong(5, veiculo.getIdCliente());
            ps.setString(6, veiculo.getPlaca());
            if (ps.executeUpdate() > 0) {
                return veiculo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
