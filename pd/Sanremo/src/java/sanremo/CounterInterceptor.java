/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
    private int c = 0;
    
    @AroundInvoke
    private Object count(InvocationContext ic) throws Exception{
        String metodo = ic.getMethod().getName();
        
        if(!(metodo.equals("printByVotes"))){
            c++;
            System.out.println("Chiamata n." + c + ": metodo " + metodo);
            return ic.proceed();
        }
        return null;
    }
}
