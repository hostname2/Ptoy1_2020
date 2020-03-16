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

    public Transferencia(Integer id_transferencia, Cuenta cuenta_origen, Cuenta cuenta_destino, double monto, Date fecha, Integer aplicado) {
        this.id_transferencia = id_transferencia;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
        this.monto = monto;
        this.fecha = fecha;
        this.aplicado = aplicado;
    }
    
    public Transferencia(){
        this.id_transferencia = null;
        this.cuenta_origen = null;
        this.cuenta_destino = null;
        this.monto = 0;
        this.fecha = null;
        this.aplicado = 0;        
    }

    public Integer getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(Integer id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public Cuenta getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(Cuenta cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public Cuenta getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(Cuenta cuenta_destino) {
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
    
    @Override
    public String toString(){
        return String.format("{%d, %s, %s ,%.2f, %s, %d}",getId_transferencia(),getCuenta_origen().toString(),getCuenta_destino().toString(),getMonto(),getFecha().toString(),getAplicado());
    }
    
    Integer id_transferencia;
    Cuenta cuenta_origen;
    Cuenta cuenta_destino;
    double monto;
    Date fecha;
    Integer aplicado;
}
