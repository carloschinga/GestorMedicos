/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.WebMenuPermiso;
import com.clinicasb.dto.WebMenuPermisoPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USUARIO
 */
public class WebMenuPermisoJpaController implements Serializable {

    public WebMenuPermisoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public WebMenuPermisoJpaController() {
    }

    public void create(WebMenuPermiso webMenuPermiso) throws PreexistingEntityException, Exception {
        if (webMenuPermiso.getWebMenuPermisoPK() == null) {
            webMenuPermiso.setWebMenuPermisoPK(new WebMenuPermisoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(webMenuPermiso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findWebMenuPermiso(webMenuPermiso.getWebMenuPermisoPK()) != null) {
                throw new PreexistingEntityException("WebMenuPermiso " + webMenuPermiso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WebMenuPermiso webMenuPermiso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            webMenuPermiso = em.merge(webMenuPermiso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                WebMenuPermisoPK id = webMenuPermiso.getWebMenuPermisoPK();
                if (findWebMenuPermiso(id) == null) {
                    throw new NonexistentEntityException("The webMenuPermiso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(WebMenuPermisoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            WebMenuPermiso webMenuPermiso;
            try {
                webMenuPermiso = em.getReference(WebMenuPermiso.class, id);
                webMenuPermiso.getWebMenuPermisoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The webMenuPermiso with id " + id + " no longer exists.", enfe);
            }
            em.remove(webMenuPermiso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<WebMenuPermiso> findWebMenuPermisoEntities() {
        return findWebMenuPermisoEntities(true, -1, -1);
    }

    public List<WebMenuPermiso> findWebMenuPermisoEntities(int maxResults, int firstResult) {
        return findWebMenuPermisoEntities(false, maxResults, firstResult);
    }

    private List<WebMenuPermiso> findWebMenuPermisoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WebMenuPermiso.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public WebMenuPermiso findWebMenuPermiso(WebMenuPermisoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WebMenuPermiso.class, id);
        } finally {
            em.close();
        }
    }

    public int getWebMenuPermisoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WebMenuPermiso> rt = cq.from(WebMenuPermiso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

     public List<WebMenuPermiso> listarXRol(int rol) {
        EntityManager em = getEntityManager();        
        Query q = em.createNamedQuery("WebMenuPermiso.findByCodrol");
        q.setParameter("codrol", rol);
        List<WebMenuPermiso> lista = q.getResultList();
        return lista;

    }
    public void quitarPermisos(int rol) throws Exception {
        List<WebMenuPermiso> lista= listarXRol(rol);
        for (WebMenuPermiso webMenuPermiso : lista) {
            webMenuPermiso.setAsigperm(0);
            edit(webMenuPermiso);
        }
    }
    
    public static void main(String[] args) throws Exception {
        WebMenuPermisoJpaController wm= new WebMenuPermisoJpaController();
        wm.quitarPermisos(1);
    }

}
