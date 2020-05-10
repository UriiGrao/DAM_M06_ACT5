/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Historial;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author uriishii
 */
@Stateless
public class HistorialEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    public List findAllEventos() {
        return emf.createEntityManager().createNamedQuery("Historial.findAll").getResultList();
    }

    public Map findAllEventosGroping() {
        List<Historial> eventos = emf.createEntityManager().createNamedQuery("Historial.findAll").getResultList();
        Map<String, Integer> empleadosRanking = new HashMap<String, Integer>();
        for (Historial evento : eventos) {
            String userName = evento.getEmpleado().getNombreusuario();
            if (empleadosRanking.containsKey(userName)) {
                int valor = empleadosRanking.get(userName).intValue();
                empleadosRanking.put(userName, valor + 1);
            } else {
                empleadosRanking.put(evento.getEmpleado().getNombreusuario(), 1);
            }
        }
        return empleadosRanking;
    }
}
