/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viaggi;

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
public class ViaggioEJB implements ViaggioEJBRemote{
    @Inject
    EntityManager em;
    
    @Override
    public void crea(Viaggio v) {
        em.persist(v);
    }

    @Override
    public void aggiorna(Viaggio v) {
        em.merge(v);
    }

    @Override
    public void elimina(Viaggio v) {
        em.remove(em.merge(v));
    }

    @Override
    public Viaggio trovaPerId(int id) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.TROVA_PER_ID, Viaggio.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Viaggio> trovaTutti() {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.TROVA_TUTTI, Viaggio.class);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> trovaPerDestinazione(String d) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.TROVA_PER_DESTINAZIONE, Viaggio.class);
        query.setParameter("destinazione", d);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> trovaPerCategoria(String c) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.TROVA_PER_CATEGORIA, Viaggio.class);
        query.setParameter("categoria", c);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> trovaPerPrezzo(int p) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.TROVA_PER_PREZZO, Viaggio.class);
        query.setParameter("prezzo", p);
        return query.getResultList();
    }
}