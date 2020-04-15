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
    
        public Usuario obtenerUsuario(String id) {
        Usuario r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Usuario(
                            rs.getString("id_usuario"),
                            rs.getString("clave_acceso"),
                            rs.getInt("clave_vencida"),
                            rs.getInt("rol")
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

//    public Optional<Usuario> obtenerUsuario(String id) {
//        Optional<Usuario> r = Optional.empty();
//        try (Connection cnx = obtenerConexion();
//                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR);) {
//            stm.clearParameters();
//            stm.setString(1, id);
//            try (ResultSet rs = stm.executeQuery()) {
//                if (rs.next()) {
//                    r = Optional.of(new Usuario(
//                            rs.getString("id_usuario"),
//                            rs.getString("clave_acceso"),
//                            rs.getInt("clave_vencida"),
//                            rs.getInt("rol")
//                    ));
//                }
//            }
//        } catch (IOException
//                | ClassNotFoundException
//                | IllegalAccessException
//                | InstantiationException
//                | SQLException ex) {
//            System.err.printf("Excepción: '%s'%n", ex.getMessage());
//        }
//        return r;
//    }

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

    public void agregarUsuario(Usuario u) {
  
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setString(1, u.getId_usuario());
            stm.setString(2, u.getClave_acceso());
            stm.setInt(3, u.getClave_vencida());
            stm.setInt(4, u.getRol());

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
        ServicioUsuario su = new ServicioUsuario();
        List<Usuario> usuarios = su.obtenerListaUsuarios();
        int i = 0;
        for (Usuario u : usuarios) {
            System.out.printf("%4d: %s,%n", ++i, u);
        }
    }

    private static final String CMD_RECUPERAR
            = "SELECT id_usuario, clave_acceso, clave_vencida, rol FROM usuario WHERE id_usuario=?; ";
    private static final String CMD_LISTAR
            = "SELECT  id_usuario, clave_acceso, clave_vencida, rol FROM usuario; ";
        private static final String CMD_AGREGAR = "INSERT INTO usuario "
            + "( id_usuario, clave_acceso, clave_vencida, rol) "
            + "VALUES(?, ?, ?, ?); ";
}
