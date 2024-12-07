/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dpcm_client;

import dpcm.DpcmEJBRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author matti
 */
public class Dpcm_Client {
    private static DpcmEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ejb = (DpcmEJBRemote) ctx.lookup("java:global/Dpcm/DpcmEJB!dpcm.DpcmEJBRemote");
        System.out.println(ejb.trovaTutti());
        System.out.println(ejb.trovaPerTipo("Sanitaria"));
        System.out.println(ejb.trovaPerStampa(12));
    }
}