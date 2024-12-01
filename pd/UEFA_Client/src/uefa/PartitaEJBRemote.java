/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uefa;

import java.util.List;
import javax.ejb.Remote;
import uefa.Partita;
import uefa.Partita;
import uefa.TipologiaPartita;
import uefa.TipologiaPartita;

@Remote
public interface PartitaEJBRemote {
    void creaPartita(Partita p);
    //void creaPartita(TipologiaPartita tipologiaPartita, String squadraCasa, String squadraOspite, int goalSquadraCasa, int goalSquadraOspite, int numeroAmmonizioni, int numeroEspulsioni, boolean giocata);

    void aggiornaPartita(Partita p);
    //void aggiornaPartita(int id, TipologiaPartita tipologiaPartita, String squadraCasa, String squadraOspite, int goalSquadraCasa, int goalSquadraOspite, int numeroAmmonizioni, int numeroEspulsioni, boolean giocata);

    void eliminaPartita(Partita p);
    //void eliminaPartita(int id);
    
    List<Partita> trovaPartite();
    Partita trovaPerId(int id);
    List<Partita> trovaPartitePerTipologia(TipologiaPartita tipologiaPartita);
    List<Partita> trovaPartitePerNumeroAmmonizioni(int numeroAmmonizioni);
    List<Partita> trovaPartitePerNumeroEspulsioni(int numeroEspulsioni);
    List<Partita> trovaPartitePerNumeroGoalMaggiori2();
    List<Partita> trovaPartitePerNumeroEspulsioni0();
}
