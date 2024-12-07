/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viaggi_client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import viaggi.ViaggioEJBRemote;

/**
 *
 * @author matti
 */
public class Viaggi_Client {

    private static ViaggioEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (ViaggioEJBRemote) ctx.lookup("java:global/Viaggi/ViaggioEJB!viaggi.ViaggioEJBRemote");
        
        System.out.println(ejb.trovaPerPrezzo(600));
    }
}