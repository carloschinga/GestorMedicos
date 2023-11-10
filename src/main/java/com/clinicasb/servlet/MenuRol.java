/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.ViewWebMenuDetaJpaController;
import com.clinicasb.dao.ViewWebMenuDetaRolJpaController;
import com.clinicasb.dto.ViewWebMenuDeta;
import com.clinicasb.dto.ViewWebMenuDetaRol;
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
@WebServlet(name = "MenuRol", urlPatterns = {"/menurol"})
public class MenuRol extends HttpServlet {

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
            String codrol = request.getParameter("codrol");
            ViewWebMenuDetaRolJpaController menuDetaRolDAO = new ViewWebMenuDetaRolJpaController();
            List<ViewWebMenuDetaRol> lista = menuDetaRolDAO.listarXCodRol(Integer.parseInt(codrol));

            String resultado = "";
            for (ViewWebMenuDetaRol viewWebMenuDetaRol : lista) {
                if (viewWebMenuDetaRol.getCodmas() == 0) {
                    if (viewWebMenuDetaRol.getAsigperm()==1) {
                        resultado += "{ \"id\" : \"" + viewWebMenuDetaRol.getCodmen() + "\", \"parent\" : \"#\", \"text\" : \"" + viewWebMenuDetaRol.getNommen() + "\" ,\"state\":{\"selected\":true}},";
                    } else {
                        resultado += "{ \"id\" : \"" + viewWebMenuDetaRol.getCodmen() + "\", \"parent\" : \"#\", \"text\" : \"" + viewWebMenuDetaRol.getNommen() + "\"},";
                    }
                } else  if(viewWebMenuDetaRol.getCodmas()!=-1 ){
                    if (viewWebMenuDetaRol.getAsigperm()==1) {
                        resultado += "{ \"id\" : \"" + viewWebMenuDetaRol.getCodmen() + "\", \"parent\" : \"" + viewWebMenuDetaRol.getCodmas() + "\", \"text\" : \"" + viewWebMenuDetaRol.getNommen() + "\" ,\"state\":{\"selected\":true}},";
                    } else {
                        resultado += "{ \"id\" : \"" + viewWebMenuDetaRol.getCodmen() + "\", \"parent\" : \"" + viewWebMenuDetaRol.getCodmas() + "\", \"text\" : \"" + viewWebMenuDetaRol.getNommen() + "\"},";
                    }
                }

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
