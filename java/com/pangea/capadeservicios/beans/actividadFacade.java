/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.actividad;
import com.pangea.capadeservicios.entidades.instancia;
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
public class actividadFacade extends AbstractFacade<actividad> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public actividadFacade() {
        super(actividad.class);
    }

    public List<String> buscarestados() {
        List<String> c;
        Query q = em.createNamedQuery("actividad.findEstados");
        c = q.getResultList();
        return c;
    }

    /**
     * Método que lista las actividades que tienenestado pendiente y no han sido
     * borradas
     */
    public List<actividad> listarActividades(String estado, boolean borrado) {
        List<actividad> lista;
        Query lis = em.createNamedQuery("actividad.findEstadoYBorrado").setParameter("borrado", borrado).setParameter("estado", estado);
        lista = lis.getResultList();
        return lista;
    }

    public actividad buscarActividadXTareaEInstancia(instancia idInstancia, tarea idTarea) {
        actividad Registro;
        Query Resultado = em.createNamedQuery("actividad.findByInstanciaYTarea").setParameter("idInstancia", idInstancia).setParameter("idTarea", idTarea);
        Registro = (actividad) Resultado.getSingleResult();
        return Registro;
    }
}
