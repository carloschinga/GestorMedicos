/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ReporteResultadoProceMostrarPDF", urlPatterns = {"/reporteresultadoprocemostrarPDF"})
public class ReporteResultadoProcePDFMostrar extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        
        String archivo= request.getParameter("archivo");
        // Ruta al archivo PDF que deseas abrir
        String filePath = archivo;

        // Configurar el tipo de contenido y el encabezado de respuesta
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename="+archivo+".pdf");

        // Abrir el archivo PDF
        File pdfFile = new File(filePath);
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(pdfFile)); OutputStream outputStream = response.getOutputStream()) {

            // Leer el archivo PDF y escribirlo en el flujo de salida de respuesta
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Manejar cualquier error de lectura o escritura aquí
            e.printStackTrace();
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
