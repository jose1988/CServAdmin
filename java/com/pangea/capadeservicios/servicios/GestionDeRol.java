/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.rolFacade;
import com.pangea.capadeservicios.beans.usuario_grupo_rolFacade;
import com.pangea.capadeservicios.entidades.rol;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */
@WebService(serviceName = "GestionDeRol")
public class GestionDeRol {

    @EJB
    rolFacade rolFacade;
    @EJB
    usuario_grupo_rolFacade usuarioGrupoRolFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "contarRol")
    public int contarRol() {
        return rolFacade.count();
    }

    @WebMethod(operationName = "listarRol")
    public List<rol> listarRol(@WebParam(name = "borrado") boolean borrado) {
        return rolFacade.listarRol(borrado);
    }

    @WebMethod(operationName = "insertarRol")
    public void insertarRol(@WebParam(name = "registroRol") rol registroRol) {
        rolFacade.insertar(registroRol);
    }

    @WebMethod(operationName = "editarRol")
    public void editarRol(@WebParam(name = "registroRol") rol registroRol) {
        rolFacade.editar(registroRol);
    }

    @WebMethod(operationName = "eliminarRol")
    public void eliminarRol(@WebParam(name = "idRol") String idRol) {
        rolFacade.eliminar(idRol);
    }

    @WebMethod(operationName = "restaurarRol")
    public void restaurarRol(@WebParam(name = "idRol") String idRol) {
        rolFacade.restaurar(idRol);
    }

    @WebMethod(operationName = "consultarRol")
    public rol consultarRol(@WebParam(name = "idRol") String idRol) {
        rol Resultado;
        try {
            Resultado = rolFacade.consultarRol(Long.parseLong(idRol));
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;
    }

    @WebMethod(operationName = "consultarRolXNombre")
    public rol consultarRolXNombre(@WebParam(name = "nombreRol") String nombreRol) {
        rol Resultado;
        try {
            Resultado = rolFacade.consultarRolXnombre(nombreRol);
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;

    }
    
    @WebMethod(operationName = "consultarDependenciasRol")
    public int consultarDependenciasRol(@WebParam(name = "idRol") String idRol) {
        int Resultado = 0;
        rol registroRol;
        try {
            registroRol = rolFacade.consultarRol(Long.parseLong(idRol));
            Resultado = registroRol.getDestinatarioCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = registroRol.getReporterolCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = registroRol.getTarearolCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = registroRol.getUsuariogruporolCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }

        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
}
