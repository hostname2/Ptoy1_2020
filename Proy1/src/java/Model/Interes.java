/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sebas
 */
public class Interes {

    public Interes(double tasa_interes, Integer tipo_cuenta_id, String moneda_nombre) {
        this.tasa_interes = tasa_interes;
        this.tipo_cuenta_id = tipo_cuenta_id;
        this.moneda_nombre = moneda_nombre;
    }

    public double getTasa_interes() {
        return tasa_interes;
    }

    public void setTasa_interes(double tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public Integer getTipo_cuenta_id() {
        return tipo_cuenta_id;
    }

    public void setTipo_cuenta_id(Integer tipo_cuenta_id) {
        this.tipo_cuenta_id = tipo_cuenta_id;
    }

    public String getMoneda_nombre() {
        return moneda_nombre;
    }

    public void setMoneda_nombre(String moneda_nombre) {
        this.moneda_nombre = moneda_nombre;
    }

    @Override
    public String toString() {
        return "Interes{" + "tasa_interes=" + tasa_interes + ", tipo_cuenta_id=" + tipo_cuenta_id + ", moneda_nombre=" + moneda_nombre + "}";
    }
    
    
    double tasa_interes;
    Integer tipo_cuenta_id;
    String moneda_nombre;
}
