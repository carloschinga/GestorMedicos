/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.util.Configuracion;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "Config", urlPatterns = {"/config"})
public class Config extends HttpServlet {

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
            String resultado = "";

            try {
                
                Configuracion configuracion = new Configuracion(getServletContext());
                String nombreunidadPM = configuracion.getValor("pdf.directorioPM");
                String nombreunidadLA = configuracion.getValor("pdf.directorioLA");
                String nombreunidadEA = configuracion.getValor("pdf.directorioEA");
                
                String directoriodeFirmas = configuracion.getValor("firma.app");
                resultado = "{\"resultado\":\"ok\",\"rutapdfPM\":\"" + nombreunidadPM+ "\",\"rutapdfLA\":\"" + nombreunidadLA+ "\",\"rutapdfEA\":\"" + nombreunidadEA+ "\",\"directoriofirmas\":\""+directoriodeFirmas+"\" }";
            } catch (Exception ex) {
                resultado = "{\"resultado\":\"error\",\"mensaje\":\"" + ex.getMessage() + "\"}";
            }
            /*Properties properties = new Properties();
            try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/config.properties")) {
                if (input == null) {
                    System.out.println("No se puede encontrar el archivo config.properties");
                    return;
                }
                properties.load(input);
                resultado = "{\"resultado\":\"ok\",\"rutapdf\":\"" + properties.getProperty("pdf.directorio") + "\",\"directoriofirmas\":\""+properties.getProperty("fima.directorio")+"\" }";
            } catch (IOException ex) {
                resultado = "{\"resultado\":\"error\"}";
            }*/

            out.println(resultado);
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
