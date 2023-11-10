/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.EaOrdenesCabecera;
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
public class EaOrdenesCabeceraJpaController implements Serializable {

    public EaOrdenesCabeceraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EaOrdenesCabeceraJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EaOrdenesCabecera eaOrdenesCabecera) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(eaOrdenesCabecera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEaOrdenesCabecera(eaOrdenesCabecera.getInvnum()) != null) {
                throw new PreexistingEntityException("EaOrdenesCabecera " + eaOrdenesCabecera + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EaOrdenesCabecera eaOrdenesCabecera) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            eaOrdenesCabecera = em.merge(eaOrdenesCabecera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = eaOrdenesCabecera.getInvnum();
                if (findEaOrdenesCabecera(id) == null) {
                    throw new NonexistentEntityException("The eaOrdenesCabecera with id " + id + " no longer exists.");
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
            EaOrdenesCabecera eaOrdenesCabecera;
            try {
                eaOrdenesCabecera = em.getReference(EaOrdenesCabecera.class, id);
                eaOrdenesCabecera.getInvnum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eaOrdenesCabecera with id " + id + " no longer exists.", enfe);
            }
            em.remove(eaOrdenesCabecera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EaOrdenesCabecera> findEaOrdenesCabeceraEntities() {
        return findEaOrdenesCabeceraEntities(true, -1, -1);
    }

    public List<EaOrdenesCabecera> findEaOrdenesCabeceraEntities(int maxResults, int firstResult) {
        return findEaOrdenesCabeceraEntities(false, maxResults, firstResult);
    }

    private List<EaOrdenesCabecera> findEaOrdenesCabeceraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EaOrdenesCabecera.class));
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

    public EaOrdenesCabecera findEaOrdenesCabecera(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EaOrdenesCabecera.class, id);
        } finally {
            em.close();
        }
    }

    public int getEaOrdenesCabeceraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EaOrdenesCabecera> rt = cq.from(EaOrdenesCabecera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
