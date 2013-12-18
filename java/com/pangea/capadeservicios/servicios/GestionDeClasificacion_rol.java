/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.clasificacion_rolFacade;
import com.pangea.capadeservicios.entidades.clasificacion_rol;
import java.util.Date;
import java.util.List;
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
    public void insertarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registroClaRol) {
        registroClaRol.setFechaCreacion(new Date());
        registroClaRol.setFechaModificacion(new Date());
        clasificacionRolFacade.insertar(registroClaRol);
    }

    @WebMethod(operationName = "editarClasificacionRol")
    public void editarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registroClaRol) {
        clasificacionRolFacade.editar(registroClaRol);
    }

    @WebMethod(operationName = "eliminarClasificacionRol")
    public void eliminarClasificacionRol(@WebParam(name = "idClasifRol") String idClasifRol) {
        clasificacionRolFacade.eliminar(idClasifRol);
    }

    @WebMethod(operationName = "consultarClasifRol")
    public clasificacion_rol consultarClasifRol(@WebParam(name = "idClasifRol") String idClasifRol) {
        clasificacion_rol Resultado;
        try {
            Resultado = clasificacionRolFacade.consultarClasifRol(Long.parseLong(idClasifRol));
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;
    }

    @WebMethod(operationName = "consultarClasifRolXNombre")
    public clasificacion_rol consultarClasifRolXNombre(@WebParam(name = "Nombre") String Nombre) {
        clasificacion_rol Resultado;
        try {
            Resultado = clasificacionRolFacade.consultarClasifRolXnombre(Nombre);
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;

    }
}
