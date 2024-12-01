/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo_WS_Client;

import java.util.List;
import sanremo.Canzone;
import sanremo.SanremoEJB;
import sanremo.SanremoEJBService;

/**
 *
 * @author matti
 */
public class SanremoWSClient {
    public static void main(String[] args) {
        List<Canzone> canzoni = trovaTutte();
        
        for(Canzone c : canzoni){
            System.out.println("Canzone{" + "id=" + c.getId() + ", titolo=" + c.getTitolo() + ", categoria=" + c.getCategoria() + ", incipit=" + c.getIncipit() + ", cantato=" + c.isCantato() + ", voti=" + c.getVoti() + '}');
        }
    }
    
    private static List<Canzone> trovaTutte(){
        SanremoEJBService service = new SanremoEJBService();
        SanremoEJB port = service.getSanremoEJBPort();
        
        return port.printAll();
    }
}
