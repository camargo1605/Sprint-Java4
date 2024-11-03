package br.com.fiap.bo;

import br.com.fiap.dao.OrcamentoDAO;
import br.com.fiap.to.OrcamentoTO;

import java.util.ArrayList;

public class OrcamentoBO {

    private OrcamentoDAO orcamentoDAO;

    public ArrayList<OrcamentoTO> findAll() {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.findAll();
    }

    public OrcamentoTO findById(Long id) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.findById(id);
    }

    public OrcamentoTO save(OrcamentoTO orcamento) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.save(orcamento);
    }

    public boolean delete(Long id) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.delete(id);
    }

    public OrcamentoTO update(OrcamentoTO orcamento) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.update(orcamento);
    }
}
