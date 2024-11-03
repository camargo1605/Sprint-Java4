package br.com.fiap.bo;

import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.to.AvaliacaoTO;

import java.util.ArrayList;

public class AvaliacaoBO {

    private AvaliacaoDAO avaliacaoDAO;

    public ArrayList<AvaliacaoTO> findAll() {
        avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.findAll();
    }

    public AvaliacaoTO findById(Long id) {
        avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.findById(id);
    }

    public AvaliacaoTO save(AvaliacaoTO avaliacao) {
        avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.save(avaliacao);
    }

    public boolean delete(Long id) {
        avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.delete(id);
    }

    public AvaliacaoTO update(AvaliacaoTO avaliacao) {
        avaliacaoDAO = new AvaliacaoDAO();
        return avaliacaoDAO.update(avaliacao);
    }
}
