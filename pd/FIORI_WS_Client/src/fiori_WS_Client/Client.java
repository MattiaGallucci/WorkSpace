/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori_WS_Client;

import fiori.Fiore;
import fiori.FioriEJB;
import fiori.FioriEJBService;
import java.util.List;

/**
 *
 * @author matti
 */
public class Client {
    
    public static void main(String[] args) {
        List<Fiore> fiori = trovaPerProprieta("Antinfiammatorie");
        
        for(Fiore f: fiori)
            System.out.println(f.getId());
    }
    
    private static List<Fiore> trovaPerProprieta(String proprieta){
        FioriEJBService service = new FioriEJBService();
        
        FioriEJB port = service.getFioriEJBPort();
        
        return port.trovaPerProprieta(proprieta);
    }
    
}
