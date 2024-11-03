package br.com.fiap.bo;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.to.VeiculoTO;

import java.util.ArrayList;

public class VeiculoBO {

    private VeiculoDAO veiculoDAO;

    public ArrayList<VeiculoTO> findAll() {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.findAll();
    }

    public VeiculoTO findByPlaca(String placa) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.findByPlaca(placa);
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.save(veiculo);
    }

    public boolean delete(String placa) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.delete(placa);
    }

    public VeiculoTO update(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.update(veiculo);
    }
}
