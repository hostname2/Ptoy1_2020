/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Cuenta;
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
import stringUtils.DateConversion;

/**
 *
 * @author sebas
 */
public class ServicioCuenta {

    public Cuenta obtenerNumCuenta(String id) {
        Cuenta r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR_NC);) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Cuenta(
                            rs.getString("num_cuenta"),
                            rs.getDate("fecha_creacion"),
                            rs.getDate("fecha_ultima_aplicacion"),
                            rs.getDouble("limite_transferencia_diaria"),
                            rs.getInt("activa"),
                            rs.getDouble("saldo_final"),
                            rs.getDouble("saldo_final"),
                            rs.getString("cliente_id_cliente"),
                            rs.getString("moneda_nombre"),
                            rs.getInt("tipo_cuenta_id_tipo_cuenta")
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

    public Cuenta obtenerCuenta(String id) {
        Cuenta r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR_ID);) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Cuenta(
                            rs.getString("num_cuenta"),
                            rs.getDate("fecha_creacion"),
                            rs.getDate("fecha_ultima_aplicacion"),
                            rs.getDouble("limite_transferencia_diaria"),
                            rs.getInt("activa"),
                            rs.getDouble("saldo_final"),
                            rs.getDouble("saldo_final"),
                            rs.getString("cliente_id_cliente"),
                            rs.getString("moneda_nombre"),
                            rs.getInt("tipo_cuenta_id_tipo_cuenta")
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

    public List<Cuenta> obtenerListaCuenta() {
        List<Cuenta> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Cuenta c = new Cuenta(
                        rs.getString("num_cuenta"),
                        rs.getDate("fecha_creacion"),
                        rs.getDate("fecha_ultima_aplicacion"),
                        rs.getDouble("limite_transferencia_diaria"),
                        rs.getInt("activa"),
                        rs.getDouble("saldo_final"),
                        rs.getDouble("saldo_final"),
                        rs.getString("cliente_id_cliente"),
                        rs.getString("moneda_nombre"),
                        rs.getInt("tipo_cuenta_id_tipo_cuenta")
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

    public void agregarCuenta(Cuenta u) {

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setString(1, u.getNumero_Cuneta());
            stm.setInt(2, u.getId_cuenta());
            stm.setString(3, u.getId_cliente());
            stm.setString(4, u.getId_moneda());
            stm.setDate(5, DateConversion.util2sql(u.getFecha_creacion()));
            // stm.setDate(5, (java.sql.Date)u.getFecha_creacion());
            stm.setDouble(6, u.getLimite_transferencia());
            stm.setInt(7, u.getActiva());
            stm.setDouble(8, u.getSaldo_inicial());
            stm.setDate(9, DateConversion.util2sql(u.getFecha_ultimaAplicacion()));
            stm.setDouble(10, u.getSaldo_final());

            if (stm.executeUpdate() != 1) {
                throw new Exception("Error no determinado");
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

    }

    public void actualizarSaldo(Cuenta u) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR)) {
            stm.clearParameters();
            stm.setDouble(1, u.getSaldo_final());
            stm.setString(2, u.getNumero_Cuneta());

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
        ServicioCuenta su = new ServicioCuenta();
        List<Cuenta> usuarios = su.obtenerListaCuenta();
        int i = 0;
        for (Cuenta u : usuarios) {
            System.out.printf("%4d: %s,%n", ++i, u);
        }
    }
    private static final String CMD_RECUPERAR_NC
            = "SELECT num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion, limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final FROM cuenta WHERE num_cuenta=?; ";
    private static final String CMD_RECUPERAR_ID
            = "SELECT num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion, limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final FROM cuenta WHERE cliente_id_cliente=?; ";
    private static final String CMD_LISTAR
            = "SELECT num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion, limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final FROM cuenta; ";
    private static final String CMD_AGREGAR = "INSERT INTO cuenta "
            + "(num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion, limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
    private static final String CMD_ACTUALIZAR = "update cuenta set saldo_final = ? where num_cuenta = ?;";
}
