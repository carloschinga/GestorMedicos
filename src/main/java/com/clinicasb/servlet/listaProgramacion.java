/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.ViewProgramacionMedicoDetalleDAO;
import com.clinicasb.dao.ViewProgramacionMedicoMedicoJpaController;
import com.clinicasb.dao.ViewProgramacionMedicoServicioJpaController;
import com.clinicasb.dto.ViewProgramacionMedicoDeta;
import com.clinicasb.dto.ViewProgramacionMedicoMedico;
import com.clinicasb.dto.ViewProgramacionMedicoServicio;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "listaProgramacion", urlPatterns = {"/listaprogramacion"})
public class listaProgramacion extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            try {
                Gson g = new Gson();
                String tipo = request.getParameter("tabla");
                switch (tipo) {
                    case "servicio":
                        ViewProgramacionMedicoServicioJpaController servicioDAO = new ViewProgramacionMedicoServicioJpaController();
                        List<ViewProgramacionMedicoServicio> lista = servicioDAO.findViewProgramacionMedicoServicioEntities();
                        ViewProgramacionMedicoServicioJpaController dao = new ViewProgramacionMedicoServicioJpaController();
                        Collections.sort(lista);
                        String resultado = g.toJson(lista);
                        out.print("{\"data\":" + resultado + "}");
                        break;
                    case "medico":
                        String sercod = request.getParameter("sercod");
                        ViewProgramacionMedicoMedicoJpaController medicoDAO = new ViewProgramacionMedicoMedicoJpaController();
                        List<ViewProgramacionMedicoMedico> listaMedico = medicoDAO.listarMedicoXServicio(sercod);
                        Collections.sort(listaMedico);
                        resultado = g.toJson(listaMedico);
                        out.print("{\"data\":" + resultado + "}");
                        break;
                    case "detalle":
                        String medcod = request.getParameter("medcod");
                        sercod = request.getParameter("sercod");
                        String periodo= request.getParameter("periodo");
                        periodo=periodo.replace("-","");
                        List<ViewProgramacionMedicoDeta> listaDetalle = ViewProgramacionMedicoDetalleDAO.listar(medcod,sercod, periodo);
                        out.print("{\"data\":" + g.toJson(listaDetalle) + "}");
                        break;
                    case "consultorio":
                        String fecha = request.getParameter("fecha");                        
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");        
                        Date d=formato.parse(fecha);
                        List<ViewProgramacionMedicoDeta> listaConsultorio=ViewProgramacionMedicoDetalleDAO.listarXConsultorio(d);
                        out.print("{\"data\":" + g.toJson(listaConsultorio) + "}");
                        break;
                          
                    default:
                        throw new AssertionError();
                }

            } catch (Exception ex) {
                out.print("{\"data\":\"error\"}");
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
