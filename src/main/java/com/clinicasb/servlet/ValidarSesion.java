/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.util.Token;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ValidarSesion", urlPatterns = {"/validarsesion"})
public class ValidarSesion extends HttpServlet {

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
                Cookie[] cookies = request.getCookies();
                String token = "";
                String logivs = "";
                String logivsd = "";
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("token".equals(cookie.getName())) {
                            token = cookie.getValue();
                        }
                        if ("logi".equals(cookie.getName())) {
                            logivs = cookie.getValue();
                        }
                    }

                }
                logivsd = Token.getUsernameFromToken(token);

                if (logivsd.equals(logivs)) {
                    HttpSession session = request.getSession(true);
                    String logueado = session.getAttribute("logueado").toString();
                    String logi = session.getAttribute("logi").toString();
                    String nombre = session.getAttribute("nombre").toString();
                    String nivel = session.getAttribute("nivel").toString();
                    if (logueado == null) {
                        out.println("{\"resultado\":\"error\"}");
                    } else {
                        if (session.getAttribute("logueado").toString().equals("1")) {
                            out.println("{\"resultado\":\"ok\",\"logi\":\"" + logi + "\",\"nombre\":\"" + nombre + "\",\"nivel\":\"" + nivel + "\",\"token\":\"" + token + "\",\"logi\":\"" + logivs + "\"}");
                        } else {
                            out.println("{\"resultado\":\"error\"}");
                        }
                    }
                } else {
                    out.println("{\"resultado\":\"error\"}" + logivsd);
                }
            } catch (Exception ex) {
                out.println("{\"resultado\":\"error\"}");
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
