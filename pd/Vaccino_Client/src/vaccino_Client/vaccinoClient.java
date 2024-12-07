/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino_Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import vaccino.Categoria;
import vaccino.VaccinoEJBRemote;

/**
 *
 * @author matti
 */
public class vaccinoClient {
    private static VaccinoEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (VaccinoEJBRemote) ctx.lookup("java:global/Vaccino/VaccinoEJB!vaccino/VaccinoEJBRemote");

        System.out.println(ejb.trovaPerCovidContratto(true));
        System.out.println(ejb.trovaPerCategoriaEta(Categoria.DOCENTE, 55));
        System.out.println(ejb.trovaPerCategoriaInteresse(Categoria.PENSIONATO, true));
    }
}