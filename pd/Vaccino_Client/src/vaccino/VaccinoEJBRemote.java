/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface VaccinoEJBRemote {
   public void creaIndividuo(Individuo i);
   public void aggiornaIndividuo(Individuo i);
   public void eliminaIndividuo(Individuo i);
   
   public List<Individuo> trovaTutti();
   public Individuo trovaPerId(int id);
   public List<Individuo> trovaPerCategoria(Categoria c);
   public List<Individuo> trovaPerEta(int e);
   public List<Individuo> trovaPerCovidContratto(boolean b);
   public List<Individuo> trovaPerCategoriaEta(Categoria c, int e);
   public List<Individuo> trovaPerCategoriaInteresse(Categoria c, boolean i);
}
