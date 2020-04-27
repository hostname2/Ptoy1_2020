package Servicios;

import Model.Cliente;
import Model.Cuenta;
import Model.Dao.ServicioCliente;
import Model.Dao.ServicioCuenta;
import Model.Dao.ServicioFavorita;
import Model.Favorita;
import Model.Usuario;
import beans.BeanUsuario;
import beans.Clientebean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grelvin
 */
@WebServlet(name = "vincularService", urlPatterns = {"/vincularService", "/vincular", "/Cliente"})
public class vincularService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String num_cuenta = request.getParameter("num_cuenta");
        HttpSession sesion = request.getSession(true);
        Usuario bu = (Usuario) sesion.getAttribute("id");

        if (num_cuenta != null) {
            Cuenta c = sc.obtenerNumCuenta(num_cuenta);
            Cliente cl = scl.obtenerCliente(bu.getId_usuario());
            if (c != null) {
                Favorita fav = new Favorita(cl.getId_Cliente(), c.getNumero_Cuneta());
                sf.agregarFavorita(fav);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("vincular.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/Cliente.jsp");
            dispatcher.forward(request, response);
        }

    }

    ServicioFavorita sf = new ServicioFavorita();
    ServicioCuenta sc = new ServicioCuenta();
    ServicioCliente scl = new ServicioCliente();

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
