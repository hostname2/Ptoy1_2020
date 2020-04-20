/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Model.Cliente;
import Model.Dao.ServicioCliente;
import Model.Dao.ServicioUsuario;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stringUtils.Util;

/**
 *
 * @author sebas
 */
@WebServlet(name = "Loginservice", urlPatterns = {"/RegistroserviceCaja", "/RegistroCliente"})
public class RegistroserviceCaja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id_usuario = request.getParameter("id_usuario");
        String rol_usuario = request.getParameter("rol_usuario");

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");

        if (id_usuario != null && id != null) {
            Usuario u = new Usuario();
            Cliente c = new Cliente();

            u.setId_usuario(id_usuario);
            u.setRol(Integer.parseInt(rol_usuario));
            u.setClave_vencida(0);
            u.setClave_acceso(Util.generate(8));

            System.out.print(u.getClave_acceso());

            c.setId_Cliente(id);
            c.setNombre(nombre);
            c.setId_usuario(id_usuario);
            c.setApellidos(apellidos);
            c.setTelefono(telefono);

            servicio_usuario.agregarUsuario(u);

            servicio_cliente.agregarCliente(c);
        }

        if (id_usuario != null && id != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/Administrador.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/RegistroCliente.jsp");
            dispatcher.forward(request, response);
        }

    }

    private final ServicioUsuario servicio_usuario = new ServicioUsuario();
    private final ServicioCliente servicio_cliente = new ServicioCliente();

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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
