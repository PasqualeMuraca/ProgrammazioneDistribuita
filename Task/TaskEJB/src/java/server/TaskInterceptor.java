/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author CORSO_PD
 */
@Interceptor
public class TaskInterceptor {

    private static int contatore = 0;

    @AroundInvoke
    public Object interceptor(InvocationContext ic) throws Exception {
        contatore++;
        System.out.println("findAll e' stato invocato " + contatore + " volte");
        return ic.proceed();
    }
}
