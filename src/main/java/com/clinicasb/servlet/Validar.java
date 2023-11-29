/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.MedicosJpaController;
import com.clinicasb.dao.UsuarioDAO;
import com.clinicasb.dto.Medicos;
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
import com.clinicasb.util.Token;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "validar", urlPatterns = {"/validar"})
public class Validar extends HttpServlet {

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
            String tokenc = "";
            String resultado="";
            String user = request.getParameter("logi");
            tokenc = Token.generateToken(user);
            String pass = request.getParameter("pass");
            try{
                pass = Cripto.toHexString(getSHA(pass.toUpperCase()));
            }catch(Exception ex){
                resultado="{\"resultado\":\"error\",\"mensaje\":\"Problemas con la clave\"}";
            }
            if (!pass.trim().equals("")) {
                Usuarios u = UsuarioDAO.logueo(user, pass);
                if (u != null) {
                    MedicosJpaController medicoDAO= new MedicosJpaController();
                    Medicos medico= medicoDAO.getMedicoXUsecodx(u.getUsecod());
                    if(medico!=null){
                        resultado="{\"resultado\":\"ok\",\"codi\":\""+u.getUsecod()+"\",\"user\":\"" + u.getUseusr()+ "\",\"name\":\"" + u.getUsenam() + "\",\"nivel\":\""+u.getAdmiweb()+"\",\"medcod\":\""+ medico.getMedcod()+"\",\"token\":\""+ tokenc+"\",\"logi\":\""+ user+"\"}";
                    }
                    else{
                        resultado="{\"resultado\":\"error\",\"mensaje\":\"El usuario NO tiene un código de Médico asociado\"}";
                    }
                } else {
                    resultado="{\"resultado\":\"error\",\"mensaje\":\"" + UsuarioDAO.getMensaje() + "\"}";
                }
            }
            else{
                resultado="{\"resultado\":\"error\",\"mensaje\":\"La clave debe tener valor\"}";
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
