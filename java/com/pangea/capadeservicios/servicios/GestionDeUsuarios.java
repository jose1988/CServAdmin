/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.usuarioFacade;
import com.pangea.capadeservicios.entidades.clasificacion_usuario;
import com.pangea.capadeservicios.entidades.organizacion;
import com.pangea.capadeservicios.entidades.skin;
import com.pangea.capadeservicios.entidades.usuario;
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
    public void insertarUsuario(@WebParam(name = "registroUsuario") usuario registroUsuario) {
        registroUsuario.setId("20");
        registroUsuario.setFechaActualizacionClave(new Date());
        registroUsuario.setFechaCreacion(new Date());
        registroUsuario.setBorrado(false);
        registroUsuario.setCedula("123");
        registroUsuario.setClave("123");
        registroUsuario.setPrimerNombre("luz");
        registroUsuario.setPrimerApellido("arboleda");
        clasificacion_usuario cla1 = new clasificacion_usuario();
        cla1.setId(Long.parseLong("2"));
        organizacion cla2 = new organizacion();
        cla2.setId(Long.parseLong("2"));
        skin cla3 = new skin();
        cla3.setId(Long.parseLong("2"));
        registroUsuario.setIdClasificacionUsuario(cla1);
        registroUsuario.setIdOrganizacion(cla2);
        registroUsuario.setIdSkin(cla3);


        usuarioFacade.insertar(registroUsuario);
    }

    @WebMethod(operationName = "editarUsuario")
    public void editarUsuario(@WebParam(name = "registroUsuario") usuario registro) {
        usuarioFacade.editar(registro);
    }

    @WebMethod(operationName = "eliminarUsuario")
    public void eliminarUsuario(@WebParam(name = "idUsuario") String idUsuario) {
        usuarioFacade.eliminar(idUsuario);
    }
    
     @WebMethod(operationName = "restaurarUsuario")
    public void restaurarUsuario(@WebParam(name = "idUsuario") String idUsuario) {
        usuarioFacade.restaurar(idUsuario);
    }

    @WebMethod(operationName = "consultarUsuario")
    public usuario consultarUsuario(@WebParam(name = "idUsuario") String idUsuario) {
        usuario Resultado;
        try {
            Resultado = usuarioFacade.consultarUsuario(idUsuario);
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;
    }
}
