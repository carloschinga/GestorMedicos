/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.UsuarioDAO;
import com.clinicasb.dto.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.clinicasb.util.Cripto;
import static com.clinicasb.util.Cripto.getSHA;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "UsuarioCRUD", urlPatterns = {"/usuariocrud"})
public class UsuarioCRUD extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                String accion = request.getParameter("accion");
                String user = request.getParameter("usuario");
                Usuarios usuario= UsuarioDAO.buscarPorLogi(user);     
                
                switch (accion) {
                    case "1": //reestablecer
                        String nuevaClave=Cripto.toHexString(getSHA(user));
                        usuario.setPassweb(nuevaClave);                 
                        usuario.setRolweb(1);
                        if(UsuarioDAO.modificar(usuario)){
                            out.print("{\"resultado\":\"ok\",\"mensaje\":\"Se reestableció la contraseña correctamente\"}");
                        }
                        else{
                            out.println("{\"resultado\":\"error\",\"mensaje\":\"" + UsuarioDAO.getMensaje() + "\"}");
                        }                        
                        break;
                    case "2"://borrar
                        usuario.setPassweb(null);                 
                        if(UsuarioDAO.modificar(usuario)){
                            out.print("{\"resultado\":\"ok\",\"mensaje\":\"Se borró la contraseña correctamente\"}");
                        }
                        else{
                            out.println("{\"resultado\":\"error\",\"mensaje\":\"" + UsuarioDAO.getMensaje() + "\"}");
                        }                        
                        break;
                }
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
