/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Empleado;
import java.util.Iterator;
import java.util.List;
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
public class EmpleadoEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    public List findAllEmpleados() {
        return emf.createEntityManager().createNamedQuery("Empleado.findAll").getResultList();
    }

    public Empleado findEmpleado(String userName) {
        Query q = emf.createEntityManager().createNamedQuery("Empleado.findByNombreusuario");
        q.setParameter("nombreusuario", userName);
        List<Empleado> result = q.getResultList();
        Iterator iter = result.iterator();
        Empleado empleado = (Empleado) iter.next();
        return empleado;
    }

    public boolean insertarEmpleado(Empleado e) {
        if (existEmpleado(e)) {
            return false;
        }
        EntityManager em = emf.createEntityManager();
        em.persist(e);
        em.close();
        return true;

    }

    public boolean existEmpleado(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado = em.find(Empleado.class, e.getNombreusuario());
        em.close();
        return empleado != null;
    }

    public boolean modificarEmpleado(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado = em.find(Empleado.class, e.getNombreusuario());
        if (empleado != null) {
            empleado.setNombrecompleto(e.getNombrecompleto());
            empleado.setTelefono(e.getTelefono());
            em.persist(empleado);
            em.close();
            return true;
        }
        return false;
    }

    public boolean deleteEmpleado(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado = em.find(Empleado.class, e.getNombreusuario());
        if (empleado != null) {
            em.remove(empleado);
            em.close();
            return true;
        }
        return false;
    }

    public boolean loginEmpleado(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado = em.find(Empleado.class, e.getNombreusuario());
        if (empleado != null) {
            if (empleado.getPassword().equalsIgnoreCase(e.getPassword())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean changePassword(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado = em.find(Empleado.class, e.getNombreusuario());
        if (empleado != null) {
            empleado.setPassword(e.getPassword());
            em.persist(empleado);
            em.close();
            return true;
        }
        return false;
    }
}
