/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.clasificacion_usuarioFacade;
import com.pangea.capadeservicios.entidades.clasificacion_usuario;

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
@WebService(serviceName = "GestionDeClasificacion_usuario")
public class GestionDeClasificacion_usuario {
    
    @EJB
    clasificacion_usuarioFacade clasificacion_usuarioFacade;
    
    @WebMethod(operationName = "listar")
    public List<clasificacion_usuario> listar() {
        return clasificacion_usuarioFacade.listaclasificacion_usuario();
    }
    
    @WebMethod(operationName = "insertarClasificacionUsuario")
    public void insertarClasificacionUsuario(@WebParam(name = "registroClaUsuario") clasificacion_usuario registroClaUsuario) {
        
        clasificacion_usuarioFacade.insertarclasificacion_usuario(registroClaUsuario);
    }
    
    @WebMethod(operationName = "editarClasificacionUsuario")
    public void editarClasificacionUsuario(@WebParam(name = "registroClaUsuario") clasificacion_usuario registroClaUsuario) {
        
        clasificacion_usuarioFacade.editarclasificacion_usuario(registroClaUsuario);
    }
    
    @WebMethod(operationName = "eliminarClasificacionUsuario")
    public void eliminarClasificacionUsuario(@WebParam(name = "idClaUsuario") String idClaUsuario) {
        
        clasificacion_usuarioFacade.eliminarclasificacion_usuario(idClaUsuario);
    }
    
    @WebMethod(operationName = "consultarClasificacionUsuario")
    public clasificacion_usuario consultarClasificacionUsuario(@WebParam(name = "idClaUsu") String idClaUsu) {
        return clasificacion_usuarioFacade.find(Long.parseLong(idClaUsu));
    }
    
    @WebMethod(operationName = "contarClasificacion_usuario")
    public int contarClasificacion_usuario() {
        
        return clasificacion_usuarioFacade.count();
    }
    
    @WebMethod(operationName = "listarClasificacionUsuario")
    public List<clasificacion_usuario> listarClasificacionUsuario(@WebParam(name = "borrado") boolean borrado) {
        return clasificacion_usuarioFacade.listarClasificacion(borrado);
    }
    @WebMethod(operationName = "consultarClasifUsuarioXNombre")
    public clasificacion_usuario consultarClasifUsuarioXNombre(@WebParam(name = "Nombre") String Nombre) {
        clasificacion_usuario Resultado;
        try {
            Resultado = clasificacion_usuarioFacade.consultarClasifUsuarioXnombre(Nombre);
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;

    }
}
