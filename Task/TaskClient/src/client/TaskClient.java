/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.Task;
import server.TaskEJBRemote;

/**
 *
 * @author CORSO_PD
 */
public class TaskClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        TaskEJBRemote ejb = (TaskEJBRemote) ctx.lookup("java:global/TaskEJB/TaskEJB!server.TaskEJBRemote");
        
        stampaTasks("tutti i tasks", ejb.findAll());
        stampaTasks("task senza assegnatario", ejb.findByAssegnatario("nessuno"));
    }
    
    private static void stampaTasks(String titolo, List<Task> lista) {
        System.out.println("***" + titolo + "***");
        lista.forEach(System.out::println);
    }
    
}
