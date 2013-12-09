/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.organizacionFacade;
import com.pangea.capadeservicios.entidades.organizacion;
import java.math.BigDecimal;
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
     * @return número entero con la cantidad de organizaciones
     */
    @WebMethod(operationName = "contarOrganizacion")
    public int contarOrganizacion() {
 
     return organizacionFacade.count();
    } 
    
    /**
     * Método que lista las organizaciones almacenadas
     * @return lista de tipo organizacion
     */
    @WebMethod(operationName = "listarOrganizacion")
    public  List<organizacion> listarOrganizacion() {
        return organizacionFacade.listarOrganizacion();
    }
    
    /**
     * Método que inserta la organizacion
     * @param registro
     */
    @WebMethod(operationName = "insertarOrganizacion")
    public void insertarOrganizacion(@WebParam(name = "registroOrganizacion") organizacion registroOrganizacion) {
 
      organizacionFacade.insertarOrganizacion(registroOrganizacion);
    }
    
    /**
     * Método que edita la organizacion
     * @param registro
     */
    @WebMethod(operationName = "editarOrganizacion")
    public void editarOrganizacion(@WebParam(name = "registroOrganizacion") organizacion registroOrganizacion) {
 
      organizacionFacade.editarOrganizacion(registroOrganizacion);
    }
    
    /**
     * Método que elimina la organizacion de manera lógica
     * @param ID
     */
    @WebMethod(operationName = "eliminarOrganizacion")
    public void eliminarOrganizacion(@WebParam(name = "idOrganizacion") String idOrganizacion) {
 
      organizacionFacade.eliminarOrganizacion(idOrganizacion);
    }
    
    /**
     * Método que busca la organizacion
     * @param ID
     */
    @WebMethod(operationName = "buscarOrganizacion")
    public organizacion buscarOrganizacion(@WebParam(name = "idOrganizacion") String idOrganizacion)  {

        try {
            organizacion find = organizacionFacade.find(new BigDecimal(idOrganizacion));
            return find;
        } catch (Exception ex) {
            return null;
        }
    }
}
