/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpcm;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class DpcmEJB implements DpcmEJBRemote{

    @Inject
	EntityManager em;

    @Override
    public void crea(Dpcm d){
        em.persist(d);
    }
    
    @Override
    public void aggiorna(Dpcm d){
        em.merge(d);
    }
    
    @Override
    public void elimina(Dpcm d){
        em.remove(em.merge(d));
    }

    @Override
    public List<Dpcm> trovaTutti(){
	TypedQuery<Dpcm> query = em.createNamedQuery(Dpcm.TROVA_TUTTI, Dpcm.class);
	return query.getResultList();
    }
    
    @Override
    public Dpcm trovaPerId(int id){
        TypedQuery<Dpcm> query = em.createNamedQuery(Dpcm.TROVA_PER_ID, Dpcm.class);
        query.setParameter("id", id);
	return query.getSingleResult();

    }
    
    @Override
    public List<Dpcm> trovaPerEmergenza(String emergenza){
        TypedQuery<Dpcm> query = em.createNamedQuery(Dpcm.TROVA_PER_EMERGENZA, Dpcm.class);
        query.setParameter("emergenza", emergenza);
	return query.getResultList();
    }
    
    @Override
    public List<Dpcm> trovaPerTipo(String tipo){
        TypedQuery<Dpcm> query = em.createNamedQuery(Dpcm.TROVA_PER_TIPO, Dpcm.class);
        query.setParameter("tipo", tipo);
	return query.getResultList();
    }
        
    @Override
    public List<Dpcm> trovaPerStampa(int stampa){
        TypedQuery<Dpcm> query = em.createNamedQuery(Dpcm.TROVA_PER_STAMPA, Dpcm.class);
        query.setParameter("stampa", stampa);
	return query.getResultList();
    }
}