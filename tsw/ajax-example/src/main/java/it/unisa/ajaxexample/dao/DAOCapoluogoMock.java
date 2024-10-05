package it.unisa.ajaxexample.dao;

import it.unisa.ajaxexample.model.Capoluogo;

public class DAOCapoluogoMock implements IDAOCapoluogo {
    
    public Capoluogo findCapolougoByCAP(String CAP) {
        if (CAP.equals("84121")) {
            return new Capoluogo("Salerno", "84121", "Campania");
        }
        if (CAP.equals("00100")) {
            return new Capoluogo("Roma", "00100", "Lazio");
        }
        if (CAP.equals("02100")) {
            return new Capoluogo("Milano", "02100", "Lombardia");
        }
        return null;
    }
    
}
