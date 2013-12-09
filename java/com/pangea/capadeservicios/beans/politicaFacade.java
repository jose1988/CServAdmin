/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.politica;
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
public class politicaFacade extends AbstractFacade<politica> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public politicaFacade() {
        super(politica.class);
    }
    
    
      public  List<politica> listarPolitica(){
      List<politica> c=null;
      
     c=(List<politica>) em.createNamedQuery("politica.findAll").getResultList();
      return c;
   }
    
     public void insertarPolitica(politica registro){
        
    this.create(registro);
         
    } 
     
     public void editarPolitica(politica registro){
        
    this.edit(registro);
         
    }
     
   public  void eliminarPolitica(String ID){
    
    Query q=em.createNativeQuery("UPDATE politica SET borrado='true' WHERE id=?");
    q.setParameter(1, ID);
    q.executeUpdate();
 
   } 
}
