/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.WebMenu;
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
public class WebMenuJpaController implements Serializable {

    public WebMenuJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public WebMenuJpaController() {
    }

    public void create(WebMenu webMenu) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(webMenu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findWebMenu(webMenu.getCodmen()) != null) {
                throw new PreexistingEntityException("WebMenu " + webMenu + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WebMenu webMenu) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            webMenu = em.merge(webMenu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = webMenu.getCodmen();
                if (findWebMenu(id) == null) {
                    throw new NonexistentEntityException("The webMenu with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            WebMenu webMenu;
            try {
                webMenu = em.getReference(WebMenu.class, id);
                webMenu.getCodmen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The webMenu with id " + id + " no longer exists.", enfe);
            }
            em.remove(webMenu);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<WebMenu> listarHabilitados() {
        EntityManager em = null;
        try {
            em = getEntityManager();            
            Query q = em.createNamedQuery("WebMenu.habiles");            
            List<WebMenu> lista = q.getResultList();
            return lista;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public List<WebMenu> findWebMenuEntities() {
        return findWebMenuEntities(true, -1, -1);
    }

    public List<WebMenu> findWebMenuEntities(int maxResults, int firstResult) {
        return findWebMenuEntities(false, maxResults, firstResult);
    }

    private List<WebMenu> findWebMenuEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WebMenu.class));
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

    public WebMenu findWebMenu(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WebMenu.class, id);
        } finally {
            em.close();
        }
    }

    public int getWebMenuCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WebMenu> rt = cq.from(WebMenu.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
