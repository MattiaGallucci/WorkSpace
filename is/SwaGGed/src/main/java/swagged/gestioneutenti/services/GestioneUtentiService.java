package swagged.gestioneutenti.services;

import swagged.model.bean.UtenteBean;

import javax.servlet.GenericServlet;
import javax.servlet.http.Part;
import java.sql.SQLException;
import java.util.List;

public interface GestioneUtentiService {
    boolean ban (String email) throws SQLException;
    List<UtenteBean> cerca(String substring) throws SQLException;
    boolean modificaImmagine(String email, Part filePart, GenericServlet servlet) throws SQLException;
    boolean checkEmail(String email) throws SQLException;
    boolean checkUsername(String username) throws SQLException;
    UtenteBean visualizza(String username) throws SQLException;
}
