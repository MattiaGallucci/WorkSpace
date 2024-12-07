/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori;

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
public class FioriEJB implements FioriEJBRemote{
    
    @Inject
    EntityManager em;

    @Override
    public void crea(Fiore f) {
        em.persist(f);
    }

    @Override
    public void elimina(Fiore f) {
        em.remove(em.merge(f));
    }

    @Override
    public void aggiorna(Fiore f) {
        em.merge(f);
    }

    @Override
    public Fiore trovaPerId(int id) {
        return em.find(Fiore.class, id);
    }

    @Override
    public List<Fiore> trovaTutti() {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_TUTTI, Fiore.class);
        return query.getResultList();
    }

    @Override
    public List<Fiore> trovaPerCiclo(String ciclo) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_PER_CICLO, Fiore.class);
        query.setParameter("cicloBiologico", ciclo);
        return query.getResultList();
    }

    @Override
    public List<Fiore> trovaPerUso(String uso) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_PER_USO, Fiore.class);
        query.setParameter("uso", uso);
        return query.getResultList();
    }   

    @Override
    public List<Fiore> trovaPerProprieta(String proprieta) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_PER_PROPRIETA, Fiore.class);
        query.setParameter("proprieta", proprieta);
        return query.getResultList();
    }
}