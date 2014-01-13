/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.validadores;

import com.pangea.capadeservicios.entidades.tarea;
import com.pangea.capadeservicios.envoltorios.WR_transicion;

/**
 *
 * @author pc
 */
public class GestionDeTransicionValidador {
    public WR_transicion validarConsultaTransicionXTarea(tarea tareaActual){
        WR_transicion Resultado = new WR_transicion();
        if(tareaActual.getId()==null){
            Resultado.setEstatus("FAIL");
            Resultado.setObservacion("El identificador de la tarea introducido es invalido");
        }else{
            if(tareaActual.getId()<0){
                Resultado.setEstatus("FAIL");
                Resultado.setObservacion("El identificador de la tarea introducido es invalido");
            }else{
                Resultado.setEstatus("OK");
            }
        }
        return Resultado;
    }
}
