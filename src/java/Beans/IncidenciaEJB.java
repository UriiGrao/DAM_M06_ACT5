/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Incidencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author uriishii
 */
@Stateless
public class IncidenciaEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    public List findAllIncidencias() {
        return emf.createEntityManager().createNamedQuery("Incidencia.findAll").getResultList();
    }
    
//    public Incidencia findIncidenciaByID() {
//        // return emf.createEntityManager().createNamedQuery("Incidencia.findByIdincidencia").getResultList();
//    }
}
