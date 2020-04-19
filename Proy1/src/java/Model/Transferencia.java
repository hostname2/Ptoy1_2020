/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author sebas
 */
public class Transferencia {

    public Transferencia(Integer id_transferencia, String cuenta_origen, String cuenta_destino, double monto, Date fecha, Integer aplicado, String detalle) {
        this.id_transferencia = id_transferencia;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
        this.monto = monto;
        this.fecha = fecha;
        this.aplicado = aplicado;
        this.cuenta = null;
        this.detalle = detalle;
    }

    public Transferencia(Integer id_transferencia, String cuenta_origen, String cuenta_destino, double monto, Date fecha, Integer aplicado, Cuenta cuenta) {
        this.id_transferencia = id_transferencia;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
        this.monto = monto;
        this.fecha = fecha;
        this.aplicado = aplicado;
        this.cuenta = cuenta;
    }

    public Transferencia() {
        this.id_transferencia = null;
        this.cuenta_origen = null;
        this.cuenta_destino = null;
        this.monto = 0;
        this.fecha = null;
        this.aplicado = 0;
        this.cuenta = null;
    }

    public Integer getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(Integer id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public String getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(String cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public String getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(String cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getAplicado() {
        return aplicado;
    }

    public void setAplicado(Integer aplicado) {
        this.aplicado = aplicado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    
    
    @Override
    public String toString() {
        return String.format("{%d, %s, %s ,%.2f, %s, %d}", getId_transferencia(), getCuenta_origen().toString(), getCuenta_destino().toString(), getMonto(), getFecha().toString(), getAplicado());
    }

    Integer id_transferencia;
    String cuenta_origen;
    String cuenta_destino;
    double monto;
    Date fecha;
    Integer aplicado;
    String detalle;
    Cuenta cuenta;
}
