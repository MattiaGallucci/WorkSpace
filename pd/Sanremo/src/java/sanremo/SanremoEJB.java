/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

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
public class SanremoEJB implements SanremoEJBRemote{
    
    @Inject
    EntityManager em;

    @Override
    public void crea(Canzone c) {
       em.persist(c);
    }

    @Override
    public void aggiorna(Canzone c) {
        em.merge(c);
    }

    @Override
    public void elimina(Canzone c) {
        em.remove(em.merge(c));
    }

    @Counter
    @Override
    public List<Canzone> printAll() {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_TUTTE, Canzone.class);
        return query.getResultList();
    }
    
    @Counter
    @Override
    public Canzone printById(int id) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_PER_ID, Canzone.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Counter
    @Override
    public List<Canzone> printByCategory(String categoria) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_PER_CATEGORIA, Canzone.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @CheckParameter
    @Override
    public List<Canzone> printByVotes(int voti) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_TUTTE, Canzone.class);
        query.setParameter("voti", voti);
        return query.getResultList();
    }
    
}
