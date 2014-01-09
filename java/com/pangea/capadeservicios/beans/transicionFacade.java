/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.tarea;
import com.pangea.capadeservicios.entidades.transicion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pangea
 */
@Stateless
public class transicionFacade extends AbstractFacade<transicion> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public transicionFacade() {
        super(transicion.class);
    }

    public transicion ConsultarTransicion(tarea idTarea) {
        transicion Registro;
        Query Resultado = em.createNamedQuery("transicion.findByIdTarea").setParameter("idTarea", idTarea);
        Registro = (transicion) Resultado.getSingleResult();
        return Registro;
    }
}
