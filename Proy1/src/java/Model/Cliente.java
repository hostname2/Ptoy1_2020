/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.sun.javafx.binding.StringFormatter;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class Cliente {

    public Cliente(String id_Cliente, String id_usuario, String apellidos, String nombre, String telefono) {
        this.id_Cliente = id_Cliente;
        this.id_usuario = id_usuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    
    
    public Cliente(String id_Cliente, Usuario ptr_Usuario, String apellidos, String nombre, String telefono) {
        this.id_Cliente = id_Cliente;
        this.ptr_Usuario = ptr_Usuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.lista_cuenta = null;
        this.lista_favorita = null;
    }
    
        public Cliente(String id_Cliente, String apellidos, String nombre, String telefono) {//constructor sin usuario por parametro ni cuenta , ni favoritas
        this.id_Cliente = id_Cliente;
        this.ptr_Usuario = null;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.lista_cuenta = null;
        this.lista_favorita = null;
    }

    public Cliente(String id_Cliente, Usuario ptr_Usuario, String apellidos, String nombre, String telefono, ArrayList<Cuenta> lista_cuenta, ArrayList<Favorita> lista_favorita) {
        this.id_Cliente = id_Cliente;
        this.ptr_Usuario = ptr_Usuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.lista_cuenta = lista_cuenta;
        this.lista_favorita = lista_favorita;
    }

    public Cliente() {
        this.id_Cliente = "";
        this.ptr_Usuario = new Usuario();
        this.apellidos = "";
        this.nombre = "";
        this.telefono = "";
        this.lista_cuenta = null;
        this.lista_favorita = null;
    }

    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Usuario getPtr_Usuario() {
        return ptr_Usuario;
    }

    public void setPtr_Usuario(Usuario ptr_Usuario) {
        this.ptr_Usuario = ptr_Usuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cuenta> getLista_cuenta() {
        return lista_cuenta;
    }

    public void setLista_cuenta(ArrayList<Cuenta> lista_cuenta) {
        this.lista_cuenta = lista_cuenta;
    }

    public ArrayList<Favorita> getLista_favorita() {
        return lista_favorita;
    }

    public void setLista_favorita(ArrayList<Favorita> lista_favorita) {
        this.lista_favorita = lista_favorita;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    

    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s}", getId_Cliente(), getNombre(), getApellidos(), getTelefono());
    }

    String id_Cliente;
    Usuario ptr_Usuario;
    String id_usuario;
    String apellidos;
    String nombre;
    String telefono;
    ArrayList<Cuenta> lista_cuenta;
    ArrayList<Favorita> lista_favorita;
}
