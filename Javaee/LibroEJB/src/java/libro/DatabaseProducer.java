/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author giovanni
 */
public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName="LibroEJBPU")
    private EntityManager em;
    
}