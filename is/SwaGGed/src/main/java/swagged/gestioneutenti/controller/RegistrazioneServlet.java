package swagged.gestioneutenti.controller;

import swagged.gestioneutenti.services.GestioneUtentiServiceImpl;
import swagged.model.bean.UtenteBean;
import swagged.model.dao.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UtenteDAO dbUtenti = new UtenteDAO();
        GestioneUtentiServiceImpl gestioneUtenti = new GestioneUtentiServiceImpl();
        String mode = request.getParameter("mode");
        String path = null;

        if(mode.equals("register")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String passwordCheck = request.getParameter("passwordCheck");
            String email = request.getParameter("email");
            Base64.Encoder encoder = Base64.getEncoder();
            String pwd64 = null;
            String pwdchk64 = null;

            pwd64 = encoder.encodeToString(password.getBytes());
            //System.out.println("Password codificata durante la registrazione: " + pwd64); // Aggiungi questa riga
            pwdchk64 = encoder.encodeToString(passwordCheck.getBytes());

            try {
                if(pwd64.equals(pwdchk64)) {
                    UtenteBean utente = new UtenteBean();
                    UtenteBean utenteRicercato = new UtenteBean();
                    boolean flag = false;
                    List<UtenteBean> listaUtenti = dbUtenti.getAll();
                    Iterator<UtenteBean> iterUtenti = listaUtenti.iterator();

                    utente.setUsername(username);
                    utente.setPassword(pwd64);

                    while(iterUtenti.hasNext()) {
                        utenteRicercato = iterUtenti.next();
                        if(!utenteRicercato.getUsername().equalsIgnoreCase(utente.getUsername())) {
                            if(utenteRicercato.getEmail().equalsIgnoreCase(email)) {
                                flag = true;
                                break;
                            }
                        }
                    }

                    utente.setEmail(email);
                    utente.setAdmin(false);

                    if(!flag) {
                        dbUtenti.save(utente);
                        request.getSession().setAttribute("result", "Registrato con successo!");
                    } else {
                        request.getSession().setAttribute("error", "Registrazione non completata. Riprovare.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            path = "login.jsp";
            request.removeAttribute("");

            RequestDispatcher view = request.getRequestDispatcher(path);
            view.forward(request, response);
        } else if(mode.equals("checkEmail")) {
            response.setContentType("text/plain");
            String email = request.getParameter("email");

            try {
                if(gestioneUtenti.checkEmail(email)) {
                    response.getWriter().print("non disponibile");
                } else {
                    response.getWriter().print("disponibile");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if(mode.equals("checkUsername")) {
            response.setContentType("text/plain");
            String username = request.getParameter("username");

            try {
                if(gestioneUtenti.checkUsername(username)) {
                    response.getWriter().print("non disponibile");
                } else {
                    response.getWriter().print("disponibile");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}