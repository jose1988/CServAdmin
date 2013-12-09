/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.rol;
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
public class rolFacade extends AbstractFacade<rol> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public rolFacade() {
        super(rol.class);
    }

    public List<rol> listar() {
        List<rol> c = null;
        c = (List<rol>) em.createNamedQuery("rol.findAll").getResultList();
        return c;
    }

    public void insertar(rol registro) {
        this.create(registro);
    }

    public void editar(rol registro) {
        this.edit(registro);
    }

    public void eliminar(String ID) {
        Query q = em.createNativeQuery("UPDATE rol SET borrado='true' WHERE id=?");
        q.setParameter(1, ID);
        q.executeUpdate();
    }
}
