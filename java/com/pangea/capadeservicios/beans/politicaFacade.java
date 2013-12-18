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
    
     public void insertarPolitica(politica registroPolitica){
        
        this.create(registroPolitica);
         
    } 
     
     public void editarPolitica(politica registroPolitica){
        
        this.edit(registroPolitica);
         
    }
     
    public  void eliminarPolitica(Long idPolitica){
    
        Query q=em.createNativeQuery("UPDATE politica SET borrado='1' WHERE id=?");
        q.setParameter(1, idPolitica);
        q.executeUpdate();
 
    }
   
    public List<politica> listarPoliticaByBorrado(boolean borrado){
        
        List<politica> c = null;
        c = (List<politica>) em.createNamedQuery("politica.findByBorrado").setParameter("borrado", borrado).getResultList();
        return c;
    }
    
    public void restaurarPolitica(Long idPolitica){
    
        Query q=em.createNativeQuery("UPDATE politica SET borrado='0' WHERE id=?");
        q.setParameter(1, idPolitica);
        q.executeUpdate();
   }
  
    public politica consultarPoliticaXNombre(String nombrePolitica) {
        
        politica Registro;
        Registro = (politica) em.createNamedQuery("politica.findByNombre").setParameter("nombre", nombrePolitica).getSingleResult();
        return Registro;
    }
}
