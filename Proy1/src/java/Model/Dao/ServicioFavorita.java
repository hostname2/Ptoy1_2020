/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Favorita;
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
public class ServicioFavorita {

    public Favorita obtenerFavorita(String cliente,String cuenta) {
        Favorita r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setString(1, cliente);
            stm.setString(2, cuenta);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Favorita(
                            rs.getString("cliente_id_cliente"),
                            rs.getString("cuenta_num_cuenta")
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

    public List<Favorita> obtenerListaFavorita() {
        List<Favorita> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Favorita c = new Favorita(
                            rs.getString("cliente_id_cliente"),
                            rs.getString("cuenta_num_cuenta")
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

    public void agregarFavorita(Favorita u) {

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setString(1, u.getId_cliente());
            stm.setString(2, u.getId_cuenta());
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
        ServicioFavorita su = new ServicioFavorita();
        List<Favorita> usuarios = su.obtenerListaFavorita();
        int i = 0;
        for (Favorita u : usuarios) {
            System.out.printf("%4d: %s,%n", ++i, u);
        }
    }

    private static final String CMD_RECUPERAR
            = "SELECT cliente_id_cliente, cuenta_num_cuenta FROM favorita WHERE cliente_id_cliente=? AND cuenta_num_cuenta=?; ";
    private static final String CMD_LISTAR
            = "SELECT cliente_id_cliente, cuenta_num_cuenta FROM favorita; ";
    private static final String CMD_AGREGAR = "INSERT INTO favorita "
            + "( cliente_id_cliente, cuenta_num_cuenta) "
            + "VALUES(?, ?); ";
}
