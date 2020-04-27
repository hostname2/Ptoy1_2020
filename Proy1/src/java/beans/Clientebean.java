/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Model.Cliente;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class Clientebean  implements Serializable {
    
    private Cliente cliente;

    public Clientebean() {
        cliente = new Cliente();
    }

    public Clientebean(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getUsuario() {
        return cliente;
    }

    public void setUsuario(Cliente usuario) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "cliente=" + cliente;
    }
    
}
