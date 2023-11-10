/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.Medicos;
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
public class MedicosJpaController implements Serializable {

    public MedicosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MedicosJpaController() {
    }
    
    

    public void create(Medicos medicos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(medicos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMedicos(medicos.getMedcod()) != null) {
                throw new PreexistingEntityException("Medicos " + medicos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medicos medicos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            medicos = em.merge(medicos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = medicos.getMedcod();
                if (findMedicos(id) == null) {
                    throw new NonexistentEntityException("The medicos with id " + id + " no longer exists.");
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
            Medicos medicos;
            try {
                medicos = em.getReference(Medicos.class, id);
                medicos.getMedcod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medicos with id " + id + " no longer exists.", enfe);
            }
            em.remove(medicos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medicos> findMedicosEntities() {
        return findMedicosEntities(true, -1, -1);
    }

    public List<Medicos> findMedicosEntities(int maxResults, int firstResult) {
        return findMedicosEntities(false, maxResults, firstResult);
    }

    private List<Medicos> findMedicosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medicos.class));
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

    public Medicos findMedicos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medicos.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medicos> rt = cq.from(Medicos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public  Medicos getMedicoXUsecodx(int usecod) {
         EntityManager em = getEntityManager();
        try {            
            Query q = em.createNamedQuery("Medicos.findByUsecodx");
            q.setParameter("usecodx", usecod);
            
            Medicos medicos = (Medicos) q.getSingleResult();
            return medicos;        
        } catch (Exception e) {            
            return null;
        }
    }
    
}
