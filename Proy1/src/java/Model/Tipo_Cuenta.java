/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class Tipo_Cuenta {

    public Tipo_Cuenta(Integer id_tipo_cuenta, String descripcion) {
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.descripcion = descripcion;
        this.lista_cuenta = null;
    }

    public Tipo_Cuenta(Integer id_tipo_cuenta, String descripcion, ArrayList<Cuenta> lista_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.descripcion = descripcion;
        this.lista_cuenta = lista_cuenta;
    }

    public Tipo_Cuenta() {
        this.id_tipo_cuenta = null;
        this.descripcion = "";
        this.lista_cuenta = null;
    }

    public Integer getId_tipo_cuenta() {
        return id_tipo_cuenta;
    }

    public void setId_tipo_cuenta(Integer id_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public ArrayList<Cuenta> getLista_cuenta() {
        return lista_cuenta;
    }

    public void setLista_cuenta(ArrayList<Cuenta> lista_cuenta) {
        this.lista_cuenta = lista_cuenta;
    }

    public String toString() {
        return String.format("{%d,%s}", getId_tipo_cuenta(), getDescripcion());
    }

    Integer id_tipo_cuenta;
    String descripcion;
    ArrayList<Cuenta> lista_cuenta;
}
