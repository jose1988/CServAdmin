/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.grupo;
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
public class grupoFacade extends AbstractFacade<grupo> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public grupoFacade() {
        super(grupo.class);
    }
    
     /** 
     * Método que lista los grupos almacenados y los ordena por nombre
     * @return lista de tipo grupo
     */
    public List<grupo> listarGrupos(){
        
        List<grupo> lista;
        lista=em.createNamedQuery("grupo.findAll").getResultList();
        return lista;
    }
    
    /**
     * Método que inserta el grupo
     * @param registro
     */
    public void insertarGrupo(grupo registro){
        
        this.create(registro);         
    } 
     
    /**
     * Método que edita el grupo
     * @param registro
     */
    public void editarGrupo(grupo registro){
        
        this.edit(registro);         
    }
     
    /**
     * Método que elimina el grupo de manera lógica
     * @param ID
     */
    public void eliminarGrupo(String ID){
    
        Query q=em.createNativeQuery("UPDATE grupo SET borrado='true' WHERE id=?");
        q.setParameter(1, ID);
        q.executeUpdate();
   }   
}