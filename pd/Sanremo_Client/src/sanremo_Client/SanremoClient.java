/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo_Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sanremo.SanremoEJBRemote;

/**
 *
 * @author matti
 */
public class SanremoClient {
    private static SanremoEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (SanremoEJBRemote) ctx.lookup("java:global/Sanremo/SanremoEJB!sanremo.SanremoEJBRemote");
        
        System.out.println(ejb.printAll());
        System.out.println(ejb.printByCategory("Pop"));
    }
}
