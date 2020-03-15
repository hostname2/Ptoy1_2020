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
public class Usuario {

    public Usuario(String id_usuario, String clave_acceso, Integer clave_vencida, int rol) {
        this.id_usuario = id_usuario;
        this.clave_acceso = clave_acceso;
        this.clave_vencida = clave_vencida;
        this.rol = rol;
    }

    public Usuario() {
        this.id_usuario = "";
        this.clave_acceso = "";
        this.clave_vencida = 0;
        this.rol = 0;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getClave_acceso() {
        return clave_acceso;
    }

    public void setClave_acceso(String clave_acceso) {
        this.clave_acceso = clave_acceso;
    }

    public Integer getClave_vencida() {
        return clave_vencida;
    }

    public void setClave_vencida(Integer clave_vencida) {
        this.clave_vencida = clave_vencida;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    String id_usuario;
    String clave_acceso;
    Integer clave_vencida;
    int rol;
}
