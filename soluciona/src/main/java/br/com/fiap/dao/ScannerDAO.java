package br.com.fiap.dao;

import br.com.fiap.to.ScannerTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScannerDAO extends Repository {

    public ArrayList<ScannerTO> findAll() {
        ArrayList<ScannerTO> scanners = new ArrayList<ScannerTO>();
        String sql = "SELECT * FROM T_SLC_RESULTADO_SCANNER ORDER BY ID_SCANNER";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ScannerTO scanner = new ScannerTO();
                scanner.setIdScanner(rs.getLong("id_scanner"));
                scanner.setTemperaturaMotor(rs.getDouble("nr_temp_motor"));
                scanner.setPressaoDoOleo(rs.getString("ds_pressao_oleo"));
                scanner.setVelocidadeDoVeiculo(rs.getDouble("nr_velo_veiculo"));
                scanner.setIdVeiculo(rs.getLong("id_veiculo"));
                scanner.setIdCliente(rs.getLong("id_cliente"));
                scanners.add(scanner);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return scanners;
    }

    public ScannerTO findById(Long id) {
        ScannerTO scanner = new ScannerTO();
        String sql = "SELECT * FROM T_SLC_RESULTADO_SCANNER WHERE ID_SCANNER = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                scanner.setIdScanner(rs.getLong("id_scanner"));
                scanner.setTemperaturaMotor(rs.getDouble("nr_temp_motor"));
                scanner.setPressaoDoOleo(rs.getString("ds_pressao_oleo"));
                scanner.setVelocidadeDoVeiculo(rs.getDouble("nr_velo_veiculo"));
                scanner.setIdVeiculo(rs.getLong("id_veiculo"));
                scanner.setIdCliente(rs.getLong("id_cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return scanner;
    }

    public ScannerTO save(ScannerTO scanner) {
        String sql = "INSERT INTO T_SLC_RESULTADO_SCANNER (NR_TEMP_MOTOR, DS_PRESSAO_OLEO, NR_VELO_VEICULO, ID_VEICULO, ID_CLIENTE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDouble(1, scanner.getTemperaturaMotor());
            ps.setString(2, scanner.getPressaoDoOleo());
            ps.setDouble(3, scanner.getVelocidadeDoVeiculo());
            ps.setLong(4, scanner.getIdVeiculo());
            ps.setLong(5, scanner.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return scanner;
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
        String sql = "DELETE FROM T_SLC_RESULTADO_SCANNER WHERE ID_SCANNER = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ScannerTO update(ScannerTO scanner) {
        String sql = "UPDATE T_SLC_RESULTADO_SCANNER SET NR_TEMP_MOTOR = ?, DS_PRESSAO_OLEO = ?, NR_VELO_VEICULO = ?, ID_VEICULO = ?, ID_CLIENTE = ? WHERE ID_SCANNER = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDouble(1, scanner.getTemperaturaMotor());
            ps.setString(2, scanner.getPressaoDoOleo());
            ps.setDouble(3, scanner.getVelocidadeDoVeiculo());
            ps.setLong(4, scanner.getIdVeiculo());
            ps.setLong(5, scanner.getIdCliente());
            ps.setLong(6, scanner.getIdScanner());
            ps.executeUpdate();
            if (ps.executeUpdate() > 0) {
                return scanner;
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
