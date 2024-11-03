package br.com.fiap.bo;

import br.com.fiap.dao.ServicoAgendadoDAO;
import br.com.fiap.to.ServicoAgendadoTO;

import java.util.ArrayList;

public class ServicoAgendadoBO {

    private ServicoAgendadoDAO servicoAgendadoDAO;

    public ArrayList<ServicoAgendadoTO> findAll(){
        servicoAgendadoDAO = new ServicoAgendadoDAO();
        return servicoAgendadoDAO.findAll();
    }

    public ServicoAgendadoTO findById(Long id) {
        servicoAgendadoDAO = new ServicoAgendadoDAO();
        return servicoAgendadoDAO.findById(id);
    }

    public ServicoAgendadoTO save(ServicoAgendadoTO servicoAgendado) {
        servicoAgendadoDAO = new ServicoAgendadoDAO();
        return servicoAgendadoDAO.save(servicoAgendado);
    }

    public boolean delete(Long id) {
        servicoAgendadoDAO = new ServicoAgendadoDAO();
        return servicoAgendadoDAO.delete(id);
    }

    public ServicoAgendadoTO update(ServicoAgendadoTO servicoAgendado) {
        servicoAgendadoDAO = new ServicoAgendadoDAO();
        return servicoAgendadoDAO.update(servicoAgendado);
    }

}
