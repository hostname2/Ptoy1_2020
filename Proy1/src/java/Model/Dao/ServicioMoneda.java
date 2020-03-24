/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Moneda;
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
public class ServicioMoneda {
    
        public Moneda obtenerMoneda(String id) {
        Moneda r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Moneda(
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("simbolo"),
                            rs.getDouble("tipo_cambio_compra"),
                            rs.getDouble("tipo_cambio_venta")
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

    public List<Moneda> obtenerListaMonedas() {
        List<Moneda> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Moneda c = new Moneda(
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("simbolo"),
                            rs.getDouble("tipo_cambio_compra"),
                            rs.getDouble("tipo_cambio_venta")
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

    public void agregarMoneda(Moneda u) {

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setString(1, u.getNombre());
            stm.setString(2, u.getDescripcion());
            stm.setString(3, u.getSimbolo());
            stm.setDouble(4, u.getTipo_cambio_compra());
            stm.setDouble(4, u.getTipo_cambio_venta());
                    
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
            = "SELECT nombre, descripcion, simbolo, tipo_cambio_compra, tipo_cambio_venta FROM moneda WHERE nombre=?; ";
    private static final String CMD_LISTAR
            = "SELECT nombre, descripcion, simbolo, tipo_cambio_compra, tipo_cambio_venta FROM moneda; ";
    private static final String CMD_AGREGAR = "INSERT INTO moneda "
            + "( nombre, descripcion, simbolo, tipo_cambio_compra, tipo_cambio_venta) "
            + "VALUES(?, ?, ?, ?, ?); ";
}
