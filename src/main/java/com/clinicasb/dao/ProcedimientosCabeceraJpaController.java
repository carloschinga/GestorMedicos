/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ProcedimientosCabecera;
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
public class ProcedimientosCabeceraJpaController implements Serializable {

    public ProcedimientosCabeceraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ProcedimientosCabeceraJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProcedimientosCabecera procedimientosCabecera) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(procedimientosCabecera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProcedimientosCabecera(procedimientosCabecera.getInvnum()) != null) {
                throw new PreexistingEntityException("ProcedimientosCabecera " + procedimientosCabecera + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProcedimientosCabecera procedimientosCabecera) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            procedimientosCabecera = em.merge(procedimientosCabecera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = procedimientosCabecera.getInvnum();
                if (findProcedimientosCabecera(id) == null) {
                    throw new NonexistentEntityException("The procedimientosCabecera with id " + id + " no longer exists.");
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
            ProcedimientosCabecera procedimientosCabecera;
            try {
                procedimientosCabecera = em.getReference(ProcedimientosCabecera.class, id);
                procedimientosCabecera.getInvnum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The procedimientosCabecera with id " + id + " no longer exists.", enfe);
            }
            em.remove(procedimientosCabecera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProcedimientosCabecera> findProcedimientosCabeceraEntities() {
        return findProcedimientosCabeceraEntities(true, -1, -1);
    }

    public List<ProcedimientosCabecera> findProcedimientosCabeceraEntities(int maxResults, int firstResult) {
        return findProcedimientosCabeceraEntities(false, maxResults, firstResult);
    }

    private List<ProcedimientosCabecera> findProcedimientosCabeceraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProcedimientosCabecera.class));
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

    public ProcedimientosCabecera findProcedimientosCabecera(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProcedimientosCabecera.class, id);
        } finally {
            em.close();
        }
    }

    public int getProcedimientosCabeceraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProcedimientosCabecera> rt = cq.from(ProcedimientosCabecera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
