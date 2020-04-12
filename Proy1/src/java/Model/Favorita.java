/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author sebas
 */
public class Favorita {

    public Favorita(String id_cliente, String id_cuenta) {
        this.id_cliente = id_cliente;
        this.id_cuenta = id_cuenta;
        this.lista_cliente = null;
        this.lista_cuenta = null;
    }

    public Favorita(List<Cliente> lista_cliente, List<Cuenta> lista_cuenta) {
        this.lista_cliente = lista_cliente;
        this.lista_cuenta = lista_cuenta;
        id_cliente = null;
        id_cuenta = null;
    }

    public Favorita() {
        id_cliente = null;
        id_cuenta = null;
        this.lista_cliente = null;
        this.lista_cuenta = null;
    }

    public void agregarCliente(Cliente c) {
        lista_cliente.add(c);
    }

    public void agregarCuenta(Cuenta c) {
        lista_cuenta.add(c);
    }

    public List<Cliente> getLista_cliente() {
        return lista_cliente;
    }

    public void setLista_cliente(List<Cliente> lista_cliente) {
        this.lista_cliente = lista_cliente;
    }

    public List<Cuenta> getLista_cuenta() {
        return lista_cuenta;
    }

    public void setLista_cuenta(List<Cuenta> lista_cuenta) {
        this.lista_cuenta = lista_cuenta;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(String id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
    
    

    public String toString() {
        return String.format("{{%s},{%s}}", getLista_cliente().toString(), getLista_cuenta().toString());
    }

    List<Cliente> lista_cliente;
    List<Cuenta> lista_cuenta;

    String id_cliente;
    String id_cuenta;

}
