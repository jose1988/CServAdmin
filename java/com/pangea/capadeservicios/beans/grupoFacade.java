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
    public void eliminarGrupo(Long idGrupo){
    
        Query q=em.createNativeQuery("UPDATE grupo SET borrado='1' WHERE id=?");
        q.setParameter(1, idGrupo);
        q.executeUpdate();
   }
    
    /**
     * Método que lista los grupos dependiendo del estado
     * @param borrado 1 si el borrado es FALSE y 1 si es TRUE
     * @return lista de tipo grupo
     */
    public List<grupo> listarGruposByBorrado(boolean borrado){
        List<grupo> c = null;
        c = (List<grupo>) em.createNamedQuery("grupo.findByBorrado").setParameter("borrado", borrado).getResultList();
        return c;
    }
    
    /**
     * Método que restaura el grupo de manera lógica
     * @param ID
     */
    public void restaurarGrupo(Long idGrupo){
    
        Query q=em.createNativeQuery("UPDATE grupo SET borrado='0' WHERE id=?");
        q.setParameter(1, idGrupo);
        q.executeUpdate();
   }
}
