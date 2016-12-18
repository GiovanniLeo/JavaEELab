/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Utente
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

    @Inject
    private EntityManager em;

    @Override
    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery("findAll", Book.class);
        return query.getResultList();
    }
    
    public Book findBook(long id) {
        TypedQuery<Book> query = em.createNamedQuery("findBookById", Book.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public void deleteBook(Book book) {
        em.remove(em.merge(book));
    }

    @Override
    public Book updateBook(Book book) {
        em.merge(book);
        return book;
    }
}