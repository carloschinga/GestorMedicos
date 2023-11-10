/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.MedicosJpaController;
import com.clinicasb.dao.ProcedimientosCabeceraJpaController;
import com.clinicasb.dao.ProcedimientosDetalleJpaController;
import com.clinicasb.dao.ProcedimientosResultadosArchJpaController;
import com.clinicasb.dao.ProcedimientosResultadosJpaController;
import com.clinicasb.dto.Medicos;
import com.clinicasb.dto.ProcedimientosCabecera;
import com.clinicasb.dto.ProcedimientosDetalle;
import com.clinicasb.dto.ProcedimientosDetallePK;
import com.clinicasb.dto.ProcedimientosResultados;
import com.clinicasb.dto.ProcedimientosResultadosArch;
import com.clinicasb.dto.ProcedimientosResultadosArchPK;
import com.clinicasb.dto.ProcedimientosResultadosPK;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "GrabarAprobProcedimiento", urlPatterns = {"/grabaraprobprocedimiento"})
public class GrabarAprobProcedimiento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            boolean b = false;
            /* TODO output your page here. You may use following sample code. */
            String invnum = request.getParameter("invnum");
            String numitm = request.getParameter("numitm");
            String medcod = request.getParameter("medcod");
            String pachis = request.getParameter("pachis");
            String rtf = request.getParameter("rtfContent");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            EntityManager em = emf.createEntityManager();
            try {
                /**
                 * **************** GENERAR PDF *************************
                 */

                em.getTransaction().begin();
                java.sql.Connection cn = em.unwrap(java.sql.Connection.class);

                MedicosJpaController medicoDAO = new MedicosJpaController();
                Medicos medico = medicoDAO.findMedicos(medcod);

                String baseURL = request.getRequestURL().toString();
                String servletPath = request.getServletPath();
                String contextPath = request.getContextPath();

                String ruta = baseURL.substring(0, baseURL.length() - servletPath.length());
                ruta = baseURL.substring(0, ruta.length() - contextPath.length());

                String appURL = baseURL.replace(servletPath, "").replace(contextPath, "") + contextPath;
                String appLogo = appURL;

                appURL = ruta + "/firmas/" + medico.getNamFirm();
                appLogo = ruta + "/firmas/clinica.jpg";

                InputStream report = getServletConfig().getServletContext().getResourceAsStream("ResultadoProcedimiento.jasper");
                Map paramMap = new HashMap();
                paramMap.put("invnum",Integer.parseInt(invnum) ); //19406
                paramMap.put("numitm", Integer.parseInt(numitm)); //1
                paramMap.put("rutaimagen", appURL); //http://localhost/gestormedico/firmas/firmapatologo2.png
                paramMap.put("rutalogo", appLogo); //http://localhost/gestormedico/firmas/firmapatologo2.png

                Date fechaActual = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
                String fechaFormateada = formato.format(fechaActual);

                ProcedimientosCabeceraJpaController proceCabeDAO = new ProcedimientosCabeceraJpaController();
                ProcedimientosCabecera proceCabe = proceCabeDAO.findProcedimientosCabecera(Integer.parseInt(invnum));
                
                String nombrearchivo = "P" + fechaFormateada + "_" + proceCabe.getPacnam().replace(" ","_") + "-" + pachis + "-" + invnum + "-" + numitm;

                JasperPrint jasperPrint = JasperFillManager.fillReport(report, paramMap, cn);
                JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\pdf\\" + nombrearchivo + ".pdf");
                cn.close();

                /**
                 * **************** MODIFICAR LAS TABLAS
                 * *************************
                 */
                InetAddress localhost = InetAddress.getLocalHost();
                String nombreDePC = localhost.getHostName();
                ProcedimientosResultadosJpaController prDAO = new ProcedimientosResultadosJpaController();
                ProcedimientosResultadosPK prPK = new ProcedimientosResultadosPK(Integer.parseInt(invnum), Integer.parseInt(numitm));
                ProcedimientosResultados pr = prDAO.findProcedimientosResultados(prPK);

                pr.setFecumv(new Date());
                //pr.setUsecod(Integer.parseInt(session.getAttribute("codi").toString()));              
                pr.setFeccreApr(new Date());
                pr.setUsecodApr(Integer.parseInt(session.getAttribute("codi").toString()));
                pr.setEstres("P");
                pr.setHostnameApr(nombreDePC);
                
                pr.setResexa(rtf);

                prDAO.edit(pr);

                ProcedimientosResultadosArchJpaController proceArchDAO= new ProcedimientosResultadosArchJpaController();
                ProcedimientosResultadosArchPK proceArchPk= new ProcedimientosResultadosArchPK(Integer.parseInt(invnum), Integer.parseInt(numitm),1);
                ProcedimientosResultadosArch proceArch=proceArchDAO.findProcedimientosResultadosArch(proceArchPk);
                if(proceArch==null){
                    proceArch= new ProcedimientosResultadosArch(proceArchPk);
                    proceArch.setNamfile("D:\\pdf\\" + nombrearchivo + ".pdf");
                    proceArchDAO.create(proceArch);
                }
                else{
                    proceArch.setNamfile("D:\\pdf\\" + nombrearchivo + ".pdf");
                    proceArchDAO.edit(proceArch);}
                
                
                ProcedimientosDetalleJpaController proceDetaDAO = new ProcedimientosDetalleJpaController();
                ProcedimientosDetallePK procePK = new ProcedimientosDetallePK(Integer.parseInt(invnum), Integer.parseInt(numitm));
                ProcedimientosDetalle proce = proceDetaDAO.findProcedimientosDetalle(procePK);
                proce.setEstexa("P");
                proce.setExaapr("S");
                proceDetaDAO.edit(proce);

                //ProcedimientosCabeceraJpaController proceCabeDAO = new ProcedimientosCabeceraJpaController();
                //ProcedimientosCabecera proceCabe = proceCabeDAO.findProcedimientosCabecera(Integer.parseInt(invnum));
                proceCabe.setEstord("P");
                proceCabeDAO.edit(proceCabe);
                
                

                out.print("{\"resultado\":\"ok\"}");
            } catch (Exception ex) {
                out.print("{\"resultado\":\""+ex.getMessage()+"\"}");
            } finally {
                em.close();
                emf.close();
            }
        }
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
