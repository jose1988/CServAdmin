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

    @WebMethod(operationName = "consultarDependenciasUsuario")
    public int consultarDependenciasUsuario(@WebParam(name = "idUsuario") String idUsuario) {
        int Resultado = 0;
        usuario Usuario;
        try {
            Usuario = usuarioFacade.consultarUsuario(idUsuario);
            Resultado = Usuario.getActividadOrigenCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getActividadUsuarioCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getBandejaCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getDestinatarioCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getHorarioCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getInstanciaCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getMensajeCollection().size();
            if (Resultado > 0) {
               return Resultado;
            }
            Resultado = Usuario.getPoliticaroundrobinCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getPostCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getPostenbandejaCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getSesionCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = Usuario.getUsuariogruporolCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
}
