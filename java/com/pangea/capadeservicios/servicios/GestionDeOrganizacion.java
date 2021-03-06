/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.organizacionFacade;
import com.pangea.capadeservicios.entidades.organizacion;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */
@WebService(serviceName = "GestionDeOrganizacion")
public class GestionDeOrganizacion {

    @EJB
    organizacionFacade organizacionFacade;

    /**
     * Método que cuenta las organizaciones que estan almacenadas
     *
     * @return número entero con la cantidad de organizaciones
     */
    @WebMethod(operationName = "contarOrganizacion")
    public int contarOrganizacion() {

        return organizacionFacade.count();
    }

    /**
     * Método que lista las organizaciones almacenadas
     *
     * @return lista de tipo organizacion
     */
    @WebMethod(operationName = "listarOrganizacion")
    public List<organizacion> listarOrganizacion() {
        return organizacionFacade.listarOrganizacion();
    }

    /**
     * Método que inserta la organizacion
     *
     * @param registro
     */
    @WebMethod(operationName = "insertarOrganizacion")
    public void insertarOrganizacion(@WebParam(name = "registroOrganizacion") organizacion registroOrganizacion) {

        organizacionFacade.insertarOrganizacion(registroOrganizacion);
    }

    /**
     * Método que edita la organizacion
     *
     * @param registro
     */
    @WebMethod(operationName = "editarOrganizacion")
    public void editarOrganizacion(@WebParam(name = "registroOrganizacion") organizacion registroOrganizacion) {

        organizacionFacade.editarOrganizacion(registroOrganizacion);
    }

    /**
     * Método que elimina la organizacion de manera lógica
     *
     * @param ID
     */
    @WebMethod(operationName = "eliminarOrganizacion")
    public void eliminarOrganizacion(@WebParam(name = "idOrganizacion") String idOrganizacion) {

        organizacionFacade.eliminarOrganizacion(new Long(idOrganizacion));
    }

    /**
     * Método que busca la organizacion
     *
     * @param ID
     */
    @WebMethod(operationName = "buscarOrganizacion")
    public organizacion buscarOrganizacion(@WebParam(name = "idOrganizacion") String idOrganizacion) {

        try {
            organizacion find = organizacionFacade.find(new Long(idOrganizacion));
            return find;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Método que lista las organizaciones dependiendo del estado
     *
     * @param borrado 1 si el borrado es FALSE y 1 si es TRUE
     * @return lista de tipo organizacion
     */
    @WebMethod(operationName = "listarOrganizacionByBorrado")
    public List<organizacion> listarOrganizacionByBorrado(@WebParam(name = "borrado") boolean borrado) {
        List<organizacion> listaOrganizacion;
        try {
            listaOrganizacion = organizacionFacade.listarOrganizacionByBorrado(borrado);
        } catch (Exception e) {
            listaOrganizacion = null;
        }
        return listaOrganizacion;
    }

    /**
     * Método que restaura la organizacion de manera lógica
     *
     * @param ID
     */
    @WebMethod(operationName = "restaurarOrganizacion")
    public void restaurarOrganizacion(@WebParam(name = "idOrganizacion") String idOrganizacion) {

        organizacionFacade.restaurarOrganizacion(new Long(idOrganizacion));
    }
    
    /**
     * Método que consulta el nombre de la organización para verificar si existe o no
     * @param nombreOrganizacion
     * @return
     */
    @WebMethod(operationName = "consultarOrganizacionXNombre")
    public organizacion consultarOrganizacionXNombre(@WebParam(name = "nombreOrganizacion") String nombreOrganizacion) {
        
        organizacion Resultado;
        try {
          Resultado= organizacionFacade.consultarOrganizacionXnombre(nombreOrganizacion);
        } catch (Exception e) {
            Resultado=null;
        }
        return Resultado;
    }    
    
    /**
     * Método que consulta las dependencias de la entidad organización, es decir si
     * dicho dato es usado en alguna otra entidad
     * @param idOrganizacion dato que se desea eliminar
     * @return valor entero en el caso que no sea usado por otra entidad
     */
    @WebMethod(operationName = "consultarDependenciasOrganizacion")
    public int consultarDependenciasOrganizacion(@WebParam(name = "idOrganizacion") String idOrganizacion) {
        int Resultado = 0;
        organizacion registroOrganizacion;
        
        try {
            registroOrganizacion = organizacionFacade.find(Long.parseLong(idOrganizacion));
            
            Resultado = registroOrganizacion.getGrupoCollection().size();            
            if (Resultado > 0) {
                return Resultado;
            }
            
            Resultado = registroOrganizacion.getOrganizacionCollection().size();            
            if (Resultado > 0) {
                return Resultado;
            }
            
            Resultado = registroOrganizacion.getUsuarioCollection().size();            
            if (Resultado > 0) {
                return Resultado;
            }
            
        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
}
