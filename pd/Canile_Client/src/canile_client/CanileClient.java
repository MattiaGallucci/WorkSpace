/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canile_client;

import canile.CanileEJBRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CanileClient {
    private static CanileEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (CanileEJBRemote) ctx.lookup("java:global/Canile/CanileEJB!canile.CanileEJBRemote");
        
        System.out.println("Cani di taglia piccola e di età >= 8:");
        System.out.println(ejb.trovaPiccoli8Anni());
        
        System.out.println("Cani non ancora adottati:");
        System.out.println(ejb.trovaPerStatusAdozione(false));
    }
    
}
