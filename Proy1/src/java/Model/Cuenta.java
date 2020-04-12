/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sebas
 */
public class Cuenta {

    public Cuenta(String numero_Cuneta, Date fecha_creacion, Date Fecha_ultimaAplicacion, double limite_transferencia, Integer activa, double saldo_inicial, double saldo_final, String id_cliente, String id_moneda, Integer id_cuenta) {
        this.numero_Cuneta = numero_Cuneta;
        this.id_tipo_cuenta = null;
        this.fecha_creacion = fecha_creacion;
        this.Fecha_ultimaAplicacion = Fecha_ultimaAplicacion;
        this.limite_transferencia = limite_transferencia;
        this.activa = activa;
        this.saldo_inicial = saldo_inicial;
        this.saldo_final = saldo_final;
        this.id_cliente = id_cliente;
        this.id_moneda = id_moneda;
        this.id_cuenta = id_cuenta;
        this.cliente = null;
        this.moneda = null;
        this.lista_movimiento = null;
    }

    public Cuenta(String numero_Cuneta, Tipo_Cuenta id_tipo_cuenta, Date fecha_creacion, Date Fecha_ultimaAplicacion, double limite_transferencia, Integer activa, double saldo_inicial, double saldo_final, Cliente cliente, Moneda moneda) {
        this.numero_Cuneta = numero_Cuneta;
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.fecha_creacion = fecha_creacion;
        this.Fecha_ultimaAplicacion = Fecha_ultimaAplicacion;
        this.limite_transferencia = limite_transferencia;
        this.activa = activa;
        this.saldo_inicial = saldo_inicial;
        this.saldo_final = saldo_final;
        this.cliente = cliente;
        this.moneda = moneda;
        this.lista_movimiento = null;
    }

    public Cuenta(String numero_Cuneta, Tipo_Cuenta id_tipo_cuenta, Date fecha_creacion, Date Fecha_ultimaAplicacion, double limite_transferencia, Integer activa, double saldo_inicial, double saldo_final, Cliente cliente, Moneda moneda, ArrayList<Movimiento> lista_movimiento) {
        this.numero_Cuneta = numero_Cuneta;
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.fecha_creacion = fecha_creacion;
        this.Fecha_ultimaAplicacion = Fecha_ultimaAplicacion;
        this.limite_transferencia = limite_transferencia;
        this.activa = activa;
        this.saldo_inicial = saldo_inicial;
        this.saldo_final = saldo_final;
        this.cliente = cliente;
        this.moneda = moneda;
        this.lista_movimiento = lista_movimiento;
    }

    public Cuenta(String numero_Cuneta, Date fecha_creacion, Date Fecha_ultimaAplicacion, double limite_transferencia, Integer activa, double saldo_inicial, double saldo_final) {
        this.numero_Cuneta = numero_Cuneta;
        this.fecha_creacion = fecha_creacion;
        this.Fecha_ultimaAplicacion = Fecha_ultimaAplicacion;
        this.limite_transferencia = limite_transferencia;
        this.activa = activa;
        this.saldo_inicial = saldo_inicial;
        this.saldo_final = saldo_final;
        this.id_tipo_cuenta = null;
        this.cliente = null;
        this.moneda = null;
        this.lista_movimiento = null;
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
        this.lista_movimiento = null;
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

    public Date getFecha_ultimaAplicacion() {
        return Fecha_ultimaAplicacion;
    }

    public void setFecha_ultimaAplicacion(Date Fecha_ultimaAplicacion) {
        this.Fecha_ultimaAplicacion = Fecha_ultimaAplicacion;
    }

    public double getSaldo_final() {
        return saldo_final;
    }

    public void setSaldo_final(double saldo_final) {
        this.saldo_final = saldo_final;
    }

    public ArrayList<Movimiento> getLista_movimiento() {
        return lista_movimiento;
    }

    public void setLista_movimiento(ArrayList<Movimiento> lista_movimiento) {
        this.lista_movimiento = lista_movimiento;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(String id_moneda) {
        this.id_moneda = id_moneda;
    }

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
    
    

    public String toString() {
        return String.format("{%s, %s, %s, %s, %s, %.2f, %d, %.2f}", getNumero_Cuneta(), getId_tipo_cuenta().toString(), getCliente().toString(), getMoneda().toString(), getFecha_creacion().toString(), getLimite_transferencia(), getActiva(), getSaldo_inicial());
    }

    String numero_Cuneta;
    Date fecha_creacion;
    Date Fecha_ultimaAplicacion;
    double limite_transferencia;
    Integer activa;
    double saldo_inicial;
    double saldo_final;

    String id_cliente;
    String id_moneda;
    Integer id_cuenta;

    Tipo_Cuenta id_tipo_cuenta;
    Cliente cliente;
    Moneda moneda;
    private ArrayList<Movimiento> lista_movimiento;

}
