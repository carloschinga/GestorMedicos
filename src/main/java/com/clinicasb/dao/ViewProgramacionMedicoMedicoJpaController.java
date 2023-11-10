/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.Usuarios;
import com.clinicasb.dto.ViewProgramacionMedicoMedico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USUARIO
 */
public class ViewProgramacionMedicoMedicoJpaController implements Serializable {

    public ViewProgramacionMedicoMedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ViewProgramacionMedicoMedicoJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewProgramacionMedicoMedico viewProgramacionMedicoMedico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewProgramacionMedicoMedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewProgramacionMedicoMedico(viewProgramacionMedicoMedico.getMedcod()) != null) {
                throw new PreexistingEntityException("ViewProgramacionMedicoMedico " + viewProgramacionMedicoMedico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewProgramacionMedicoMedico viewProgramacionMedicoMedico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewProgramacionMedicoMedico = em.merge(viewProgramacionMedicoMedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = viewProgramacionMedicoMedico.getMedcod();
                if (findViewProgramacionMedicoMedico(id) == null) {
                    throw new NonexistentEntityException("The viewProgramacionMedicoMedico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewProgramacionMedicoMedico viewProgramacionMedicoMedico;
            try {
                viewProgramacionMedicoMedico = em.getReference(ViewProgramacionMedicoMedico.class, id);
                viewProgramacionMedicoMedico.getMedcod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewProgramacionMedicoMedico with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewProgramacionMedicoMedico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewProgramacionMedicoMedico> findViewProgramacionMedicoMedicoEntities() {
        return findViewProgramacionMedicoMedicoEntities(true, -1, -1);
    }

    public List<ViewProgramacionMedicoMedico> findViewProgramacionMedicoMedicoEntities(int maxResults, int firstResult) {
        return findViewProgramacionMedicoMedicoEntities(false, maxResults, firstResult);
    }

    private List<ViewProgramacionMedicoMedico> findViewProgramacionMedicoMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewProgramacionMedicoMedico.class));
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

    public ViewProgramacionMedicoMedico findViewProgramacionMedicoMedico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewProgramacionMedicoMedico.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewProgramacionMedicoMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewProgramacionMedicoMedico> rt = cq.from(ViewProgramacionMedicoMedico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ViewProgramacionMedicoMedico> listarMedicoXServicio(String sercod) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ViewProgramacionMedicoMedico.findBySercod");            
            q.setParameter("sercod", sercod);
            List<ViewProgramacionMedicoMedico> lista = q.getResultList();
            return lista;
        } finally {
            em.close();
        }
    }
}
