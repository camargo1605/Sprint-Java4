package br.com.fiap.dao;

import br.com.fiap.to.OficinaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO extends Repository {

    public ArrayList<OficinaTO> findAll(){
        ArrayList<OficinaTO> oficinas = new ArrayList<OficinaTO>();
        String sql = "SELECT * FROM T_SLC_OFICINA ORDER BY ID_OFICINA";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OficinaTO oficina = new OficinaTO();
                oficina.setIdOficina(rs.getLong("id_oficina"));
                oficina.setNome(rs.getString("nm_oficina"));
                oficina.setEndereco(rs.getString("ds_endereco"));
                oficina.setEmail(rs.getString("ds_email"));
                oficina.setCnpj(rs.getString("nr_cnpj"));
                oficina.setTelefone(rs.getString("nr_telefone"));
                oficinas.add(oficina);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficinas;
    }

    public OficinaTO findByEmail(String email){
        OficinaTO oficina = new OficinaTO();
        String sql = "SELECT * FROM T_SLC_OFICINA WHERE DS_EMAIL = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                oficina.setIdOficina(rs.getLong("id_oficina"));
                oficina.setNome(rs.getString("nm_oficina"));
                oficina.setEndereco(rs.getString("ds_endereco"));
                oficina.setEmail(rs.getString("ds_email"));
                oficina.setCnpj(rs.getString("nr_cnpj"));
                oficina.setTelefone(rs.getString("nr_telefone"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficina;
    }

    public OficinaTO save(OficinaTO oficina) {
        String sql = "INSERT INTO T_SLC_OFICINA (NM_OFICINA, DS_ENDERECO, DS_EMAIL, NR_CNPJ, NR_TELEFONE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getNome());
            ps.setString(2, oficina.getEndereco());
            ps.setString(3, oficina.getEmail());
            ps.setString(4, oficina.getCnpj());
            ps.setString(5, oficina.getTelefone());
            if (ps.executeUpdate() > 0) {
                return oficina;
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

    public boolean delete(String email) {
        String sql = "DELETE FROM T_SLC_OFICINA WHERE DS_EMAIL = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, email);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public OficinaTO update(OficinaTO oficina) {
        String sql = "UPDATE T_SLC_OFICINA SET NM_OFICINA = ?, DS_ENDERECO = ?, DS_EMAIL = ?, NR_CNPJ = ?, NR_TELEFONE = ? WHERE DS_EMAIL = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getNome());
            ps.setString(2, oficina.getEndereco());
            ps.setString(3, oficina.getEmail());
            ps.setString(4, oficina.getCnpj());
            ps.setString(5, oficina.getTelefone());
            ps.setString(6, oficina.getEmail());
            ps.executeUpdate();
            if (ps.executeUpdate() > 0) {
                return oficina;
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
