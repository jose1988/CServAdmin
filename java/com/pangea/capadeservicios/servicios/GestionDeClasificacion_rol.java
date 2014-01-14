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
     * Método que que retorna el número de registros existentes de la entidad
     * clasificación de rol
     *
     * @return entero con el número de registros de clasificación de rol
     */
    @WebMethod(operationName = "contarClasificacionRol")
    public int contarClasificacionRol() {
        return clasificacionRolFacade.count();
    }

    /**
     * Método que lista los registros de la entidad clasificación de rol de
     * acuerdo a su estado si es boorado o no
     *
     * @param borrado booleano si es true es borrado si es false es no borrado
     * @return lista de la entidad clasificación de rol
     */
    @WebMethod(operationName = "listarClasificacionRol")
    public List<clasificacion_rol> listarClasificacionRol(@WebParam(name = "borrado") boolean borrado) {
        return clasificacionRolFacade.listarClasifRol(borrado);
    }

    /**
     * Método encargado de insertar registros de la entidad clasificación de
     * rol
     *
     * @param registroClaRol objeto de la entidad clasificación de rol , debe
     * tener como mínimo los campos obligatorios para poder insertar
     */
    @WebMethod(operationName = "insertarClasificacionRol")
    public void insertarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registroClaRol) {
        registroClaRol.setFechaCreacion(new Date());
        registroClaRol.setFechaModificacion(new Date());
        clasificacionRolFacade.insertar(registroClaRol);
    }

    /**
     * Método encargado de editar registros de la entidad clasificación de rol
     *
     * @param registroClaRol objeto de la entidad clasificación de rol
     */
    @WebMethod(operationName = "editarClasificacionRol")
    public void editarClasificacionRol(@WebParam(name = "registroClaRol") clasificacion_rol registroClaRol) {
        clasificacionRolFacade.editar(registroClaRol);
    }

    /**
     * Método encargado de eliminar registros de la entidad clasificación de rol
     *
     * @param idClasifRol objeto de la entidad rol , debe tener el campo id como
     * mínimo
     */
    @WebMethod(operationName = "eliminarClasificacionRol")
    public void eliminarClasificacionRol(@WebParam(name = "idClasifRol") String idClasifRol) {
        clasificacionRolFacade.eliminar(idClasifRol);
    }

    /**
     * Método encargado de cambiar el borrado de registros de la entidad
     * clasificación de rol, el borrado cambiara a false
     *
     * @param idClasifRol String que contiene el id del clasificación de rol a
     * restaurar
     */
    @WebMethod(operationName = "restaurarClasificacionRol")
    public void restaurarClasificacionRol(@WebParam(name = "idClasifRol") String idClasifRol) {
        clasificacionRolFacade.restaurar(idClasifRol);
    }

    /**
     * Método encargado de consultar un registro de clasificación de rol de
     * acuerdo a su id
     *
     * @param idClasifRol string que contiene el id del clasificación de rol a
     * consultar
     * @return objeto de la entidad clasificación de rol
     */
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

    /**
     *
     * Método encargado de consultar un registro de clasificación de rol de
     * acuerdo a su nombre
     *
     * @param Nombre string que contiene el nombre del clasificación de rol a
     * consultar
     * @return objeto de la entidad clasificación de rol
     */
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

    /**
     * Método encargado de comprobar si hay dependencias  con
     * respecto al registro de clasificación de rol , es decir si el registro de clasificación de rol ha sido
     * usado para registros de otras entidades dependientes de clasificación de
     * rol,si encuentra alguna dependencia mayor de 0
     * automaticamente quiere decir que no se puede borrar y retorna ese valor
     *
     * @param idClasifRol objeto de la entidad clasificación de rol
     * @return entero que contiene el número de dependencias,-1 si da una exepción
     */
    @WebMethod(operationName = "consultarDependenciasClasRol")
    public int consultarDependenciasClasRol(@WebParam(name = "idClasifRol") String idClasifRol) {
        int Resultado = 0;
        clasificacion_rol clasificacionRol;
        try {
            clasificacionRol = clasificacionRolFacade.consultarClasifRol(Long.parseLong(idClasifRol));
            Resultado = clasificacionRol.getRolCollection().size();
        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
}
