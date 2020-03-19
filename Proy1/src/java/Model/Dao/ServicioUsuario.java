/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Usuario;
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
public class ServicioUsuario {

    public Optional<Usuario> obtenerUsuario(String id) {
        Optional<Usuario> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Usuario(
                            rs.getString("id_usuario"),
                            rs.getString("clave_acceso"),
                            rs.getInt("clave_vencida"),
                            rs.getInt("rol")
                    ));
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

    public List<Usuario> obtenerListaUsuarios() {
        List<Usuario> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("id_usuario"),
                        rs.getString("clave_acceso"),
                        rs.getInt("clave_vencida"),
                        rs.getInt("rol")
                );
                r.add(u);
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

    public void insertarUsuario(Usuario u) {
        String inserta;
        inserta = String.format("INSERT INTO usuario(id,clave_acceso, clave_vencida, rol) VALUES ('%s','%s',%d,%d); ", u.getId_usuario(), u.getClave_acceso(), u.getClave_vencida(), u.getRol());
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(inserta)) {
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
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
        ServicioUsuario su = new ServicioUsuario();
        List<Usuario> usuarios = su.obtenerListaUsuarios();
        int i = 0;
        for (Usuario u : usuarios) {
            System.out.printf("%4d: %s,%n", ++i, u);
        }
    }

    private static final String CMD_RECUPERAR
            = "SELECT id, clave_acceso, clave_vencida, rol FROM usuario WHERE id=?; ";
    private static final String CMD_LISTAR
            = "SELECT  id, clave_acceso, clave_vencida, rol FROM usuario; ";
    private static final String CMD_INSERTAR
            = "INSERT INTO usuario(id,clave_acceso, clave_vencida, rol) VALUES ('%s','%s',%d,%d); ";
}
