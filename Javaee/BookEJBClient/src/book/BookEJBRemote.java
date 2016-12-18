/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author giovanni
 */
@Remote
public interface BookEJBRemote {
    public List<Book> findBooks();
    public Book createBook(Book book);
    public void deleteBook(Book book);
    public Book updateBook(Book book);
    public Book findBook(long id);
    
}
