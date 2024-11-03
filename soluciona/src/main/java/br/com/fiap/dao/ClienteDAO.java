package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends Repository {
    public ArrayList<ClienteTO> findAll() {
        ArrayList<ClienteTO> clientes = new ArrayList<ClienteTO>();
        String sql = "SELECT * FROM T_SLC_CLIENTE ORDER BY ID_CLIENTE";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ClienteTO cliente = new ClienteTO();
                    cliente.setIdCliente(rs.getLong("ID_CLIENTE"));
                    cliente.setNome(rs.getString("NM_CLIENTE"));
                    cliente.setCpf(rs.getString("NR_CPF"));
                    cliente.setEmail(rs.getString("DS_EMAIL"));
                    cliente.setTelefone(rs.getString("NR_TELEFONE"));
                    cliente.setEndereco(rs.getString("DS_ENDERECO"));
                    cliente.setSenha(rs.getString("DS_SENHA"));
                    clientes.add(cliente);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar clientes: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public ClienteTO findByEmail(String email) {
        ClienteTO cliente = new ClienteTO();
        String sql = "SELECT * FROM T_SLC_CLIENTE WHERE DS_EMAIL = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setIdCliente(rs.getLong("ID_CLIENTE"));
                cliente.setNome(rs.getString("NM_CLIENTE"));
                cliente.setCpf(rs.getString("NR_CPF"));
                cliente.setEmail(rs.getString("DS_EMAIL"));
                cliente.setTelefone(rs.getString("NR_TELEFONE"));
                cliente.setEndereco(rs.getString("DS_ENDERECO"));
                cliente.setSenha(rs.getString("DS_SENHA"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }

    public ClienteTO save(ClienteTO cliente) {
        String sql = "INSERT INTO T_SLC_CLIENTE (NM_CLIENTE,NR_CPF, DS_EMAIL, NR_TELEFONE, DS_ENDERECO, DS_SENHA) VALUES (?, ?, ?, ?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getSenha());
            if (ps.executeUpdate() > 0) {
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(String email) {
        String sql = "DELETE FROM T_SLC_CLIENTE WHERE DS_EMAIL = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, email);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ClienteTO update(ClienteTO cliente) {
    String sql = "UPDATE T_SLC_CLIENTE SET NM_CLIENTE = ?, NR_CPF = ?, DS_EMAIL = ?, NR_TELEFONE = ?, DS_ENDERECO = ?, DS_SENHA = ? WHERE DS_EMAIL = ?";
    try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getTelefone());
        ps.setString(5, cliente.getEndereco());
        ps.setString(6, cliente.getSenha());
        ps.setString(7, cliente.getEmail());

        if (ps.executeUpdate() > 0) {
            return cliente;
        } else {
            return null;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar cliente: " + e.getMessage());
    } finally {
        closeConnection();
    }
    return null;
}
}

