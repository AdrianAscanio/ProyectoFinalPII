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
     String idPizza;
     PizzaNodo sig;

    public PizzaNodo() {
        this.sig=null;
        this.idPizza="";
    }

    public PizzaNodo(String idPizza) {
        this.idPizza = idPizza;
    }

    public PizzaNodo(String idPizza, String sabor, String tamaño, int cantidad, String estado) {
        super(sabor, tamaño, cantidad, estado);
        this.idPizza = idPizza;
    }
    
    
    

    public PizzaNodo getSig() {
        return sig;
    }

    public void setSig(PizzaNodo sig) {
        this.sig = sig;
    }

    public String getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(String idPizza) {
        this.idPizza = idPizza;
    }
    
    
    
    
      
    
}
