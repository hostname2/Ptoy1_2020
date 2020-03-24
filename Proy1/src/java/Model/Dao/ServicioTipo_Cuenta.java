/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Moneda;
import Model.Tipo_Cuenta;
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
public class ServicioTipo_Cuenta {

    public Tipo_Cuenta obtenerTipo_Cuenta(String id) {
        Tipo_Cuenta r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Tipo_Cuenta(
                            rs.getInt("id_tipo_cuenta"),
                            rs.getString("descripcion"),
                            rs.getDouble("tasa_interes")
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

    public List<Tipo_Cuenta> obtenerListaTipo_Cuentas() {
        List<Tipo_Cuenta> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Tipo_Cuenta c = new Tipo_Cuenta(
                        rs.getInt("id_tipo_cuenta"),
                        rs.getString("descripcion"),
                        rs.getDouble("tasa_interes")
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

    public void agregarTipo_Cuenta(Tipo_Cuenta u) {

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setInt(1, u.getId_tipo_cuenta());
            stm.setString(2, u.getDescripcion());
            stm.setDouble(3, u.getTasa_interes());

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
            = "SELECT id_tipo_cuenta, descripcion, tasa_interes FROM tipo_cuenta WHERE id_tipo_cuenta=?; ";
    
    private static final String CMD_LISTAR
            = "SELECT id_tipo_cuenta, descripcion, tasa_interes FROM tipo_cuenta; ";
    
    private static final String CMD_AGREGAR = "INSERT INTO tipo_cuenta "
            + "(id_tipo_cuenta, descripcion, tasa_interes) "
            + "VALUES(?, ?, ?); ";
}
