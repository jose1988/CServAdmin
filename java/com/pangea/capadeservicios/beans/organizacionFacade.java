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
     public void editarOrganizacion(organizacion Registro) {        
        
        if(Registro.getIdOrganizacionPadre()!=null){
            Query q = em.createNativeQuery("UPDATE organizacion "
                + "SET borrado=?,ciudad=?,descripcion=?,direccion=?,estado=?,fax=?,id_organizacion_padre=?,mail=?,nombre=?,telefono=?,tipo=?"
                + " WHERE id=?");
            q.setParameter(1, Registro.getBorrado());
            q.setParameter(2, Registro.getCiudad());
            q.setParameter(3, Registro.getDescripcion());
            q.setParameter(4, Registro.getDireccion());
            q.setParameter(5, Registro.getEstado());
            q.setParameter(6, Registro.getFax());
            q.setParameter(7, Registro.getIdOrganizacionPadre().getId());
            q.setParameter(8, Registro.getMail());
            q.setParameter(9, Registro.getNombre());
            q.setParameter(10, Registro.getTelefono());
            q.setParameter(11, Registro.getTipo());
            q.setParameter(12, Registro.getId());
            
            q.executeUpdate();
        }
        
        else{
            Query q = em.createNativeQuery("UPDATE organizacion "
                + "SET borrado=?,ciudad=?,descripcion=?,direccion=?,estado=?,fax=?,mail=?,nombre=?,telefono=?,tipo=?"
                + " WHERE id=?");
            q.setParameter(1, Registro.getBorrado());
            q.setParameter(2, Registro.getCiudad());
            q.setParameter(3, Registro.getDescripcion());
            q.setParameter(4, Registro.getDireccion());
            q.setParameter(5, Registro.getEstado());
            q.setParameter(6, Registro.getFax());
            q.setParameter(7, Registro.getMail());
            q.setParameter(8, Registro.getNombre());
            q.setParameter(9, Registro.getTelefono());
            q.setParameter(10, Registro.getTipo());
            q.setParameter(11, Registro.getId());
            
            q.executeUpdate();
        }        
}
     
    /**
     * Método que elimina la organizacion de manera lógica
     * @param ID
     */
    public void eliminarOrganizacion(Long idOrganizacion){
    
        Query q=em.createNativeQuery("UPDATE organizacion SET borrado='1' WHERE id=?");
        q.setParameter(1, idOrganizacion);
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
    
    /**
     * Método que restaura la organizacion de manera lógica
     * @param ID
     */
    public void restaurarOrganizacion(Long idOrganizacion){
    
        Query q=em.createNativeQuery("UPDATE organizacion SET borrado='0' WHERE id=?");
        q.setParameter(1, idOrganizacion);
        q.executeUpdate();
   }
    
    /**
     * Método que consulta el nombre de la organización para verificar si existe o no
     * @param nombreOrganizacion
     * @return
     */
    public organizacion consultarOrganizacionXnombre(String nombreOrganizacion) {
        
        organizacion Registro;
        Registro = (organizacion) em.createNamedQuery("organizacion.findByNombre").setParameter("nombre", nombreOrganizacion).getSingleResult();
        return Registro;
    }
}
