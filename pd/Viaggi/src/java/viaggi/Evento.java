/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viaggi;

import javax.enterprise.event.Observes;

/**
 *
 * @author matti
 */
public class Evento {
    public void notifica(@Observes Viaggio v){
        System.out.println("Aggiornamento effettuato");
    }
}
