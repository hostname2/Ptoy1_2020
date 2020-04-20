/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Cliente;
import datos.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

/**
 *
 * @author sebas
 */
public class ServicioCliente {

    public Cliente obtenerCliente(String id) {
        Cliente r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Cliente(
                            rs.getString("id_cliente"),
                            rs.getString("usuario_id_usuario"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("telefono")
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

    public List<Cliente> obtenerListaClientes() {
        List<Cliente> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Cliente c = new Cliente(
                            rs.getString("id_cliente"),
                            rs.getString("usuario_id_usuario"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("telefono")
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

    public void agregarCliente(Cliente u) {

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setString(1, u.getId_Cliente());
            stm.setString(2, u.getId_usuario());
            stm.setString(3, u.getNombre());
            stm.setString(4, u.getApellidos());
            stm.setString(5, u.getTelefono());
            
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
        ServicioCliente su = new ServicioCliente();
        List<Cliente> usuarios = su.obtenerListaClientes();
        int i = 0;
        for (Cliente u : usuarios) {
            System.out.printf("%4d: %s,%n", ++i, u);
        }
    }

    private final ServicioUsuario su = new ServicioUsuario();

    private static final String CMD_RECUPERAR
            = "SELECT id_cliente, usuario_id_usuario, nombre, apellidos, telefono FROM cliente WHERE usuario_id_usuario=?; ";
    private static final String CMD_LISTAR
            = "SELECT id_cliente, usuario_id_usuario, nombre, apellidos, telefono FROM cliente; ";
    private static final String CMD_AGREGAR = "INSERT INTO cliente "
            + "(id_cliente, usuario_id_usuario, nombre, apellidos, telefono) "
            + "VALUES(?, ?, ?, ?,?); ";
}
