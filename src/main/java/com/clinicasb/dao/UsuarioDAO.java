package com.clinicasb.dao;

import com.clinicasb.dto.Usuarios;
import com.clinicasb.util.Cripto;
import static com.clinicasb.util.Cripto.getSHA;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class UsuarioDAO {

    private static String mensaje;

    private static EntityManagerFactory getEntity() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            return emf;
        } catch (Exception e) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            return emf;
        }

    }

    public static List<Usuarios> listar() {
        EntityManager em = getEntity().createEntityManager();
        Query q = em.createNamedQuery("Usuarios.findAll");
        List<Usuarios> lista = q.getResultList();
        return lista;

    }

    public static Usuarios logueo(String usuario, String clave) {
        try {
                EntityManager em = getEntity().createEntityManager();
            Query q = em.createNamedQuery("Usuarios.validar");
            q.setParameter("useusr", usuario);
            q.setParameter("passweb", clave);
            Usuarios pers = (Usuarios) q.getSingleResult();
            return pers;
        } catch (NoResultException e) {
            mensaje = "Usuario  y/o contraseña no válidos";
            return null;
        } catch (PersistenceException e) {
            mensaje = "No pudo conectar con la Base de Datos";
            return null;
        } catch (Exception e) {
            mensaje = e.getMessage();
            return null;
        }
    }

    public static Usuarios buscarPorLogi(String usuario) {
        try {
            EntityManager em = getEntity().createEntityManager();
            Query q = em.createNamedQuery("Usuarios.findByUseusr");
            q.setParameter("useusr", usuario);
            Usuarios pers = (Usuarios) q.getSingleResult();
            return pers;
        } catch (NoResultException e) {
            mensaje = "Usuario  no válido";
            return null;
        } catch (PersistenceException e) {
            mensaje = "No pudo conectar con la Base de Datos";
            return null;
        } catch (Exception e) {
            mensaje = e.getMessage();
            return null;
        }
    }

    public static boolean modificar(Usuarios usuario) {
        try {
            EntityManager em = getEntity().createEntityManager();
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            mensaje = e.getMessage();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            String pass="1234";
            pass = Cripto.toHexString(getSHA(pass.toUpperCase()));
            /*Usuarios u = UsuarioDAO.logueo("kike", "12yvvyvvy34");
            if (u == null) {
            System.out.println("Usuario no existe");
            } else {
            System.out.println("El usuario es:" + u.getUseusr());
            }*/
            
            /*List<Usuario> lista= UsuarioDAO.listar();
            for (Usuario u : lista) {
            System.out.println(u.getLogiUsua());
            }*/
            System.out.println(pass);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @return the mensaje
     */
    public static String getMensaje() {
        return mensaje;
    }

    /**
     * @param aMensaje the mensaje to set
     */
    public static void setMensaje(String aMensaje) {
        mensaje = aMensaje;
    }

}
