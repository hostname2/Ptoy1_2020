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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CuentaRegistroadmin", urlPatterns = {"/CuentaRegistroadmin", "/Administrador", "/VentanaCreacuenta"})
public class CuentaRegistroadmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String num_cuenta = request.getParameter("num_cuenta");
        String cliente_id_cliente = request.getParameter("cliente_id_cliente");
        String tipo_cuenta_id_tipo_cuenta = request.getParameter("tipo_cuenta_id_tipo_cuenta");
        String moneda_nombre = request.getParameter("moneda_nombre");
        //String fecha_creacion = request.getParameter("fecha_creacion");
        Date fecha_creacion = new Date();
        String limite_transferencia_diaria = request.getParameter("limite_transferencia_diaria");
        String activa = request.getParameter("activa");
        String saldo_inicial = request.getParameter("saldo_inicial");
        String fecha_ultima_aplicacion = request.getParameter("fecha_ultima_aplicacion");
        String saldo_final = request.getParameter("saldo_inicial");

        if (num_cuenta != null && !"".equals(num_cuenta)) {
            Cuenta c = new Cuenta();

            c.setNumero_Cuneta(num_cuenta);
            c.setId_cliente(cliente_id_cliente);
            c.setId_cuenta(Integer.parseInt(tipo_cuenta_id_tipo_cuenta));
            c.setId_moneda(moneda_nombre);

            c.setLimite_transferencia(Double.valueOf(limite_transferencia_diaria));
            c.setActiva(Integer.parseInt("1"));
//                        c.setActiva(Integer.parseInt(activa));
            c.setSaldo_inicial(Double.valueOf(saldo_inicial));
//            try {
            c.setFecha_creacion(fecha_creacion);
            c.setFecha_ultimaAplicacion(fecha_creacion);
//            } catch (ParseException ex) {
//                System.out.print("error en el parse de fecha servlet CuentaRegistroAdmin");
//            }
            c.setSaldo_final(Double.valueOf(saldo_final));
            servicio.agregarCuenta(c);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/Administrador.jsp");
            dispatcher.forward(request, response);
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vista/VentanaCreacuenta.jsp");
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
