/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.organizacion;
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
public class organizacionFacade extends AbstractFacade<organizacion> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public organizacionFacade() {
        super(organizacion.class);
    }
    
    /**
     * Método que lista las organizaciones que estan almacenadas
     * @return lista de tipo organizacion
     */
    public List<organizacion> listarOrganizacion(){
        
        List<organizacion> c=null;      
        c=(List<organizacion>) em.createNamedQuery("organizacion.findAll").getResultList();
        return c;
   }
    
    /**
     * Método que inserta la organizacion
     * @param registro
     */
    public void insertarOrganizacion(organizacion registro){
        
        this.create(registro);         
    } 
     
    /**
     * Método que edita la organizacion
     * @param registro
     */
    public void editarOrganizacion(organizacion registro){
        
        this.edit(registro);         
    }
     
    /**
     * Método que elimina la organizacion de manera lógica
     * @param ID
     */
    public void eliminarOrganizacion(String ID){
    
        Query q=em.createNativeQuery("UPDATE organizacion SET borrado='true' WHERE id=?");
        q.setParameter(1, ID);
        q.executeUpdate();
   }
    
    /**
     * Método que lista las organizaciones dependiendo del estado
     * @param borrado 1 si el borrado es FALSE y 1 si es TRUE
     * @return lista de tipo organizacion
     */
    public List<organizacion> listarOrganizacionByBorrado(boolean borrado){
        List<organizacion> c = null;
        c = (List<organizacion>) em.createNamedQuery("organizacion.findByBorrado").setParameter("borrado", borrado).getResultList();
        return c;
    }
}
