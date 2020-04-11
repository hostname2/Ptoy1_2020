/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Moneda;
import Model.Movimiento;
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
public class ServicioMovimiento {

    public Movimiento obtenerMovimiento(Integer id) {
        Movimiento r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setInt(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Movimiento(
                            rs.getInt("id_movimiento"),
                            rs.getString("cuenta_num_cuenta"),
                            rs.getDouble("monto"),
                            rs.getDate("fecha"),
                            rs.getInt("aplicado"),
                            rs.getString("movimientocol")
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

    public List<Movimiento> obtenerListaMovimiento() {
        List<Movimiento> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Movimiento c = new Movimiento(
                        rs.getInt("id_movimiento"),
                        rs.getString("cuenta_num_cuenta"),
                        rs.getDouble("monto"),
                        rs.getDate("fecha"),
                        rs.getInt("aplicado"),
                        rs.getString("movimientocol")
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

    public void agregarMovimiento(Movimiento u) {

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setInt(1,u.getId_movimiento());
            stm.setString(2,u.getNum_cuenta());
            stm.setDouble(3,u.getMonto());
            stm.setDate(4,(java.sql.Date)u.getFecha());
            stm.setInt(5,u.getAplicado());
            stm.setString(6,u.getMovimientocol());

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
            = "SELECT id_movimiento, cuenta_num_cuenta, monto, fecha, aplicado, movimientocol FROM movimiento WHERE id_movimiento=?; ";
    private static final String CMD_LISTAR
            = "SELECT id_movimiento, cuenta_num_cuenta, monto, fecha, aplicado, movimientocol FROM movimiento; ";
    private static final String CMD_AGREGAR = "INSERT INTO movimiento "
            + "( id_movimiento, cuenta_num_cuenta, monto, fecha, aplicado, movimientocol) "
            + "VALUES(?, ?, ?, ?, ?, ?); ";
}
