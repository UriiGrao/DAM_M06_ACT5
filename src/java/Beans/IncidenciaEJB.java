/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Empleado;
import Model.Incidencia;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author uriishii
 */
@Stateless
public class IncidenciaEJB {

    @EJB
    EmpleadoEJB empleadoEJB;
    @PersistenceUnit
    EntityManagerFactory emf;

    public List findAllIncidencias() {
        return emf.createEntityManager().createNamedQuery("Incidencia.findAll").getResultList();
    }

    public Incidencia findIncidenciaByID(String idString) {
        int idInci = Integer.parseInt(idString);
        Query q = emf.createEntityManager().createNamedQuery("Incidencia.findByIdincidencia");
        q.setParameter("idincidencia", idInci);
        List<Incidencia> result = q.getResultList();
        Iterator iter = result.iterator();
        return (Incidencia) iter.next();
    }

    public void createIncidencia(Incidencia incidencia) {
        EntityManager em = emf.createEntityManager();
        em.persist(incidencia);
        em.close();
    }

    public List findIncidenciaByOrigen(String userNameOrigen) {
        Empleado empleado = empleadoEJB.findEmpleado(userNameOrigen);
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT i FROM incidencia i WHERE i.origen = :origen");
        q.setParameter("origen", empleado);
        List incidencias = q.getResultList();
        return incidencias;
    }
}
