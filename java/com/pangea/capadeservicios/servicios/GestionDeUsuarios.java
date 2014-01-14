/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.usuarioFacade;
import com.pangea.capadeservicios.entidades.usuario;
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
     * Método creado para guardar la información de un usuario por medio del
     * identificador(Id)
     *
     * @param usuarioActual
     * @return
     */
    @WebMethod(operationName = "buscarUsuario")
    public usuario buscarUsuario(@WebParam(name = "usuarioActual") usuario usuarioActual) {
        return usuarioFacade.find(usuarioActual.getId());
    }

    /**
     * Método que que retorna el número de registros existentes de la entidad
     * usuario
     *
     * @return entero con el número de usuarios
     */
    @WebMethod(operationName = "contarUsuario")
    public int contarUsuario() {
        return usuarioFacade.count();
    }

    /**
     * Método que lista los registros de la entidad usuario de acuerdo a su
     * estado si es borrado o no
     *
     * @param borradoo booleano si es true es borrado si es false es no borrado
     * @return lista de la entidad usuario
     *
     */
    @WebMethod(operationName = "listarUsuarios")
    public List<usuario> listarUsuarios(@WebParam(name = "borradoo") boolean borradoo) {
        return usuarioFacade.listarUsuarios(borradoo);
    }

    /**
     * Método encargado de insertar registros de la entidad usuario
     *
     * @param registroUsuario objeto de la entidad usuario , debe tener como
     * mínimo los campos obligatorios para poder insertar
     */
    @WebMethod(operationName = "insertarUsuario")
    public void insertarUsuario(@WebParam(name = "registroUsuario") usuario registroUsuario) {
        usuarioFacade.insertar(registroUsuario);
    }

    /**
     * Método encargado de editar registros de la entidad usuario
     *
     * @param registroUsuario objeto de la entidad usuario
     */
    @WebMethod(operationName = "editarUsuario")
    public void editarUsuario(@WebParam(name = "registroUsuario") usuario registroUsuario) {
        usuarioFacade.editar(registroUsuario);
    }

    /**
     ** Método encargado de eliminar registros de la entidad rol
     *
     * @param idUsuario objeto de la entidad rol , debe tener el campo id como
     * mínimo
     */
    @WebMethod(operationName = "eliminarUsuario")
    public void eliminarUsuario(@WebParam(name = "idUsuario") String idUsuario) {
        usuarioFacade.eliminar(idUsuario);
    }

    /**
     *
     * Método encargado de cambiar el borrado de registros de la entidad
     * usuario, el borrado cambiara a false
     *
     * @param idUsuario String que contiene el id del usuario a restaurar
     */
    @WebMethod(operationName = "restaurarUsuario")
    public void restaurarUsuario(@WebParam(name = "idUsuario") String idUsuario) {
        usuarioFacade.restaurar(idUsuario);
    }

    /**
     *
     * Método encargado de consultar un registro de usuario de acuerdo a su id
     *
     * @param idUsuario string que contiene el id del usuario a consultar
     * @return objeto de la entidad usuario
     */
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

    /**
     *
     * Método encargado de comprobar si hay dependencias  con
     * respecto al usuario , es decir si el usuario ha sido usado para registros de otras
     * entidades dependientes de usuario,si encuentra alguna dependencia mayor de 0
     * automaticamente quiere decir que no se puede borrar y retorna ese valor
     *
     * @param idUsuario objeto de la entidad usuario
     * @return entero que contiene el número de dependencias,-1 si da una exepción
     */
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
