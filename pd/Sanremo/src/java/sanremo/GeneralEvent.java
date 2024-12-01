/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

import javax.enterprise.event.Observes;

public class GeneralEvent {
    public void notifica(@Observes Canzone c){
        System.out.println(c);
    }
}
