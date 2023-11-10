/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewProduccionMedicos;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ViewProduccionMedicosJpaController implements Serializable {

    public ViewProduccionMedicosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ViewProduccionMedicosJpaController() {
    }

    public void create(ViewProduccionMedicos viewProduccionMedicos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewProduccionMedicos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewProduccionMedicos(viewProduccionMedicos.getMedcod()) != null) {
                throw new PreexistingEntityException("ViewProduccionMedicos " + viewProduccionMedicos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewProduccionMedicos viewProduccionMedicos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewProduccionMedicos = em.merge(viewProduccionMedicos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = viewProduccionMedicos.getMedcod();
                if (findViewProduccionMedicos(id) == null) {
                    throw new NonexistentEntityException("The viewProduccionMedicos with id " + id + " no longer exists.");
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
            ViewProduccionMedicos viewProduccionMedicos;
            try {
                viewProduccionMedicos = em.getReference(ViewProduccionMedicos.class, id);
                viewProduccionMedicos.getMedcod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewProduccionMedicos with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewProduccionMedicos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewProduccionMedicos> findViewProduccionMedicosEntities() {
        return findViewProduccionMedicosEntities(true, -1, -1);
    }

    public List<ViewProduccionMedicos> findViewProduccionMedicosEntities(int maxResults, int firstResult) {
        return findViewProduccionMedicosEntities(false, maxResults, firstResult);
    }

    private List<ViewProduccionMedicos> findViewProduccionMedicosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewProduccionMedicos.class));
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

    public ViewProduccionMedicos findViewProduccionMedicos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewProduccionMedicos.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewProduccionMedicosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewProduccionMedicos> rt = cq.from(ViewProduccionMedicos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ViewProduccionMedicos> listar(Date startDate, Date endDate, String sercod) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ViewProduccionMedicos.filtro");
            q.setParameter("startDate", startDate);
            q.setParameter("endDate", endDate);
            q.setParameter("sercod", sercod);
            List<ViewProduccionMedicos> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        } finally {
            em.close();
        }

    }

    public List<ViewProduccionMedicos> findByName(Date startDate, Date endDate) {
        EntityManager em = getEntityManager();
        try {
            Query nativeQuery = em.createNativeQuery("SELECT * FROM view_produccion_medicos WHERE Fecha>='2023-08-02' and Fecha<='2023-08-02'", ViewProduccionMedicos.class);
            //String textSearch = text == null ? "%" : "%" + text.toLowerCase() + "%";
//            nativeQuery.setParameter(1, startDate);
  //          nativeQuery.setParameter(2, endDate);
            return nativeQuery.getResultList();
            //return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-08-02");
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-08-02");
        ViewProduccionMedicosJpaController vpmDAO = new ViewProduccionMedicosJpaController();
        List<ViewProduccionMedicos> lista = vpmDAO.findByName(date1, date2);
        if (lista != null) {
            for (ViewProduccionMedicos viewProduccionMedicos : lista) {
                System.out.println(viewProduccionMedicos.getNombre() + ' ' +viewProduccionMedicos.getSerdes() );
            }
        } else {
            System.out.println("nada");
        }
    }

}
