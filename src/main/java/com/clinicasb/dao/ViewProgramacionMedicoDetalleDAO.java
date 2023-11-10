/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dto.ViewProgramacionMedicoDeta;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class ViewProgramacionMedicoDetalleDAO {
     private static EntityManagerFactory getEntity() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            return emf;
        } catch (Exception e) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            return emf;
        }
    }  

    public static List<ViewProgramacionMedicoDeta> listar(String medcod, String sercod, String periodo ) {
        try {
            EntityManager em = getEntity().createEntityManager();
            Query q = em.createNamedQuery("ViewProgramacionMedicoDeta.findByMedcodSercod");            
            q.setParameter("medcod", medcod);
            q.setParameter("sercod", sercod);
            q.setParameter("promes", periodo);
            
            List<ViewProgramacionMedicoDeta> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }
    }
    public static List<ViewProgramacionMedicoDeta> listarXConsultorio(Date fecha ) {
        try {
            EntityManager em = getEntity().createEntityManager();
            Query q = em.createNamedQuery("ViewProgramacionMedicoDeta.findByFecha");            
            q.setParameter("fecha", fecha);            
            List<ViewProgramacionMedicoDeta> lista = q.getResultList();
            return lista; 
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }
    }
    public static void main(String[] args) {
        try {
            //List<ViewProgramacionMedicoDeta> lista=ViewProgramacionMedicoDetalleDAO.listar("0018","0020");
            Date d=new Date();
            List<ViewProgramacionMedicoDeta> lista=ViewProgramacionMedicoDetalleDAO.listarXConsultorio(d);
            for (ViewProgramacionMedicoDeta viewProgramacionMedicoDetalle : lista) {
                System.out.println(viewProgramacionMedicoDetalle.getPronum());
                System.out.println(viewProgramacionMedicoDetalle.getFechaFormateada());
                System.out.println(viewProgramacionMedicoDetalle.getHora());
            }
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
