/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.WebMenuJpaController;
import com.clinicasb.dao.WebMenuPermisoJpaController;
import com.clinicasb.dao.WebMenuRolJpaController;
import com.clinicasb.dto.WebMenu;
import com.clinicasb.dto.WebMenuPermiso;
import com.clinicasb.dto.WebMenuRol;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "GestionRol", urlPatterns = {"/gestionrol"})
public class GestionRol extends HttpServlet {

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
            Gson g = new Gson();
            String resultado = "";
            String accion = request.getParameter("accion");
            switch (accion) {
                case "seleccionar":
                    String codigo = request.getParameter("codigo");
                    WebMenuRolJpaController wmrDAO = new WebMenuRolJpaController();
                    WebMenuRol wmr = wmrDAO.findWebMenuRol(Integer.parseInt(codigo));
                    resultado = g.toJson(wmr);
                    break;
                case "agregar":
                    try {
                        String nombre = request.getParameter("nombre");
                        wmr = new WebMenuRol();
                        // wmr.setCodrol(0);
                        wmr.setNomrol(nombre);
                        wmrDAO = new WebMenuRolJpaController();
                        wmrDAO.create(wmr);

                        WebMenuPermisoJpaController wmpDAO = new WebMenuPermisoJpaController();
                        WebMenuJpaController wmDAO = new WebMenuJpaController();
                        List<WebMenu> lista = wmDAO.listarHabilitados();//<---------------
                        for (WebMenu webMenu : lista) {
                            WebMenuPermiso wmp = new WebMenuPermiso(wmr.getCodrol(), webMenu.getCodmen());
                            wmp.setAsigperm(0);
                            wmpDAO.create(wmp);
                        }
                        resultado = "{\"resultado\":\"ok\"}";
                    } catch (Exception ex) {
                        resultado = "{\"resultado\":\"error\"}";
                    }
                    break;
                case "editar":
                    try {
                        codigo = request.getParameter("codigo");
                        String nombre = request.getParameter("nombre");
                        wmr = new WebMenuRol();
                        wmr.setCodrol(Integer.parseInt(codigo));
                        wmr.setNomrol(nombre);
                        wmrDAO = new WebMenuRolJpaController();
                        wmrDAO.edit(wmr);
                        resultado = "{\"resultado\":\"ok\"}";
                    } catch (Exception exe) {
                        resultado = "{\"resultado\":\"error\"}";
                    }
                    break;
            }
            out.print(resultado);
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
