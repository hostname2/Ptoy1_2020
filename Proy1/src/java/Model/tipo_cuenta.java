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
public class tipo_cuenta {

    public tipo_cuenta(Integer id_tipo_cuenta, String descripcion, double tasa_interes) {
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.descripcion = descripcion;
        this.tasa_interes = tasa_interes;
    }

    public tipo_cuenta() {
        this.id_tipo_cuenta = null;
        this.descripcion = "";
        this.tasa_interes = 0;
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

    public double getTasa_interes() {
        return tasa_interes;
    }

    public void setTasa_interes(double tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public String toString() {
        return String.format("{%d,%s,%.2f}", getId_tipo_cuenta(), getDescripcion(), getTasa_interes());
    }

    Integer id_tipo_cuenta;
    String descripcion;
    double tasa_interes;
}
