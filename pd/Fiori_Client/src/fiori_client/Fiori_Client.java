/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fiori_client;

import fiori.FioriEJBRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author matti
 */
public class Fiori_Client {

    private static FioriEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (FioriEJBRemote) ctx.lookup("java:global/Fiori/FioriEJB!fiori.FioriEJBRemote");
    
        System.out.println(ejb.trovaTutti());
        System.out.println(ejb.trovaPerCiclo("Annuale"));
        System.out.println(ejb.trovaPerUso("Dolci"));
    }
    
}
