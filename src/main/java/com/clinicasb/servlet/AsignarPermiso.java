/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.UsuariosJpaController;
import com.clinicasb.dao.ViewWebUsuariosJpaController;
import com.clinicasb.dao.WebMenuPermisoJpaController;
import com.clinicasb.dao.WebMenuRolJpaController;
import com.clinicasb.dto.Node;
import com.clinicasb.dto.Usuarios;
import com.clinicasb.dto.ViewWebUsuarios;
import com.clinicasb.dto.WebMenuPermiso;
import com.clinicasb.dto.WebMenuPermisoPK;
import com.clinicasb.dto.WebMenuRol;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
@WebServlet(name = "AsignarPermiso", urlPatterns = {"/asignarpermiso"})
public class AsignarPermiso extends HttpServlet {

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
            String resultado = "";
            String accion = request.getParameter("accion");
            switch (accion) {
                case "listausuario":
                    ViewWebUsuariosJpaController usuDAO = new ViewWebUsuariosJpaController();
                    List<ViewWebUsuarios> lista = usuDAO.findViewWebUsuariosEntities();
                    Collections.sort(lista);
                    Gson g = new Gson();
                    resultado = g.toJson(lista);
                    resultado = "{\"data\":" + resultado + "}";
                    break;
                case "listarol":
                    WebMenuRolJpaController rolDAO = new WebMenuRolJpaController();
                    List<WebMenuRol> listaRol = rolDAO.findWebMenuRolEntities();
                    g = new Gson();
                    resultado = g.toJson(listaRol);
                    resultado = "{\"data\":" + resultado + "}";
                    break;
                case "asignarAcceso":
                    try {
                        String codrol = request.getParameter("codrol");
                        g = new Gson();
                        WebMenuPermisoJpaController wmpDAO = new WebMenuPermisoJpaController();
                        wmpDAO.quitarPermisos(Integer.parseInt(codrol));
                        String selected = request.getParameter("selected");
                        Node[] ndArray = g.fromJson(selected, Node[].class);
                        List<Node> listaNodos = new ArrayList<>(Arrays.asList(ndArray));
                        for (Node nodo : listaNodos) {
                            WebMenuPermiso wmp = new WebMenuPermiso();
                            WebMenuPermisoPK wmpPK = new WebMenuPermisoPK();
                            wmpPK.setCodrol(Integer.parseInt(codrol));
                            wmpPK.setCodmen(nodo.getId());
                            if (nodo.isState()) {
                                wmp.setAsigperm(1);
                            } else {
                                wmp.setAsigperm(0);
                            }
                            wmp.setWebMenuPermisoPK(wmpPK);
                            wmpDAO.edit(wmp);
                        }
                        resultado = "{\"resultado\":\"ok\"}";
                    } catch (Exception ex) {
                        resultado = "{\"resultado\":\"error\"}";
                    }
                    break;
                case "asignarRol":
                     try {
                        String codusu = request.getParameter("codusu");
                        String codrol = request.getParameter("codrol");
                        UsuariosJpaController usuDAO1 = new UsuariosJpaController();
                        Usuarios usu = new Usuarios();                        
                        usu=usuDAO1.findUsuarios(Integer.parseInt(codusu));
                        usu.setRolweb(Integer.parseInt(codrol));
                        usuDAO1.edit(usu);
                        resultado = "{\"resultado\":\"ok\"}";
                    } catch (Exception ex) {
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
