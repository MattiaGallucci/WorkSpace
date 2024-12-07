/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpcm;

import javax.enterprise.event.Observes;

/**
 *
 * @author matti
 */
public class Evento {
    public void notifica(@Observes Dpcm d){
        System.out.println("Aggiornamento effettuato");
    }
}
