/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpcm;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DpcmEJBRemote{
    public void crea(Dpcm d);
    public void aggiorna(Dpcm d);
    public void elimina(Dpcm d);

    public List<Dpcm> trovaTutti();
    public Dpcm trovaPerId(int id);
    public List<Dpcm> trovaPerEmergenza(String emergenza);
    public List<Dpcm> trovaPerTipo(String tipo);
    public List<Dpcm> trovaPerStampa(int stampa);
}
