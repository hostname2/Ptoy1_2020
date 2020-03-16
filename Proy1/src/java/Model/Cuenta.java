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
public class Cuenta {

    public Cuenta(String numero_Cuneta, Tipo_Cuenta id_tipo_cuenta, Cliente cliente, Moneda moneda, Date fecha_creacion, double limite_transferencia, Integer activa, double saldo_inicial) {
        this.numero_Cuneta = numero_Cuneta;
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.cliente = cliente;
        this.moneda = moneda;
        this.fecha_creacion = fecha_creacion;
        this.limite_transferencia = limite_transferencia;
        this.activa = activa;
        this.saldo_inicial = saldo_inicial;
    }

    public Cuenta() {
        this.numero_Cuneta = "";
        this.id_tipo_cuenta = null;
        this.cliente = null;
        this.moneda = null;
        this.fecha_creacion = null;
        this.limite_transferencia = 0;
        this.activa = null;
        this.saldo_inicial = 0;
    }

    public String getNumero_Cuneta() {
        return numero_Cuneta;
    }

    public void setNumero_Cuneta(String numero_Cuneta) {
        this.numero_Cuneta = numero_Cuneta;
    }

    public Tipo_Cuenta getId_tipo_cuenta() {
        return id_tipo_cuenta;
    }

    public void setId_tipo_cuenta(Tipo_Cuenta id_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public double getLimite_transferencia() {
        return limite_transferencia;
    }

    public void setLimite_transferencia(double limite_transferencia) {
        this.limite_transferencia = limite_transferencia;
    }

    public Integer getActiva() {
        return activa;
    }

    public void setActiva(Integer activa) {
        this.activa = activa;
    }

    public double getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(double saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }
    
    public String toString(){
        return String.format("{%s, %s, %s, %s, %s, %.2f, %d, %.2f}" ,getNumero_Cuneta(), getId_tipo_cuenta().toString(), getCliente().toString(), getMoneda().toString(), getFecha_creacion().toString(), getLimite_transferencia(), getActiva(), getSaldo_inicial());
    }

    String numero_Cuneta;
    Tipo_Cuenta id_tipo_cuenta;
    Cliente cliente;
    Moneda moneda;
    Date fecha_creacion;
    double limite_transferencia;
    Integer activa;
    double saldo_inicial;
}
