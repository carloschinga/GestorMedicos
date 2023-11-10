/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ProcedimientosResultadosArch;
import com.clinicasb.dto.ProcedimientosResultadosArchPK;
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
public class ProcedimientosResultadosArchJpaController implements Serializable {

    public ProcedimientosResultadosArchJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ProcedimientosResultadosArchJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProcedimientosResultadosArch procedimientosResultadosArch) throws PreexistingEntityException, Exception {
        if (procedimientosResultadosArch.getProcedimientosResultadosArchPK() == null) {
            procedimientosResultadosArch.setProcedimientosResultadosArchPK(new ProcedimientosResultadosArchPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(procedimientosResultadosArch);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProcedimientosResultadosArch(procedimientosResultadosArch.getProcedimientosResultadosArchPK()) != null) {
                throw new PreexistingEntityException("ProcedimientosResultadosArch " + procedimientosResultadosArch + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProcedimientosResultadosArch procedimientosResultadosArch) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            procedimientosResultadosArch = em.merge(procedimientosResultadosArch);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ProcedimientosResultadosArchPK id = procedimientosResultadosArch.getProcedimientosResultadosArchPK();
                if (findProcedimientosResultadosArch(id) == null) {
                    throw new NonexistentEntityException("The procedimientosResultadosArch with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ProcedimientosResultadosArchPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProcedimientosResultadosArch procedimientosResultadosArch;
            try {
                procedimientosResultadosArch = em.getReference(ProcedimientosResultadosArch.class, id);
                procedimientosResultadosArch.getProcedimientosResultadosArchPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The procedimientosResultadosArch with id " + id + " no longer exists.", enfe);
            }
            em.remove(procedimientosResultadosArch);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProcedimientosResultadosArch> findProcedimientosResultadosArchEntities() {
        return findProcedimientosResultadosArchEntities(true, -1, -1);
    }

    public List<ProcedimientosResultadosArch> findProcedimientosResultadosArchEntities(int maxResults, int firstResult) {
        return findProcedimientosResultadosArchEntities(false, maxResults, firstResult);
    }

    private List<ProcedimientosResultadosArch> findProcedimientosResultadosArchEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProcedimientosResultadosArch.class));
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

    public ProcedimientosResultadosArch findProcedimientosResultadosArch(ProcedimientosResultadosArchPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProcedimientosResultadosArch.class, id);
        } finally {
            em.close();
        }
    }

    public int getProcedimientosResultadosArchCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProcedimientosResultadosArch> rt = cq.from(ProcedimientosResultadosArch.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
