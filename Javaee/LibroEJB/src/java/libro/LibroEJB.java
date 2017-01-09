/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author giovanni
 */
@Stateless
@LocalBean
public class LibroEJB implements LibroEJBRemote {
    
    @Inject
    private EntityManager em;
    
    
 

    @Override
    public void creaLibro(Libro lib) {
        em.persist(lib);
    }

    @Override
    public void cancellaLibro(Libro lib) {
        em.merge(lib);
        em.remove(lib);
    }

    @Override
    public void aggiornaLibro(Libro lib) {
        em.merge(lib);
    }
    
    public Libro aggiornaLibroPerId(long id,int code)
    {
        TypedQuery<Libro> query = em.createNamedQuery("getLibroById",Libro.class).setParameter("id", id);
        Libro b = query.getSingleResult();
        b.setCode(code);
        aggiornaLibro(b);
        return b;
   }

    @Override
    public List<Libro> dammiLibri() {
        TypedQuery<Libro> query = em.createNamedQuery("findAllBook",Libro.class);
        return query.getResultList();
    }
}
