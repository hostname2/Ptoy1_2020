/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Model.Dao.ServicioUsuario;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebas
 */
public class Loginservlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            boolean flag = true;
            Usuario u = null;

            String id_usuario = request.getParameter("id");
            String usuario_password = request.getParameter("id=password");

            //falta validar el id y contraseHna
            if (id_usuario != null && usuario_password != null) {
                u = servicio.obtenerUsuario(id_usuario);
                flag = this.valida(u, id_usuario, id_usuario);
            } else {
                flag = false;
            }

            if (flag) {
                String destino = "login.jsp";
                switch (u.getRol()) {

                    case 0:
                        destino = "/WEB-INF/ejemplo/vista/Administrador.jsp";
                        request.setAttribute("registroUsuario", u);
                        break;
                    case 1:
                        destino = "/WEB-INF/ejemplo/vista/Cliente.jsp";
                        request.setAttribute("registroUsuario", u);
                        break;
                    default:
                        System.err.printf("La operación seleccionada es incorrecta: %d%n", u.getRol());
                        break;
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
                dispatcher.forward(request, response);
            }

    }

    private boolean valida(Usuario u, String id, String clave) {
        return (u.getId_usuario().equals(id) && u.getClave_acceso().equals(clave));
    }

    private final ServicioUsuario servicio = new ServicioUsuario();

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
