/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author adria
 */
public class PizzaPila extends Pizza {

    private PizzaNodo cab;
    private int nPizzas;

    public PizzaPila() {
    }

    public PizzaPila(String sabor, String tamaño, int cantidad, String estado) {
        super(sabor, tamaño, cantidad, estado);
    }

    public PizzaNodo getCab() {
        return cab;
    }

    public void setCab(PizzaNodo cab) {
        this.cab = cab;
    }

    public int getnPizzas() {
        return nPizzas;
    }

    public void setnPizzas(int nPizzas) {
        this.nPizzas = nPizzas;
    }

    public boolean pilaVacia() {
        if (this.nPizzas == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addPizza(String Id,String sabor, String tamaño, int cantidad, String estado) {
        PizzaNodo n = new PizzaNodo(Id,sabor.toUpperCase(), tamaño.toUpperCase(), cantidad, estado.toLowerCase());
        if (this.pilaVacia() == true) {
            this.setCab(n);
        } else {
            PizzaNodo temp = this.getCab();
            n.setSig(temp);
            this.setCab(n);
        }
    }
    

}
