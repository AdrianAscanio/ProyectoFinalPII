/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author adria
 */
public class Pizza {
    private String sabor;
    private String tamaño;
    private int cantidad;
    private String estado;

    public Pizza() {
        this.sabor = "";
        this.tamaño ="";
        this.cantidad = 0;
        this.estado = "";
    }

    public Pizza(String sabor, String tamaño, int cantidad, String estado) {
        this.sabor = sabor;
        this.tamaño = tamaño;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
