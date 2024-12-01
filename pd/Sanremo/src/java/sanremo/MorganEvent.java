/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

import javax.enterprise.event.Observes;

public class MorganEvent {
    public void notifica(@Observes @Morgan Canzone c){
        System.out.println("Dov'è Bugo?");
        System.out.println("MorganEvent: " + c);
    }
}
