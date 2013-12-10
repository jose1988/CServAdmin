/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.usuarioFacade;
import com.pangea.capadeservicios.clienteweb.Usuario;
import com.pangea.capadeservicios.entidades.usuario;
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
@WebService(serviceName = "GestionDeUsuarios")
public class GestionDeUsuarios {

    @EJB
    usuarioFacade usuarioFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Método creado para guardar la información de un usuario por medio del
     * identificador(Id)
     */
    @WebMethod(operationName = "buscarUsuario")
    public usuario buscarUsuario(@WebParam(name = "usuarioActual") usuario usuarioActual) {
        return usuarioFacade.find(usuarioActual.getId());
    }

    @WebMethod(operationName = "contarUsuario")
    public int contarUsuario() {
        return usuarioFacade.count();
    }

    /**
     *
     * @param borradoo
     * @return
     */
    @WebMethod(operationName = "listarUsuarios")
    public List<usuario> listarUsuarios(@WebParam(name = "borradoo") boolean borradoo) {
        return usuarioFacade.listarUsuarios(borradoo);
    }

    @WebMethod(operationName = "insertarUsuario")
    public void insertarUsuario(@WebParam(name = "registroUsuario") usuario registro) {
        usuarioFacade.insertar(registro);
    }

    @WebMethod(operationName = "editarUsuario")
    public void editarUsuario(@WebParam(name = "registroUsuario") usuario registro) {
        usuarioFacade.editar(registro);
    }

    @WebMethod(operationName = "eliminarUsuario")
    public void eliminarUsuario(@WebParam(name = "idUsuario") String ID) {
        usuarioFacade.eliminar(ID);
    }
    @WebMethod(operationName = "consultarUsuario")
    public usuario consultarUsuario(@WebParam(name = "idUsuario") String idUsuario) {
       return usuarioFacade.consultarUsuario(Long.parseLong(idUsuario));
    }
}
