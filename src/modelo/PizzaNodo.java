/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author adria
 */
public class PizzaNodo extends Pizza {
    private PizzaNodo sig;

    public PizzaNodo() {
        this.sig=null;
    }

    public PizzaNodo(String sabor, String tamaño, int cantidad, String estado) {
        super(sabor, tamaño, cantidad, estado);
    }

    public PizzaNodo getSig() {
        return sig;
    }

    public void setSig(PizzaNodo sig) {
        this.sig = sig;
    }
      
    
}
