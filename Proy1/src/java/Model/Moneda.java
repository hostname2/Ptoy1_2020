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
public class Moneda {

    public Moneda(String nombre, String descripcion, String simbolo, Double tipo_cambio_compra, Double tipo_cambio_venta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.simbolo = simbolo;
        this.tipo_cambio_compra = tipo_cambio_compra;
        this.tipo_cambio_venta = tipo_cambio_venta;
        this.lista_cuenta = null;
    }

    public Moneda(String nombre, String descripcion, String simbolo, Double tipo_cambio_compra, Double tipo_cambio_venta, ArrayList<Cuenta> lista_cuenta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.simbolo = simbolo;
        this.tipo_cambio_compra = tipo_cambio_compra;
        this.tipo_cambio_venta = tipo_cambio_venta;
        this.lista_cuenta = lista_cuenta;
    }

    public Moneda() {
        this.nombre = "";
        this.descripcion = "";
        this.simbolo = "";
        this.tipo_cambio_compra = 0.0;
        this.tipo_cambio_venta = 0.0;
        this.lista_cuenta = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Double getTipo_cambio_compra() {
        return tipo_cambio_compra;
    }

    public void setTipo_cambio_compra(Double tipo_cambio_compra) {
        this.tipo_cambio_compra = tipo_cambio_compra;
    }

    public Double getTipo_cambio_venta() {
        return tipo_cambio_venta;
    }

    public void setTipo_cambio_venta(Double tipo_cambio_venta) {
        this.tipo_cambio_venta = tipo_cambio_venta;
    }

    public ArrayList<Cuenta> getLista_cuenta() {
        return lista_cuenta;
    }

    public void setLista_cuenta(ArrayList<Cuenta> lista_cuenta) {
        this.lista_cuenta = lista_cuenta;
    }
    
    

    @Override
    public String toString() {
        return String.format("{%s,%s,%s,compra: %.2f,venta: %.2f}", getNombre(), getDescripcion(), getSimbolo(), getTipo_cambio_compra(), getTipo_cambio_venta());
    }

    String nombre;
    String descripcion;
    String simbolo;
    Double tipo_cambio_compra;
    Double tipo_cambio_venta;
    ArrayList<Cuenta> lista_cuenta;
}
