/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori;

import javax.enterprise.event.Observes;

public class Evento {
    public void notifica(@Observes Fiore f){
        System.out.println("Giacenza bassa per il prodotto " + f.getId());
    }
}
