/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author giovanni
 */
@Singleton
@Startup

public class DatabasePopulator {
    
    @Inject 
    private LibroEJB ejb;

    private Libro libro1 = new Libro();
    private Libro libro2 = new Libro();
    
    @PostConstruct
    private void  populateDB()
    {
        libro1.setNome("Fantasia");
        libro2.setNome("Avventura");
        libro1.setCode(123);
        libro1.setCode(124);
        ejb.creaLibro(libro1);
        ejb.creaLibro(libro2);
    }
    @PreDestroy
    public void clearDB()
    {
      ejb.cancellaLibro(libro1);
      ejb.cancellaLibro(libro2);
    }
    
}
