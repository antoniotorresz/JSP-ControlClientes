package com.antonio.ControlClientesJSP.Dominio;

public class Cliente {
    //las clases de dominio del problema son las clases que van a ser mapeadas con las columas de las bases de datos
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private double saldo;

    public Cliente() {}

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nombre, String apellidos, String email, String telefono, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public Cliente(String nombre, String apellidos, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
