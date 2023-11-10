/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.MedicosJpaController;
import com.clinicasb.dto.Medicos;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ReporteResultadoProcePDF", urlPatterns = {"/reporteresultadoprocePDF"})
public class ReporteResultadoProcePDF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
        EntityManager em = emf.createEntityManager();
        try {
            //String uploadPath = getServletContext().getRealPath("") + "firmas" + File.separator;

            em.getTransaction().begin();
            java.sql.Connection cn = em.unwrap(java.sql.Connection.class);

            int invnum = Integer.parseInt(request.getParameter("invnum"));  
            int numitm = Integer.parseInt(request.getParameter("numitm"));
            String medcod = request.getParameter("medcod");

            MedicosJpaController medicoDAO= new MedicosJpaController();
            Medicos medico= medicoDAO.findMedicos(medcod);
            
            
            //uploadPath="http://localhost/GestorMedicos/firmas/"+ medico.getNamFirm();
            
            
            //uploadPath+= medico.getNamFirm();
            
            String baseURL = request.getRequestURL().toString();
            String servletPath = request.getServletPath();
            String contextPath = request.getContextPath();
            
            String ruta= baseURL.substring(0, baseURL.length()- servletPath.length());
            ruta=baseURL.substring(0,ruta.length()- contextPath.length());
            
            // La URL completa de la aplicación sería la concatenación de contextPath y servletPath
            String appURL = baseURL.replace(servletPath, "").replace(contextPath, "") + contextPath;
            String appLogo=appURL;
            
            appURL=ruta+"/firmas/"+medico.getNamFirm();
            appLogo=ruta+"/firmas/clinica.jpg";
            
            InputStream report = getServletConfig().getServletContext().getResourceAsStream("ResultadoProcedimiento.jasper");
            Map paramMap = new HashMap();
            paramMap.put("invnum", invnum); //19406
            paramMap.put("numitm", numitm); //1
            paramMap.put("rutaimagen", appURL); //http://localhost/gestormedico/firmas/firmapatologo2.png
            paramMap.put("rutalogo", appLogo); //http://localhost/gestormedico/firmas/firmapatologo2.png

            response.setContentType("application/pdf");
            response.addHeader("Content-disposition", "inline; filename=resultado.pdf");
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, paramMap, cn);
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
            cn.close();            
            out.flush();
            out.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            em.close();
            emf.close();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
