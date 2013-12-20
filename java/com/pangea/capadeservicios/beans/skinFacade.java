/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.skin;
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
public class skinFacade extends AbstractFacade<skin> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public skinFacade() {
        super(skin.class);
    }

    public List<skin> listarSkin() {
        
        List<skin> c = null;
        c = (List<skin>) em.createNamedQuery("skin.findAll").getResultList();
        return c;
    }

    public List<skin> listarSkinXBorrado(boolean borrado) {
        
        List<skin> listaSkin = null;
        listaSkin = (List<skin>) em.createNamedQuery("skin.findByBorrado").setParameter("borrado", borrado).getResultList();
        return listaSkin;
    }

    public void insertarSkin(skin registro) {

        this.create(registro);
    }

    public void editarSkin(skin Registro) {
        Query q = em.createNativeQuery("UPDATE skin SET borrado=?,nombre=? WHERE id=?");
        q.setParameter(1, Registro.getBorrado());
        q.setParameter(2, Registro.getNombre());
        q.setParameter(3, Registro.getId());
        q.executeUpdate();
    }

    public void eliminarSkin(Long idSkin) {

        Query q = em.createNativeQuery("UPDATE skin SET borrado='1' WHERE id=?");
        q.setParameter(1, idSkin);
        q.executeUpdate();
    }
    
    public void restaurarSkin(Long idSkin) {

        Query q = em.createNativeQuery("UPDATE skin SET borrado='0' WHERE id=?");
        q.setParameter(1, idSkin);
        q.executeUpdate();
    }

    public skin consultarSkinXNombre(String nombreSkin) {

        skin Registro;
        Registro = (skin) em.createNamedQuery("skin.findByNombre").setParameter("nombre", nombreSkin).getSingleResult();
        return Registro;
    }
}
