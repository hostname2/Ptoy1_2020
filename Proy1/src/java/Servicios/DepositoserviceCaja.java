/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Model.Cuenta;
import Model.Dao.ServicioCuenta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebas
 */
@WebServlet(name = "DepositoserviceCaja", urlPatterns = {"/DepositoserviceCaja", "/Administrador", "/DepositoCaja"})
public class DepositoserviceCaja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String num_cuenta = request.getParameter("num_cuenta");
        String cantidad = request.getParameter("deposito");
        Integer deposito = 0;
        if (cantidad != null && !"".equals(cantidad)) {
            deposito = Integer.parseInt(request.getParameter("deposito"));
        }

        if (num_cuenta != null && num_cuenta.length() > 1) {
            Cuenta c = servicio.obtenerNumCuenta(num_cuenta);
            if (c != null) {
                c.setSaldo_final(c.getSaldo_inicial() + deposito);
                servicio.actualizarSaldo(c);
            }
            //Actualizar el saldo en la base de datos 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/Administrador.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/DepositoCaja.jsp");
            dispatcher.forward(request, response);
        }
    }

    private final ServicioCuenta servicio = new ServicioCuenta();

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
