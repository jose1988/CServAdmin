/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.clasificacion_usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pangea
 */
@Stateless
public class clasificacion_usuarioFacade extends AbstractFacade<clasificacion_usuario> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public clasificacion_usuarioFacade() {
        super(clasificacion_usuario.class);
    }

    public List<clasificacion_usuario> listaclasificacion_usuario() {

        List<clasificacion_usuario> c = null;
        c = em.createNamedQuery("clasificacion_usuario.findAll").getResultList();
        return c;

    }

    public void insertarclasificacion_usuario(clasificacion_usuario registro) {

        this.create(registro);

    }

    public void editarclasificacion_usuario(clasificacion_usuario Registro) {
        Query q = em.createNativeQuery("UPDATE clasificacion_usuario "
                + "SET borrado=?,descripcion=?,nombre=? "
                + "WHERE id=?");
        q.setParameter(1, Registro.getBorrado());
        q.setParameter(2, Registro.getDescripcion());
        q.setParameter(3, Registro.getNombre());
        q.setParameter(4, Registro.getId());
        q.executeUpdate();
        this.edit(Registro);

    }

    public void eliminarclasificacion_usuario(String ID) {

        Query q = em.createNativeQuery("UPDATE clasificacion_usuario SET borrado='true' WHERE id=?");
        q.setParameter(1,Long.parseLong(ID));
        q.executeUpdate();

    }

    public List<clasificacion_usuario> listarClasificacion(boolean borrado) {
        List<clasificacion_usuario> lista;
        lista = em.createNamedQuery("clasificacion_usuario.findByBorrado").setParameter("borrado", borrado).getResultList();
        return lista;
    }
    public clasificacion_usuario consultarClasifUsuarioXnombre(String Nombre) {
        clasificacion_usuario Registro;
        Registro = (clasificacion_usuario) em.createNamedQuery("clasificacion_usuario.findByNombre").setParameter("nombre", Nombre).getSingleResult();
        return Registro;
    }
    
    public void restaurar(String ID) {
        Query q = em.createNativeQuery("UPDATE clasificacion_usuario SET borrado='false' WHERE id=?");
        q.setParameter(1, Long.parseLong(ID));
        q.executeUpdate();
    }
}
