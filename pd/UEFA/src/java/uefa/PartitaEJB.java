/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
@WebService
public class PartitaEJB implements PartitaEJBRemote{
    
    @Inject
    EntityManager em;

    @Override
    public void creaPartita(Partita p) {
        em.persist(p);
    }

    /*@Override
    public void creaPartita(TipologiaPartita tipologiaPartita, String squadraCasa, String squadraOspite, int goalSquadraCasa, int goalSquadraOspite, int numeroAmmonizioni, int numeroEspulsioni, boolean giocata) {
        Partita p = new Partita(tipologiaPartita, squadraCasa, squadraOspite, goalSquadraCasa, goalSquadraOspite, numeroAmmonizioni, numeroEspulsioni, giocata);
        em.persist(p);
    }*/

    @Override
    public void aggiornaPartita(Partita p) {
        em.merge(p);
    }

    /*@Override
    public void aggiornaPartita(int id, TipologiaPartita tipologiaPartita, String squadraCasa, String squadraOspite, int goalSquadraCasa, int goalSquadraOspite, int numeroAmmonizioni, int numeroEspulsioni, boolean giocata) {
        Partita p = new Partita(id, tipologiaPartita, squadraCasa, squadraOspite, goalSquadraCasa, goalSquadraOspite, numeroAmmonizioni, numeroEspulsioni, giocata);
        em.merge(p);
    }*/

    @Override
    public void eliminaPartita(Partita p) {
        em.remove(em.merge(p));
    }

    /*@Override
    public void eliminaPartita(int id) {
        em.remove(em.find(Partita.class, id));
    }*/

    @Override
    public List<Partita> trovaPartite() {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_PARTITE, Partita.class);
        return query.getResultList();
    }
    
    @Override
    public Partita trovaPerId(int id) {
        return em.find(Partita.class, id);
    }

    @Override
    public List<Partita> trovaPartitePerTipologia(TipologiaPartita tipologiaPartita) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_PER_TIPOLOGIA_PARTITA, Partita.class);
        query.setParameter("tipologiaPartita", tipologiaPartita);
        return query.getResultList();
    }

    @Override
    public List<Partita> trovaPartitePerNumeroAmmonizioni(int numeroAmmonizioni) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_PER_NUMERO_AMMONIZIONI, Partita.class);
        query.setParameter("numeroAmmonizioni", numeroAmmonizioni);
        return query.getResultList();
    }

    @Override
    public List<Partita> trovaPartitePerNumeroEspulsioni(int numeroEspulsioni) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_PER_NUMERO_ESPULSIONI, Partita.class);
        query.setParameter("numeroEspulsioni", numeroEspulsioni);
        return query.getResultList();
    }

    @Override
    public List<Partita> trovaPartitePerNumeroGoalMaggiori2() {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_GOAL_MAGGIORI_2, Partita.class);
        return query.getResultList();
    }

    @Override
    public List<Partita> trovaPartitePerNumeroEspulsioni0() {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_ESPULSIONI_0, Partita.class);
        return query.getResultList();
    }
}
