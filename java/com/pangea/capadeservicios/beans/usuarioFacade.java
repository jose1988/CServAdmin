/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.clienteweb.Usuario;
import com.pangea.capadeservicios.entidades.usuario;
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
public class usuarioFacade extends AbstractFacade<usuario> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public usuarioFacade() {
        super(usuario.class);
    }

    public List<usuario> listarUsuarios(boolean borrado) {
        List<usuario> lista;
        lista = em.createNamedQuery("usuario.findByBorrado").setParameter("borrado", borrado).getResultList();
        return lista;
    }

    public List<usuario> listar() {
        List<usuario> c = null;

        c = (List<usuario>) em.createNamedQuery("usuario.findAll").getResultList();
        return c;
    }

    public void insertar(usuario registro) {

        this.create(registro);

    }

    public void editar(usuario Registro) {
        Query q = em.createNativeQuery("UPDATE usuario "
                + "SET borrado=?,cedula=?,clave=?,descripcion=?,direccion_personal=?,direccion_oficina=?,estado=?,fax=?,id_clasificacion_usuario=?,id_organizacion=?,id_skin=?,mail=?,primer_apellido=?,primer_nombre=?,rif=?,segundo_apellido=?,segundo_nombre=?,telefonos_oficina=?,telefonos_personal=? "
                + "WHERE id=?");
        q.setParameter(1, Registro.getBorrado());
        q.setParameter(2, Registro.getCedula());
        q.setParameter(3, Registro.getClave());
        q.setParameter(4, Registro.getDescripcion());
        q.setParameter(5, Registro.getDireccionOficina());
        q.setParameter(6, Registro.getDireccionPersonal());
        q.setParameter(7, Registro.getEstado());
        q.setParameter(8, Registro.getFax());
        q.setParameter(9, Registro.getIdClasificacionUsuario().getId());
        q.setParameter(10, Registro.getIdOrganizacion().getId());
        q.setParameter(11, Registro.getIdSkin().getId());
        q.setParameter(12, Registro.getMail());
        q.setParameter(13, Registro.getPrimerApellido());
        q.setParameter(14, Registro.getPrimerNombre());
        q.setParameter(15, Registro.getRif());
        q.setParameter(16, Registro.getSegundoApellido());
        q.setParameter(17, Registro.getSegundoNombre());
        q.setParameter(18, Registro.getTelefonosOficina());
        q.setParameter(19, Registro.getTelefonosPersonal());
        q.setParameter(20, Registro.getId());
        q.executeUpdate();
    }

    public void eliminar(String ID) {
        Query q = em.createNativeQuery("UPDATE usuario SET borrado='true' WHERE id=?");
        q.setParameter(1, ID);
        q.executeUpdate();
    }

    public void restaurar(String ID) {
        Query q = em.createNativeQuery("UPDATE usuario SET borrado='false' WHERE id=?");
        q.setParameter(1, ID);
        q.executeUpdate();
    }

    public usuario consultarUsuario(String idUsuario) {
        usuario Registro;
        Registro = this.find(idUsuario);
        return Registro;
    }
}
