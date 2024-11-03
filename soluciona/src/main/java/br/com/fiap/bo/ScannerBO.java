package br.com.fiap.bo;

import br.com.fiap.dao.ScannerDAO;
import br.com.fiap.to.ScannerTO;

import java.util.ArrayList;

public class ScannerBO {

    private ScannerDAO scannerDAO;

    public ArrayList<ScannerTO> findAll() {
        scannerDAO = new ScannerDAO();
        return scannerDAO.findAll();
    }

    public ScannerTO findById(Long id) {
        scannerDAO = new ScannerDAO();
        return scannerDAO.findById(id);
    }

    public ScannerTO save(ScannerTO scanner) {
        scannerDAO = new ScannerDAO();
        return scannerDAO.save(scanner);
    }

    public boolean delete(Long id) {
        scannerDAO = new ScannerDAO();
        return scannerDAO.delete(id);
    }

    public ScannerTO update(ScannerTO scanner) {
        scannerDAO = new ScannerDAO();
        return scannerDAO.update(scanner);
    }
}
