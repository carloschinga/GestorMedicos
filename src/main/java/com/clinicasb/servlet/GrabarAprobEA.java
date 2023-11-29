/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.EaOrdenesCabeceraJpaController;
import com.clinicasb.dao.EaOrdenesDetalleJpaController;
import com.clinicasb.dao.EaResultadosImagenesJpaController;
import com.clinicasb.dao.EaResultadosJpaController;
import com.clinicasb.dao.MedicosJpaController;
import com.clinicasb.dto.EaOrdenesCabecera;
import com.clinicasb.dto.EaOrdenesDetalle;
import com.clinicasb.dto.EaOrdenesDetallePK;
import com.clinicasb.dto.EaResultados;
import com.clinicasb.dto.EaResultadosImagenes;
import com.clinicasb.dto.EaResultadosImagenesPK;
import com.clinicasb.dto.EaResultadosPK;
import com.clinicasb.dto.Medicos;
import com.clinicasb.util.Configuracion;
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
@WebServlet(name = "GrabarAprobEA", urlPatterns = {"/grabaraprobea"})
public class GrabarAprobEA extends HttpServlet {

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

            Configuracion configuracion = new Configuracion(getServletContext());
            String nombreunidad = configuracion.getValor("pdf.directorioEA");    //D:\\

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");
            EntityManager em = emf.createEntityManager();
            try {

                em.getTransaction().begin();
                java.sql.Connection cn = em.unwrap(java.sql.Connection.class);

                MedicosJpaController medicoDAO = new MedicosJpaController();
                Medicos medico = medicoDAO.findMedicos(medcod);

                Configuracion conf = new Configuracion(getServletConfig().getServletContext());
                conf.getValor("firma.app");
                String appURL = conf.getValor("firma.app") + "/" + medico.getNamFirm();
                String appLogo = conf.getValor("firma.app") + "/clinica.jpg";

                InputStream report = getServletConfig().getServletContext().getResourceAsStream("ResultadoEa.jasper");
                Map paramMap = new HashMap();
                paramMap.put("invnum", Integer.parseInt(invnum)); //19406
                paramMap.put("numitm", Integer.parseInt(numitm)); //1
                paramMap.put("rutaimagen", appURL); //http://localhost/gestormedico/firmas/firmapatologo2.png
                paramMap.put("rutalogo", appLogo); //http://localhost/gestormedico/firmas/firmapatologo2.png

                Date fechaActual = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
                String fechaFormateada = formato.format(fechaActual);

                EaOrdenesCabeceraJpaController eaCabeDAO = new EaOrdenesCabeceraJpaController();
                EaOrdenesCabecera eaCabe = eaCabeDAO.findEaOrdenesCabecera(Integer.parseInt(invnum));

                EaResultadosImagenesJpaController eaImgDAO = new EaResultadosImagenesJpaController();
                Integer num_img = eaImgDAO.getSigImg(Integer.parseInt(invnum), Integer.parseInt(numitm));

                String nombrearchivo = "E" + fechaFormateada + "_" + eaCabe.getCusnam().replace(" ", "_") + "-" + pachis + "-" + invnum + "-" + numitm + "_" + num_img;

                JasperPrint jasperPrint = JasperFillManager.fillReport(report, paramMap, cn);
                JasperExportManager.exportReportToPdfFile(jasperPrint, nombreunidad + nombrearchivo + ".pdf");
                cn.close();

                InetAddress localhost = InetAddress.getLocalHost();
                String nombreDePC = localhost.getHostName();
                EaResultadosJpaController eaDAO = new EaResultadosJpaController();
                EaResultadosPK eaPK = new EaResultadosPK(Integer.parseInt(invnum), Integer.parseInt(numitm));
                EaResultados ea = eaDAO.findEaResultados(eaPK);

                ea.setFecumv(new Date());
                //pr.setUsecod(Integer.parseInt(session.getAttribute("codi").toString()));              
                ea.setFeccreApr(new Date());
                ea.setUsecodApr(Integer.valueOf(session.getAttribute("codi").toString()));
                ea.setEstres("P");
                ea.setHostnameApr(nombreDePC);

                ea.setResexa(rtf);
                eaDAO.edit(ea);

                EaResultadosImagenesJpaController earImgDAO = new EaResultadosImagenesJpaController();
                EaResultadosImagenesPK earArchPk = new EaResultadosImagenesPK(Integer.parseInt(invnum), Integer.parseInt(numitm), num_img);
                EaResultadosImagenes earArch = earImgDAO.findEaResultadosImagenes(earArchPk);
                if (earArch == null) {
                    earArch = new EaResultadosImagenes(earArchPk);
                    earArch.setImgpath(nombreunidad + nombrearchivo + ".pdf");
                    earImgDAO.create(earArch);
                } else {
                    earArch.setImgpath(nombreunidad + nombrearchivo + ".pdf");
                    earImgDAO.edit(earArch);
                }

                EaOrdenesDetalleJpaController eaDetaDAO = new EaOrdenesDetalleJpaController();
                EaOrdenesDetallePK eaDetaPK = new EaOrdenesDetallePK(Integer.parseInt(invnum), Integer.parseInt(numitm));
                EaOrdenesDetalle proce = eaDetaDAO.findEaOrdenesDetalle(eaDetaPK);
                proce.setEstexa("P");
                proce.setExaapr("S");
                eaDetaDAO.edit(proce);

                eaCabe.setEstord("P");
                eaCabeDAO.edit(eaCabe);

                out.print("{\"resultado\":\"ok\"}");
               
            } catch (Exception ex) {
                out.print("{\"resultado\":\"error\",\"mensaje\":\"" + ex.getMessage() + "\"}");
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
