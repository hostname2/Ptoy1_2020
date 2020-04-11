/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Moneda;
import Model.Movimiento;
import Model.Transferencia;
import datos.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author sebas
 */
public class ServicioTransferencia {

    public Transferencia obtenerTransferencia(Integer id) {
        Transferencia r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setInt(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Transferencia(
                            rs.getInt("id_transferencia"),
                            rs.getString("cuenta_origen"),
                            rs.getString("cuenta_destino"),
                            rs.getDouble("monto"),
                            rs.getDate("fecha"),
                            rs.getInt("aplicado")
                    );
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public List<Transferencia> obtenerListaTransferencia() {
        List<Transferencia> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Transferencia c = new Transferencia(
                        rs.getInt("id_transferencia"),
                        rs.getString("cuenta_origen"),
                        rs.getString("cuenta_destino"),
                        rs.getDouble("monto"),
                        rs.getDate("fecha"),
                        rs.getInt("aplicado")
                );
                r.add(c);
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public void agregarTransferencia(Transferencia u) {

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();

            stm.setInt(1,u.getId_transferencia());
            stm.setString(2,u.getCuenta_origen());
            stm.setString(3,u.getCuenta_destino());
            stm.setDouble(4,u.getMonto());
            stm.setDate(5,(java.sql.Date)u.getFecha());
            stm.setInt(6,u.getAplicado());

            if (stm.executeUpdate() != 1) {
                throw new Exception("Error no determinado");
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

    }

    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Properties cfg = bd.obtenerConfiguracion();
        Connection cnx = bd.obtenerConexion(
                cfg.getProperty("database"),
                cfg.getProperty("user"),
                cfg.getProperty("password")
        );
        return cnx;
    }

    public static void main(String[] args) {
        ServicioMoneda su = new ServicioMoneda();
        List<Moneda> usuarios = su.obtenerListaMonedas();
        int i = 0;
        for (Moneda u : usuarios) {
            System.out.printf("%4d: %s,%n", ++i, u);
        }
    }

    private static final String CMD_RECUPERAR
            = "SELECT id_transferencia, cuenta_origen, cuenta_destino, monto, fecha, aplicado FROM transferencia WHERE id_transferencia=?; ";
    private static final String CMD_LISTAR
            = "SELECT id_transferencia, cuenta_origen, cuenta_destino, monto, fecha, aplicado FROM transferencia; ";
    private static final String CMD_AGREGAR = "INSERT INTO transferencia "
            + "(id_transferencia, cuenta_origen, cuenta_destino, monto, fecha, aplicado) "
            + "VALUES(?, ?, ?, ?, ?, ?); ";
}
