/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viaggi;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ViaggioEJBRemote {
    public void crea(Viaggio v);
    public void aggiorna(Viaggio v);
    public void elimina(Viaggio v);
    
    public Viaggio trovaPerId(int id);
    public List<Viaggio> trovaTutti();
    public List<Viaggio> trovaPerDestinazione(String d);
    public List<Viaggio> trovaPerCategoria(String c);
    public List<Viaggio> trovaPerPrezzo(int p);
}
