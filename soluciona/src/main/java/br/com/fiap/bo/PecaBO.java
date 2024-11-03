package br.com.fiap.bo;

import br.com.fiap.dao.PecaDAO;
import br.com.fiap.to.PecaTO;

import java.util.ArrayList;

public class PecaBO {

    private PecaDAO pecaDAO;

    public ArrayList<PecaTO> findAll() {
        pecaDAO = new PecaDAO();
        return pecaDAO.findAll();
    }

    public PecaTO findById(Long id) {
        pecaDAO = new PecaDAO();
        return pecaDAO.findById(id);
    }

    public PecaTO save(PecaTO peca) {
        pecaDAO = new PecaDAO();
        return pecaDAO.save(peca);
    }

    public boolean delete(Long id) {
        pecaDAO = new PecaDAO();
        return pecaDAO.delete(id);
    }

    public PecaTO update(PecaTO peca) {
        pecaDAO = new PecaDAO();
        return pecaDAO.update(peca);
    }
}
