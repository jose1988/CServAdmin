/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.reporte;
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
public class reporteFacade extends AbstractFacade<reporte> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public reporteFacade() {
        super(reporte.class);
    }
    
    /**
     * Método que lista los reportes que estan almacenados
     * @return lista de tipo reporte
     */
    public List<reporte> listarReporte(){
        
        List<reporte> c=null;      
        c=(List<reporte>) em.createNamedQuery("reporte.findAll").getResultList();
        return c;
   }
    
    /**
     * Método que inserta el reporte
     * @param registro
     */
    public void insertarReporte(reporte registro){
        
        this.create(registro);         
    } 
     
    /**
     * Método que edita el reporte
     * @param registro
     */
    public void editarReporte(reporte registro){
        
        this.edit(registro);         
    }
     
    /**
     * Método que elimina el reporte de manera lógica
     * @param ID
     */
    public void eliminarReporte(Long idReporte){
    
        Query q=em.createNativeQuery("UPDATE reporte SET borrado='1' WHERE id=?");
        q.setParameter(1, idReporte);
        q.executeUpdate();
   }
    
    /**
     * Método que lista los reportes dependiendo del estado
     * @param borrado 1 si el borrado es FALSE y 1 si es TRUE
     * @return lista de tipo reporte
     */
    public List<reporte> listarReporteByBorrado(boolean borrado){
        List<reporte> c = null;
        c = (List<reporte>) em.createNamedQuery("reporte.findByBorrado").setParameter("borrado", borrado).getResultList();
        return c;
    }
    
    /**
     * Método que restaura el reporte de manera lógica
     * @param ID
     */
    public void restaurarReporte(Long idReporte){
    
        Query q=em.createNativeQuery("UPDATE reporte SET borrado='0' WHERE id=?");
        q.setParameter(1, idReporte);
        q.executeUpdate();
   }
    
    /**
     * Método que consulta el nombre del reporte para verificar si existe o no
     * @param nombreReporte
     * @return
     */
    public reporte consultarReporteXnombre(String nombreReporte) {
        
        reporte Registro;
        Registro = (reporte) em.createNamedQuery("reporte.findByNombre").setParameter("nombre", nombreReporte).getSingleResult();
        return Registro;
    }
}
