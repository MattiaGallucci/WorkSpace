/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viaggi_ws_client;

import java.util.List;
import viaggi.Viaggio;
import viaggi.ViaggioEJB;
import viaggi.ViaggioEJBService;

/**
 *
 * @author matti
 */
public class Viaggi_WS_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Viaggio> viaggi = trovaTutti();
        
        for(Viaggio v : viaggi){
            if(v.getDisponibilita()>0)
                System.out.println(v.getId());
        }
    }
    
    private static List<Viaggio> trovaTutti(){
        ViaggioEJBService service = new ViaggioEJBService();
        ViaggioEJB port = service.getViaggioEJBPort();
        
        return port.trovaTutti();
    }
    
}
