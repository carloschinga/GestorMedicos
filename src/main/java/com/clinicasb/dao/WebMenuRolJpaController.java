/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.WebMenuRol;
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
public class WebMenuRolJpaController implements Serializable {

    public WebMenuRolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");    

    public WebMenuRolJpaController() {
    }


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WebMenuRol webMenuRol) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(webMenuRol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findWebMenuRol(webMenuRol.getCodrol()) != null) {
                throw new PreexistingEntityException("WebMenuRol " + webMenuRol + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WebMenuRol webMenuRol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            webMenuRol = em.merge(webMenuRol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = webMenuRol.getCodrol();
                if (findWebMenuRol(id) == null) {
                    throw new NonexistentEntityException("The webMenuRol with id " + id + " no longer exists.");
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
            WebMenuRol webMenuRol;
            try {
                webMenuRol = em.getReference(WebMenuRol.class, id);
                webMenuRol.getCodrol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The webMenuRol with id " + id + " no longer exists.", enfe);
            }
            em.remove(webMenuRol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<WebMenuRol> findWebMenuRolEntities() {
        return findWebMenuRolEntities(true, -1, -1);
    }

    public List<WebMenuRol> findWebMenuRolEntities(int maxResults, int firstResult) {
        return findWebMenuRolEntities(false, maxResults, firstResult);
    }

    private List<WebMenuRol> findWebMenuRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WebMenuRol.class));
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

    public WebMenuRol findWebMenuRol(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WebMenuRol.class, id);
        } finally {
            em.close();
        }
    }

    public int getWebMenuRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WebMenuRol> rt = cq.from(WebMenuRol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
