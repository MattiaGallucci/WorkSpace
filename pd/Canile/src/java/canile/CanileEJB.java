/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canile;

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
@Counter
public class CanileEJB implements CanileEJBRemote{
    
    @Inject
    EntityManager em;

    @Override
    public void creaCane(Cane c) {
        em.persist(c);
    }

    @Override
    public void aggironaCane(Cane c) {
        em.merge(c);
    }

    @Override
    public void eliminaCane(Cane c) {
        em.remove(em.merge(c));
    }

    @Override
    public List<Cane> trovaTutti() {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_TUTTI, Cane.class);
        return query.getResultList();
    }

    @Override
    public List<Cane> trovaPerId(int id) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_PER_ID, Cane.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Cane> trovaPerRazza(String razza) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_PER_RAZZA, Cane.class);
        query.setParameter("razza", razza);
        return query.getResultList();
    }

    @Override
    public List<Cane> trovaPerNome(String nome) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_PER_NOME, Cane.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    @Override
    public List<Cane> trovaPerTaglia(Taglia taglia) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_PER_TAGLIA, Cane.class);
        query.setParameter("taglia", taglia);
        return query.getResultList();
    }

    @Override
    public List<Cane> trovaPerStatusAdozione(boolean adottato) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_PER_STATUS_ADOZIONE, Cane.class);
        query.setParameter("adottato", adottato);
        return query.getResultList();
    }

    @Override
    public List<Cane> trovaPiccoli8Anni() {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_PICCOLI_8_ANNI, Cane.class);
        query.setParameter("taglia", Taglia.PICCOLA);
        query.setParameter("fasciaEta", FasciaEta.OTTO_PIU);
        return query.getResultList();
    }
    
    @Override
    @Adottato
    public void adotta(int id){
        
    }
}