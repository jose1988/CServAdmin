/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.clasificacion_usuario;
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
public class clasificacion_usuarioFacade extends AbstractFacade<clasificacion_usuario> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public clasificacion_usuarioFacade() {
        super(clasificacion_usuario.class);
    }
   
      public  List<clasificacion_usuario> listaclasificacion_usuario(){
      
    List<clasificacion_usuario> c=null;
    c= em.createNamedQuery("clasificacion_usuario.findAll").getResultList();
    return c;
    
   }
    
     public void insertarclasificacion_usuario(clasificacion_usuario registro){
        
    this.create(registro);
         
    } 
     
     public void editarclasificacion_usuario(clasificacion_usuario registro){
        
    this.edit(registro);
         
    }
     
   public  void eliminarclasificacion_usuario(String ID){
    
    Query q=em.createNativeQuery("UPDATE clasificacion_usuario SET borrado='true' WHERE id=?");
    q.setParameter(1, ID);
    q.executeUpdate();
 
   }  
    
    
    
}
