/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookejbclient;

import book.Book;
import book.BookEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author giovanni
 */
public class BookEJBClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context jndiContext = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote) jndiContext.lookup("java:global/BookEJB/BookEJB!book.BookEJBRemote");
        List<Book> books = bookEJB.findBooks();
        for(Book b : books)
        {
               System.out.println(b.toString());
        }
     }
    
}
