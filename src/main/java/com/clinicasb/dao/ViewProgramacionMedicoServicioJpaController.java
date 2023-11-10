/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewProgramacionMedicoServicio;
import java.io.Serializable;
import java.util.Collections;
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
public class ViewProgramacionMedicoServicioJpaController implements Serializable {

    public ViewProgramacionMedicoServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ViewProgramacionMedicoServicioJpaController() {
    }


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewProgramacionMedicoServicio viewProgramacionMedicoServicio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewProgramacionMedicoServicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewProgramacionMedicoServicio(viewProgramacionMedicoServicio.getSercod()) != null) {
                throw new PreexistingEntityException("ViewProgramacionMedicoServicio " + viewProgramacionMedicoServicio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewProgramacionMedicoServicio viewProgramacionMedicoServicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewProgramacionMedicoServicio = em.merge(viewProgramacionMedicoServicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = viewProgramacionMedicoServicio.getSercod();
                if (findViewProgramacionMedicoServicio(id) == null) {
                    throw new NonexistentEntityException("The viewProgramacionMedicoServicio with id " + id + " no longer exists.");
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
            ViewProgramacionMedicoServicio viewProgramacionMedicoServicio;
            try {
                viewProgramacionMedicoServicio = em.getReference(ViewProgramacionMedicoServicio.class, id);
                viewProgramacionMedicoServicio.getSercod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewProgramacionMedicoServicio with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewProgramacionMedicoServicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewProgramacionMedicoServicio> findViewProgramacionMedicoServicioEntities() {
        return findViewProgramacionMedicoServicioEntities(true, -1, -1);
    }

    public List<ViewProgramacionMedicoServicio> findViewProgramacionMedicoServicioEntities(int maxResults, int firstResult) {
        return findViewProgramacionMedicoServicioEntities(false, maxResults, firstResult);
    }

    private List<ViewProgramacionMedicoServicio> findViewProgramacionMedicoServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewProgramacionMedicoServicio.class));
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

    public ViewProgramacionMedicoServicio findViewProgramacionMedicoServicio(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewProgramacionMedicoServicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewProgramacionMedicoServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewProgramacionMedicoServicio> rt = cq.from(ViewProgramacionMedicoServicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        ViewProgramacionMedicoServicioJpaController dao= new ViewProgramacionMedicoServicioJpaController();
        List<ViewProgramacionMedicoServicio> lista=dao.findViewProgramacionMedicoServicioEntities();
        Collections.sort(lista);
        for (ViewProgramacionMedicoServicio viewProgramacionMedicoServicio : lista) {
            System.out.println(viewProgramacionMedicoServicio.getSerdes());
        }
    }
    
}
