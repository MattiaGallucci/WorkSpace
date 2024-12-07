/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

import javax.enterprise.event.Observes;

public class GeneralEvent {
    public void notifica(@Observes Individuo i){
        System.out.println("Dati aggiornati");
    }
}
