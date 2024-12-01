/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package canile;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CanileEJBRemote {
    void creaCane(Cane c);
    void aggironaCane(Cane c);
    void eliminaCane(Cane c);
    
    List<Cane> trovaTutti();
    List<Cane> trovaPerId(int id);
    List<Cane> trovaPerRazza(String razza);
    List<Cane> trovaPerNome(String nome);
    List<Cane> trovaPerTaglia(Taglia taglia);
    List<Cane> trovaPerStatusAdozione(boolean adottato);
    List<Cane> trovaPiccoli8Anni();
    
    void adotta(int id);
}