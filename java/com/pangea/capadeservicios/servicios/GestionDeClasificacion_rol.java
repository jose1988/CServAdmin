/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.clasificacion_rolFacade;
import com.pangea.capadeservicios.entidades.clasificacion_rol;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */
@WebService(serviceName = "GestionDeClasificacion_rol")
public class GestionDeClasificacion_rol {

    @EJB
    clasificacion_rolFacade clasificacionRolFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "contarClasificacion")
    public int contarClasificacionRol() {
        return clasificacionRolFacade.count();
    }

    @WebMethod(operationName = "listarClasificacionRol")
    public List<clasificacion_rol> listarClasificacionRol(@WebParam(name = "borrado") boolean borrado) {
        return clasificacionRolFacade.listarClasifRol(borrado);
    }

    @WebMethod(operationName = "insertarClasificacionRol")
    public void insertarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registro) {
        clasificacionRolFacade.insertar(registro);
    }

    @WebMethod(operationName = "editarClasificacionRol")
    public void editarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registro) {
        clasificacionRolFacade.editar(registro);
    }

    @WebMethod(operationName = "eliminarClasificacionRol")
    public void eliminarClasificacionRol(@WebParam(name = "idClaRol") String ID) {
        clasificacionRolFacade.eliminar(ID);
    }
    @WebMethod(operationName = "consultarClasifRol")
    public clasificacion_rol consultarClasifRol(@WebParam(name = "idClasifRol") String idClasifRol) {
       return clasificacionRolFacade.consultarClasifRol(Long.parseLong(idClasifRol));
    }
}
