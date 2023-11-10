/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.MedicosJpaController;
import com.clinicasb.dto.Medicos;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "FileUpload", urlPatterns = {"/fileupload"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class FileUpload extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(true);
            String cod = session.getAttribute("medcod").toString();

            
            
            String uploadPath = getServletContext().getRealPath("");
            
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            uploadDir=uploadDir.getParentFile();
            uploadPath=uploadDir.getAbsolutePath()+ File.separator+"firmas"+File.separator;
            
            
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            String ruta = uploadPath + fileName;
            //String ruta="C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 9.0\\webapps\\firmas\\"+ fileName;
            for (Part part : request.getParts()) {
                part.write(ruta);
            }

            Medicos med = new Medicos();
            MedicosJpaController medDAO = new MedicosJpaController();
            med = medDAO.findMedicos(cod);
            med.setNamFirm(fileName);
            medDAO.edit(med);
            response.getWriter().print("{\"resultado\":\"ok\"}");
        } catch (Exception ex) {
            String mensaje="";
            mensaje=ex.getMessage();
        }

    }

}
