/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author giovanni
 */
@Remote
public interface LibroEJBRemote {
    
 public void creaLibro(Libro lib);
 public void cancellaLibro(Libro lib);
 public void aggiornaLibro(Libro lib);
 public List<Libro> dammiLibri();
    
}
