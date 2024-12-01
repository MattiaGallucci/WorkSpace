/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CheckParameter
public class CheckParameterInterceptor {
    @AroundInvoke
    private Object checkParameter(InvocationContext ic) throws Exception{
        int voti = (int) ic.getParameters()[0];
        
        if(voti < 10)
            return null;
        return ic.proceed();
    }
}
