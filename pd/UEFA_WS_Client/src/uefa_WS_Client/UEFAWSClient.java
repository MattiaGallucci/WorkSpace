/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa_WS_Client;

import java.util.List;
import uefa.Partita;
import uefa.PartitaEJB;
import uefa.PartitaEJBService;


public class UEFAWSClient {
    public static void main(String[] args) {
        System.out.println(trovaTutte());
    }
    
    private static List<Partita> trovaTutte() {
        PartitaEJBService service = new PartitaEJBService();
        PartitaEJB port = service.getPartitaEJBPort();
        return port.trovaPartite();
    }
}
