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
@WebServlet(name = "TransferenciaserviceCaja", urlPatterns = {"/TransferenciaserviceCaja", "/Administrador", "/TransferenciaCaja"})
public class TransferenciaserviceCaja extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String num_cuenta1 = request.getParameter("num_cuenta1");
        String num_cuenta2 = request.getParameter("num_cuenta2");
        String cantidad = request.getParameter("transferencia");

        //String id_cliente = request.getParameter("id_cliente");
        Double deposito = 0.0;
        
        if (cantidad != null && !"".equals(cantidad)) {
            deposito = Double.parseDouble(cantidad);
        }
        
        if ((num_cuenta1 != null && num_cuenta1.length() > 1) && (num_cuenta2 != null && num_cuenta2.length() > 1)) {
            Cuenta c1 = servicio.obtenerNumCuenta(num_cuenta1);
            Cuenta c2 = servicio.obtenerNumCuenta(num_cuenta2);
            if (c1 != null) {
                c1.setSaldo_final(c1.getSaldo_inicial() - deposito);
                c2.setSaldo_final(c2.getSaldo_inicial() + deposito);
                servicio.actualizarSaldo(c1);
                servicio.actualizarSaldo(c2);
            }
            //Actualizar el saldo en la base de datos 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/Administrador.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/TransferenciaCaja.jsp");
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
