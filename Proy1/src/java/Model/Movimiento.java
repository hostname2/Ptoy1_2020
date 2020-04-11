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
public class Movimiento {

    public Movimiento(Integer id_movimiento, String num_cuenta, double monto, Date fecha, Integer aplicado, String movimientocol) {
        this.id_movimiento = id_movimiento;
        this.num_cuenta = num_cuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.aplicado = aplicado;
        this.movimientocol = movimientocol;
        this.cuenta = null;
    }
    
        public Movimiento(Integer id_movimiento, String num_cuenta, double monto, Date fecha, Integer aplicado, String movimientocol, Cuenta cuenta) {
        this.id_movimiento = id_movimiento;
        this.num_cuenta = num_cuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.aplicado = aplicado;
        this.movimientocol = movimientocol;
        this.cuenta = cuenta;
    }

    public Movimiento() {
        this.id_movimiento = null;
        this.num_cuenta = "";
        this.monto = 0;
        this.fecha = null;
        this.aplicado = null;
        this.movimientocol = "";
        this.cuenta = null;
    }

    public Integer getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(Integer id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
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

    public String getMovimientocol() {
        return movimientocol;
    }

    public void setMovimientocol(String movimientocol) {
        this.movimientocol = movimientocol;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    

    public String toString() {
        return String.format("%d,%s,%.2f,%s,%d,%s", getId_movimiento(), getNum_cuenta(), getMonto(), getFecha().toString(), getAplicado(), getMovimientocol());
    }

    Integer id_movimiento;
    String num_cuenta;
    double monto;
    Date fecha;
    Integer aplicado;
    String movimientocol;
    private Cuenta cuenta;
}
