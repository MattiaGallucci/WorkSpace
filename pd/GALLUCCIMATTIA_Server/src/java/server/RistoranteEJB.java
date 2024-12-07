package server;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@LocalBean
@Stateless
@Counter
public class RistoranteEJB implements RistoranteEJBRemote {

    @Inject
    EntityManager em;

    @Override
    public void crea(Prenotazione p) {
        em.persist(p);
    }

    @Override
    public void aggiorna(Prenotazione p) {
        em.merge(p);
    }

    @Override
    public void elimina(Prenotazione p) {
        em.remove(em.merge(p));
    }

    @Override
    public Prenotazione trovaPerId(int id) {
        try {
            TypedQuery<Prenotazione> query = em.createNamedQuery(Prenotazione.TROVA_PER_ID, Prenotazione.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Prenotazione> trovaPerTipoTavolo(String tipoTavolo) {
        TypedQuery<Prenotazione> query = em.createNamedQuery(Prenotazione.TROVA_PER_TIPO_TAVOLO, Prenotazione.class);
        query.setParameter("tipoTavolo", tipoTavolo);
        return query.getResultList();
    }

    @Override
    public List<Prenotazione> trovaTutti() {
        TypedQuery<Prenotazione> query = em.createNamedQuery(Prenotazione.TROVA_TUTTI, Prenotazione.class);
        return query.getResultList();
    }

    @Override
    @Counter
    public List<Prenotazione> trovaPerNumeroPersone(int numeroPersone) {
        TypedQuery<Prenotazione> query = em.createNamedQuery(Prenotazione.TROVA_PER_NUMERO_PERSONE, Prenotazione.class);
        query.setParameter("numeroPersone", numeroPersone);
        return query.getResultList();
    }
}