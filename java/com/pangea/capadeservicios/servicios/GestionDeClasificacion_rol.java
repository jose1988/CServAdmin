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
    clasificacion_rolFacade clasificacion_rol_Facadee;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "contarClasificacion")
    public int contarClasificacionRol() {
        return clasificacion_rol_Facadee.count();
    }

    @WebMethod(operationName = "listarClasificacionRol")
    public List<clasificacion_rol> listarClasificacionRol() {
        return clasificacion_rol_Facadee.listar();
    }

    @WebMethod(operationName = "insertarClasificacionRol")
    public void insertarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registro) {
        clasificacion_rol_Facadee.insertar(registro);
    }

    @WebMethod(operationName = "editarClasificacionRol")
    public void editarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registro) {
        clasificacion_rol_Facadee.editar(registro);
    }

    @WebMethod(operationName = "eliminarClasificacionRol")
    public void eliminarClasificacionRol(@WebParam(name = "idClaRol") String ID) {
        clasificacion_rol_Facadee.eliminar(ID);
    }
}
