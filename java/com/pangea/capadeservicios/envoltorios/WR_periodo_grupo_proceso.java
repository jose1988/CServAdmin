/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.envoltorios;

import com.pangea.capadeservicios.entidades.periodo_grupo_proceso;
import java.util.ArrayList;

/**
 * Esta clase posee los metodos y atributos para servir de envoltorio a los
 * objetos de la clase periodo_grupo_proceso retornados por las operaciones web.
 * Las instancias de esta clase almacenan tanto el resultado de la operacion
 * ejecutada como los objetos solicitados.
 *
 * @author pangea technologies c.a.
 */
public class WR_periodo_grupo_proceso {

    /**
     * Resultado de la ejecucion de la operacion web que retorno el wrapper.
     */
    private String estatus;
    /**
     * Notas sobre errores ocurridos durante la ejecucion de la operacion web y
     * notas sobre los objetos obtenidos.
     */
    private String observacion;
    /**
     * Lista de objetos de la clase periodo_grupo_proceso que son retornados por
     * la operacion web.
     */
    private ArrayList<periodo_grupo_proceso> periodo_Grupo_Proceso;

    /**
     * Constructor
     */
    public WR_periodo_grupo_proceso() {
        periodo_Grupo_Proceso = new ArrayList<periodo_grupo_proceso>();
    }

    /**
     * Obtiene el resultado de la operacion. Este campo generalmente solo
     * retorna "OK" si la operacion se ejecuto con exito o "Fail" si hubo algun
     * problema durante el proceso.
     *
     * @return String con el resultado de la operacion
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Asigna un valor al resultado de la operacion que origino el wrapper. Solo
     * deberian asignarse "OK" o "FAIL" a este campo.
     *
     * @param Estatus String con el resultado de la operacion web que origino el
     * wrapper
     */
    public void setEstatus(String Estatus) {
        if (Estatus.compareTo("OK") == 0 || Estatus.compareTo("FAIL") == 0) {
            this.estatus = Estatus;
        }
    }

    /**
     * Retorna mas informacion sobre el resultado de la operacion que origino el
     * wrapper Este metodo deberia devolver informacion sobre errores de
     * ejecucion de la operacion o comentarios sobre los resultados obtenidos.
     *
     * @return String con notas sobre errores o resultados de la operacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Asigna un valor al campo observacion. Aqui se deben asignar notas sobre
     * errores o sobre los resultados de la ejecucion de la operacion que genero
     * el wrapper.
     *
     * @param observacion String con el valor que se desea asignar como
     * observacion.
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * Obtiene la lista de periodo_grupo_proceso que posee el envoltorio.
     * Dependiendo de la operacion que llene el envoltorio, esta lista podria
     * tener de 0 a N elementos
     *
     * @return Lista de los periodo_grupo_proceso obtenidos
     */
    public ArrayList<periodo_grupo_proceso> getPeriodo_Grupo_Proceso() {
        return periodo_Grupo_Proceso;
    }

    /**
     * Asigna una lista de periodo_grupo_proceso al envoltorio.
     *
     * @param periodo_Grupo_Proceso Lista de objetos de la clase
     * periodo_grupo_proceso
     */
    public void setPeriodo_Grupo_Proceso(ArrayList<periodo_grupo_proceso> periodo_Grupo_Proceso) {
        this.periodo_Grupo_Proceso = periodo_Grupo_Proceso;
    }
}
