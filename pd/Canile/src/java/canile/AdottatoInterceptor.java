/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canile;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Adottato
public class AdottatoInterceptor {
    private int id;
    
    @Inject
    private EntityManager em;
    
    @AroundInvoke
    public Object verificaAdozione(InvocationContext ic) throws Exception{
        id = (int) ic.getParameters()[0];
        
        Cane c = em.find(Cane.class, id);
        
        if(c.isAdottato()){
            System.out.println("L'operazione non è andata a buon fine");
            return null;
        }
        
        return ic.proceed();
    }
}
