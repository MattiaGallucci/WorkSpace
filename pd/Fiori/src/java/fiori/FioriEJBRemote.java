/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FioriEJBRemote {
    public void crea(Fiore f);
    public void elimina(Fiore f);
    public void aggiorna(Fiore f);
    public Fiore trovaPerId(int id);
    
    public List<Fiore> trovaTutti();
    public List<Fiore> trovaPerCiclo(String ciclo);
    public List<Fiore> trovaPerUso(String uso);
    public List<Fiore> trovaPerProprieta(String proprieta);
}