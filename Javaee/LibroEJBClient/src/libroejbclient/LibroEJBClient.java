/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libroejbclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import libro.Libro;
import libro.LibroEJBRemote;

/**
 *
 * @author giovanni
 */
public class LibroEJBClient {
    
    private static BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
   
    public static void main(String[] args) throws NamingException{
        
        Context jndiContext = new InitialContext();
        LibroEJBRemote libroEJB = (LibroEJBRemote) jndiContext.lookup("java:global/LibroEJB/LibroEJB!libro.LibroEJBRemote");
        Libro b = new Libro();
        
        List<Libro> list = libroEJB.dammiLibri();
        System.out.println("Stampo tutti i libri");
        System.out.println("#########################################");
        for(int i =0 ; i< list.size();i++)
        {
             System.out.println(list.get(i).toString());
             
        }
        System.out.println("#########################################");
        System.out.println("Creo un libro");
        System.out.println("#########################################");
        b.setCode(1234);
        b.setNome("LIB 1");
        libroEJB.creaLibro(b);
        System.out.println("Creato-> "+b.toString());
        System.out.println("#########################################");
        System.out.println("Modifico-> "+b.toString());
        System.out.println("#########################################");
        b.setCode(1235);
        b.setNome("LIB 2");
        libroEJB.aggiornaLibro(b);
        System.out.println("Modificato-> "+b.toString());
        System.out.println("#########################################");
        System.out.println("Rimuovo-> "+b.toString());
        System.out.println("#########################################");
        libroEJB.cancellaLibro(b);
        System.out.println("Rimosso-> "+b.toString());
        System.out.println("#########################################");
        
      
    }
    
}
