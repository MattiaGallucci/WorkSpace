/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sanremo;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface SanremoEJBRemote {
    public void crea(Canzone c);
    public void aggiorna(Canzone c);
    public void elimina(Canzone c);
    
    public List<Canzone> printAll();
    public Canzone printById(int id);
    public List<Canzone> printByCategory(String categoria);
    public List<Canzone> printByVotes(int voti);
}
