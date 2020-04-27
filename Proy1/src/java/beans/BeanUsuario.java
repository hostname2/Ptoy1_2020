/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import Model.Usuario;

/**
 *
 * @author sebas
 */
public class BeanUsuario implements Serializable {
    
    private Usuario usuario;

    public BeanUsuario() {
        usuario = new Usuario();
    }

    public BeanUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "usuario=" + usuario;
    }
    
}

