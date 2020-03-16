/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.sun.javafx.binding.StringFormatter;

/**
 *
 * @author sebas
 */
public class Cliente {

    public Cliente(String id_Cliente, Usuario ptr_Usuario, String apellidos, String nombre, String telefono) {
        this.id_Cliente = id_Cliente;
        this.ptr_Usuario = ptr_Usuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente() {
        this.id_Cliente = "";
        this.ptr_Usuario = new Usuario();
        this.apellidos = "";
        this.nombre = "";
        this.telefono = "";
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
    
    @Override
    public String toString(){
        return String.format("{%s, %s, %s, %s}", getId_Cliente(), getNombre(),getApellidos(), getTelefono());
    }
            

    String id_Cliente;
    Usuario ptr_Usuario;
    String apellidos;
    String nombre;
    String telefono;
}
