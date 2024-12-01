/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa_Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import uefa.PartitaEJBRemote;

public class UEFAClient {
    private static PartitaEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (PartitaEJBRemote) ctx.lookup("java:global/UEFA/PartitaEJB!uefa.PartitaEJBRemote");
        
        System.out.println("Partite con piu di 2 goal:");
        System.out.println(ejb.trovaPartitePerNumeroGoalMaggiori2());
        
        System.out.println("Partite con 0 espulsioni:");
        System.out.println(ejb.trovaPartitePerNumeroEspulsioni0());
    }
}
