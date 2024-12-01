/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canile;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
    private HashMap<String, Integer> hm = new HashMap<>();
    private int maxCount=0;
    private String maxMethod = null;
    
    private String metodo = null;
    
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception{
        metodo = ic.getMethod().getName();
        
        if(!(hm.containsKey(metodo)))
            hm.put(metodo, 1);
        else
            hm.put(metodo, (hm.get(metodo)) + 1);
        
        if(hm.get(metodo) > maxCount){
            maxCount = hm.get(metodo);
            maxMethod = metodo;
        }
        
        try{
            return ic.proceed();
        } finally{
            System.out.println("Invocato metodo " + metodo +", numero invocazioni " + hm.get(metodo) + ". Metodo con massimo numero di invocazioni " + maxMethod + ", numero invocazioni massime " + maxCount);
        }
    }
}
