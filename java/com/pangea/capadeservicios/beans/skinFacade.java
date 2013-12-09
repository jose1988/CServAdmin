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
    
     public  List<skin> listarSkin(){
      List<skin> c=null;
      
     c=(List<skin>) em.createNamedQuery("skin.findAll").getResultList();
      return c;
   }
    
     public void insertarSkin(skin registro){
        
    this.create(registro);
         
    } 
     
     public void editarSkin(skin registro){
        
    this.edit(registro);
         
    }
     
   public  void eliminarSkin(String ID){
    
    Query q=em.createNativeQuery("UPDATE skin SET borrado='true' WHERE id=?");
    q.setParameter(1, ID);
    q.executeUpdate();
 
   } 
    
}
