/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.clasificacion_rol;
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
public class clasificacion_rolFacade extends AbstractFacade<clasificacion_rol> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public clasificacion_rolFacade() {
        super(clasificacion_rol.class);
    }

    public List<clasificacion_rol> listarClasifRol(boolean borrado) {
        List<clasificacion_rol> c = null;
        c = (List<clasificacion_rol>) em.createNamedQuery("clasificacion_rol.findByBorrado").setParameter("borrado",borrado).getResultList();
        return c;
    }

    public void insertar(clasificacion_rol registro) {
        this.create(registro);
    }

    public void editar(clasificacion_rol registro) {
        this.edit(registro);
    }

    public void eliminar(String ID) {
        Query q = em.createNativeQuery("UPDATE clasificacion_rol SET borrado='true' WHERE id=?");
        q.setParameter(1, ID);
        q.executeUpdate();
    }
       public clasificacion_rol consultarClasifRol(long idClasifRol) {
        clasificacion_rol Registro;
        Registro=this.find(idClasifRol);
        return Registro;
    }
}
