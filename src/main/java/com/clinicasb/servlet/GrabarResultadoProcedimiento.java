/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.ProcedimientosResultadosJpaController;
import com.clinicasb.dto.ProcedimientosResultados;
import com.clinicasb.dto.ProcedimientosResultadosPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "GrabarResultadoProcedimiento", urlPatterns = {"/grabarresultadoprocedimiento"})
public class GrabarResultadoProcedimiento extends HttpServlet {

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
            String tarcod = request.getParameter("tarcod");
            String medcod = session.getAttribute("medcod").toString();
            String htmlContent = request.getParameter("htmlContent");
            //String rtfContent = request.getParameter("rtfContent");

            InetAddress localhost = InetAddress.getLocalHost();
            String nombreDePC = localhost.getHostName();

            try {
                ProcedimientosResultadosJpaController prDAO = new ProcedimientosResultadosJpaController();
                ProcedimientosResultadosPK prPK = new ProcedimientosResultadosPK(Integer.parseInt(invnum), Integer.parseInt(numitm));
                ProcedimientosResultados pr = prDAO.findProcedimientosResultados(prPK);
                if (pr == null) {
                    pr = new ProcedimientosResultados(prPK);
                    b = true;
                }
                pr.setTarcod(tarcod);
                pr.setDatres(new Date());
                pr.setResexa("");
                pr.setEstres("G");
                pr.setMedcod(medcod);
                pr.setEstado("S");
                pr.setFeccre(new Date());
                pr.setFecumv(new Date());
                pr.setUsecod(Integer.parseInt(session.getAttribute("codi").toString()));
                pr.setUsenam(session.getAttribute("logi").toString());
                pr.setHostname(nombreDePC);
                //pr.setFeccreApr(new Date());
                //pr.setUsecodApr(Integer.parseInt(session.getAttribute("codi").toString()));
                //pr.setHostnameApr(nombreDePC);
                pr.setExadat(new Date());
                pr.setResexahml(htmlContent);

                if (b) {
                    prDAO.create(pr);
                } else {
                    prDAO.edit(pr);
                }                
                out.print("{\"resultado\":\"ok\"}");
            } catch (Exception ex) {
                out.print("{\"resultado\":\"error\",\"mensaje\":\""+ex.getMessage()+"\"}");
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
