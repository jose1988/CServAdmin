/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.proceso;
import com.pangea.capadeservicios.entidades.tarea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pangea
 */
@Stateless
public class tareaFacade extends AbstractFacade<tarea> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public tareaFacade() {
        super(tarea.class);
    }

    public List<tarea> listarTareasXProceso(proceso idProceso) {
        List<tarea> lista;
        Query lis = em.createNamedQuery("tarea.findByProceso").setParameter("idProceso", idProceso);
        lista = lis.getResultList();
        return lista;
    }
}
