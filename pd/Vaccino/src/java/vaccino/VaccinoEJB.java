/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class VaccinoEJB implements VaccinoEJBRemote{
    
    @Inject
    EntityManager em;

    @Override
    public void creaIndividuo(Individuo i) {
        em.persist(i);
    }

    @Override
    public void aggiornaIndividuo(Individuo i) {
        em.merge(i);
    }

    @Override
    public void eliminaIndividuo(Individuo i) {
        em.remove(em.merge(i));
    }

    @Override
    public List<Individuo> trovaTutti() {
        TypedQuery<Individuo> query = em.createNamedQuery(Individuo.TROVA_TUTTI, Individuo.class);
        return query.getResultList();
    }

    @Override
    public Individuo trovaPerId(int id) {
        TypedQuery<Individuo> query = em.createNamedQuery(Individuo.TROVA_PER_ID, Individuo.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Individuo> trovaPerCategoria(Categoria c) {
        TypedQuery<Individuo> query = em.createNamedQuery(Individuo.TROVA_PER_CATEGORIA, Individuo.class);
        query.setParameter("categoria", c);
        return query.getResultList();
    }

    @Override
    public List<Individuo> trovaPerEta(int e) {
        TypedQuery<Individuo> query = em.createNamedQuery(Individuo.TROVA_PER_ETA, Individuo.class);
        query.setParameter("eta", e);
        return query.getResultList();
    }

    @Override
    public List<Individuo> trovaPerCovidContratto(boolean b) {
        TypedQuery<Individuo> query = em.createNamedQuery(Individuo.TROVA_PER_COVID_CONTRATTO, Individuo.class);
        query.setParameter("covidContratto", b);
        return query.getResultList();
    }

    @Override
    public List<Individuo> trovaPerCategoriaEta(Categoria c, int e) {
        TypedQuery<Individuo> query = em.createNamedQuery(Individuo.TROVA_PER_CATEGORIA_ETA, Individuo.class);
        query.setParameter("categoria", c);
        query.setParameter("eta", e);
        return query.getResultList();
    }

    @Override
    public List<Individuo> trovaPerCategoriaInteresse(Categoria c, boolean i) {
        TypedQuery<Individuo> query = em.createNamedQuery(Individuo.TROVA_PER_CATEGORIA_INTERESSE, Individuo.class);
        query.setParameter("categoria", c);
        query.setParameter("interesse", i);
        return query.getResultList();
    }
}
