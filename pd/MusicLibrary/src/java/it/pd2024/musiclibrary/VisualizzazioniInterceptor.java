/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.pd2024.musiclibrary;


import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 *
 * @author matti
 */
@Interceptor
public class VisualizzazioniInterceptor {
    private static final Logger logger = Logger.getLogger(VisualizzazioniInterceptor.class.getName());

    @Inject
    private EntityManager em;
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        
          if (ic.getMethod().getName().equals("play")) {
            Object[] params = ic.getParameters();
            if (params != null && params.length > 0) {
                long songId = (Long) params[0];  // Ottieni l'ID della canzone

                // Trova la canzone nel database
                Song song = em.find(Song.class, songId);
                if (song != null) {
                    // Incrementa il numero di visualizzazioni
                    song.setVisualizzazioni(song.getVisualizzazioni() + 1);
                    em.merge(song);  // Salva le modifiche nel database
                }
            }
        }
        
        try {
            return ic.proceed();
        } finally {
        logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
