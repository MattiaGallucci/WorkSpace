/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

import javax.enterprise.event.Observes;

public class PensionatoEvent {
    public void notifica(@Observes @Pensionato Individuo i){
        System.out.println("Ha precedenza");
    }
}
