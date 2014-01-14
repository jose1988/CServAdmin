/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.clasificacion_usuarioFacade;
import com.pangea.capadeservicios.entidades.clasificacion_usuario;

import java.util.List;
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

    /**
     * Método que lista todos los registros de la entidad clasificación de
     * usuario
     *
     * @return lista de la entidad clasificación de usuario
     */
    @WebMethod(operationName = "listar")
    public List<clasificacion_usuario> listar() {
        return clasificacion_usuarioFacade.listaclasificacion_usuario();
    }

    /**
     * Método encargado de insertar registros de la entidad clasificación de
     * usuario
     *
     * @param registroClaUsuario objeto de la entidad clasificación de usuario ,
     * debe tener como mínimo los campos obligatorios para poder insertar
     */
    @WebMethod(operationName = "insertarClasificacionUsuario")
    public void insertarClasificacionUsuario(@WebParam(name = "registroClaUsuario") clasificacion_usuario registroClaUsuario) {

        clasificacion_usuarioFacade.insertarclasificacion_usuario(registroClaUsuario);
    }

    /**
     * Método encargado de editar registros de la entidad clasificación de
     * usuario
     *
     * @param registroClaUsuario objeto de la entidad clasificación de usuario
     */
    @WebMethod(operationName = "editarClasificacionUsuario")
    public void editarClasificacionUsuario(@WebParam(name = "registroClaUsuario") clasificacion_usuario registroClaUsuario) {

        clasificacion_usuarioFacade.editarclasificacion_usuario(registroClaUsuario);
    }

    /**
     * Método encargado de eliminar registros de la entidad clasificación de
     * usuario
     *
     * @param idClaUsu objeto de la entidad usuario , debe tener el campo id
     * como mínimo
     */
    @WebMethod(operationName = "eliminarClasificacionUsuario")
    public void eliminarClasificacionUsuario(@WebParam(name = "idClaUsu") String idClaUsu) {

        clasificacion_usuarioFacade.eliminarclasificacion_usuario(idClaUsu);
    }

    /**
     *
     * Método encargado de consultar un registro de clasificación de usuario de
     * acuerdo a su id
     *
     * @param idClaUsu string que contiene el id del clasificación de usuario a
     * consultar
     * @return objeto de la entidad clasificación de usuario
     */
    @WebMethod(operationName = "consultarClasificacionUsuario")
    public clasificacion_usuario consultarClasificacionUsuario(@WebParam(name = "idClaUsu") String idClaUsu) {
        return clasificacion_usuarioFacade.find(Long.parseLong(idClaUsu));
    }

    /**
     * Método que que retorna el número de registros existentes de la entidad
     * clasificación de usuario
     *
     * @return entero con el número de registros de clasificación de usuario
     */
    @WebMethod(operationName = "contarClasificacion_usuario")
    public int contarClasificacion_usuario() {

        return clasificacion_usuarioFacade.count();
    }

    /**
     *
     * Método que lista los registros de la entidad clasificación de usuario de
     * acuerdo a su estado si es borrado o no
     *
     * @param borrado booleano si es true es borrado si es false es no borrado
     * @return lista de la entidad clasificación de usuario
     */
    @WebMethod(operationName = "listarClasificacionUsuario")
    public List<clasificacion_usuario> listarClasificacionUsuario(@WebParam(name = "borrado") boolean borrado) {
        return clasificacion_usuarioFacade.listarClasificacion(borrado);
    }

    /**
     * Método encargado de consultar un registro de clasificación de usuario de
     * acuerdo a su nombre
     *
     * @param Nombre string que contiene el nombre del clasificación de usuario
     * a consultar
     * @return objeto de la entidad clasificación de usuario
     *
     */
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

    /**
     *
     * Método encargado de cambiar el borrado de registros de la entidad
     * clasificación de usuario, el borrado cambiara a false
     *
     * @param idClaUsu String que contiene el id del clasificación de usuario a
     * restaurar
     */
    @WebMethod(operationName = "restaurarClasificacionUsuario")
    public void restaurarClasificacionUsuario(@WebParam(name = "idClaUsu") String idClaUsu) {
        clasificacion_usuarioFacade.restaurar(idClaUsu);
    }

    /**
     *
     * Método encargado de comprobar si hay dependencias con respecto al
     * registro de clasificación de usuario , es decir si el registro de
     * clasificación de usuario ha sido usado para registros de otras entidades
     * dependientes de clasificación de usuario,si encuentra alguna dependencia
     * mayor de 0 automaticamente quiere decir que no se puede borrar y retorna
     * ese valor
     *
     * @param idClaUsu objeto de la entidad clasificación de usuario
     * @return entero que contiene el número de dependencias,-1 si da una
     * exepción
     */
    @WebMethod(operationName = "consultarDependenciasClasUsuario")
    public int consultarDependenciasClasUsuario(@WebParam(name = "idClaUsu") String idClaUsu) {
        int Resultado = 0;
        clasificacion_usuario clasificacionUsuario;
        try {
            clasificacionUsuario = clasificacion_usuarioFacade.find(Long.parseLong(idClaUsu));
            Resultado = clasificacionUsuario.getUsuarioCollection().size();
        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
}
