/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewProcedimientoResultadoMedico;
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
public class ViewProcedimientoResultadoMedicoJpaController implements Serializable {

    public ViewProcedimientoResultadoMedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ViewProcedimientoResultadoMedicoJpaController() {
    }


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewProcedimientoResultadoMedico viewProcedimientoResultadoMedico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewProcedimientoResultadoMedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewProcedimientoResultadoMedico(viewProcedimientoResultadoMedico.getSecuencia()) != null) {
                throw new PreexistingEntityException("ViewProcedimientoResultadoMedico " + viewProcedimientoResultadoMedico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewProcedimientoResultadoMedico viewProcedimientoResultadoMedico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewProcedimientoResultadoMedico = em.merge(viewProcedimientoResultadoMedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewProcedimientoResultadoMedico.getSecuencia();
                if (findViewProcedimientoResultadoMedico(id) == null) {
                    throw new NonexistentEntityException("The viewProcedimientoResultadoMedico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewProcedimientoResultadoMedico viewProcedimientoResultadoMedico;
            try {
                viewProcedimientoResultadoMedico = em.getReference(ViewProcedimientoResultadoMedico.class, id);
                viewProcedimientoResultadoMedico.getSecuencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewProcedimientoResultadoMedico with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewProcedimientoResultadoMedico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewProcedimientoResultadoMedico> findViewProcedimientoResultadoMedicoEntities() {
        return findViewProcedimientoResultadoMedicoEntities(true, -1, -1);
    }

    public List<ViewProcedimientoResultadoMedico> findViewProcedimientoResultadoMedicoEntities(int maxResults, int firstResult) {
        return findViewProcedimientoResultadoMedicoEntities(false, maxResults, firstResult);
    }

    private List<ViewProcedimientoResultadoMedico> findViewProcedimientoResultadoMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewProcedimientoResultadoMedico.class));
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

    public ViewProcedimientoResultadoMedico findViewProcedimientoResultadoMedico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewProcedimientoResultadoMedico.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewProcedimientoResultadoMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewProcedimientoResultadoMedico> rt = cq.from(ViewProcedimientoResultadoMedico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<ViewProcedimientoResultadoMedico> listar(String startDate, String endDate, String medcod) {
        EntityManager em = getEntityManager();
        try {
            String consultaSQL = "SELECT * FROM view_procedimiento_resultado_medico WHERE medcod='"+medcod+"' and  FechaFiltro BETWEEN '"+startDate+"' and '"+endDate+"' ";
            Query query = em.createNativeQuery(consultaSQL, ViewProcedimientoResultadoMedico.class);

            // Ejecutar la consulta y obtener resultados
            List<ViewProcedimientoResultadoMedico> lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();

        }
    }
    
}
