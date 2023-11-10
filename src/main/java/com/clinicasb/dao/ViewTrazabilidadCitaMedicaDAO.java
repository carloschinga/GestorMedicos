/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.clinicasb.dto.ViewTrazabilidadCitaMedica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class ViewTrazabilidadCitaMedicaDAO {
     private static EntityManagerFactory getEntity() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            return emf;
        } catch (Exception e) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            return emf;
        }

    }

   

    public static List<ViewTrazabilidadCitaMedica> listar(Date startDate, Date endDate) {
        try {
            EntityManager em = getEntity().createEntityManager();
            Query q = em.createNamedQuery("ViewTrazabilidadCitaMedica.findByFechaFiltroBeetwen");
            q.setParameter("startDate", startDate);
            q.setParameter("endDate", endDate);
            List<ViewTrazabilidadCitaMedica> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }
    }
    public static void main(String[] args) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date filtroInicio = formato.parse("2023-06-30");
            Date filtroFin = formato.parse("2023-06-30");
            List<ViewTrazabilidadCitaMedica> lista = ViewTrazabilidadCitaMedicaDAO.listar(filtroInicio, filtroFin);
            
           /* int i=0;
            for (ViewTrazabilidadCitaMedica o : lista) {
                System.out.println(o.getSecuencua() + " - " + o.getPaciente()+" - " + o.getDiagnostico1() + " - " + o.getFechaCita());
                i++;
            
            
            
            }*/
            
              Gson g = new Gson();
                String resultado = g.toJson(lista);
                resultado = "{\"data\":" + resultado + "}";
                System.out.println(resultado);
          //  System.out.println("total" + i);
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
