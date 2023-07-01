/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author adria
 */
public class PizzaPila {

    public PizzaNodo cab;
    public int nPizzas;

    public PizzaPila() {
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

    public boolean isVacia() {
        if (this.nPizzas == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addPizza(PizzaNodo res) {
        PizzaNodo n = res;
        System.out.println(n.getValor()+"<----- valor del nodo");
        if (this.isVacia() == true) {
            this.setCab(n);
            this.nPizzas++;
        } else {
            PizzaNodo temp = this.getCab();
            n.setSig(temp);
            this.setCab(n);
            this.nPizzas++;
        }
    }

    public void addPizzaFinal(PizzaNodo res) {
        PizzaNodo n = res;
        n.sig = null;
        if (this.isVacia() == true) {
            this.setCab(n);
            this.nPizzas++;
        } else {
            this.ultimo().sig = n;
        }
    }

    public void addPizza(String Id, String sabor, String tamaño, int cantidad, String estado) {
        PizzaNodo n = new PizzaNodo(Id, sabor.toUpperCase(), tamaño.toUpperCase(), cantidad, estado.toLowerCase());
        if (this.isVacia() == true) {
            this.setCab(n);
            this.nPizzas++;
        } else {
            PizzaNodo temp = this.getCab();
            n.setSig(temp);
            this.setCab(n);
            this.nPizzas++;
        }
    }
    
    public void addUltimo(PizzaNodo n){
        n.setSig(null);
        if (this.cab == null) {
            cab = n;
            this.nPizzas++;
        } else {
            PizzaNodo Aux= this.cab;
           while(Aux.sig!=null){
               Aux=Aux.sig;
           
           }
           Aux.setSig(n);
            this.nPizzas++;
        }
    }

    public void addPizzaCola(PizzaPila res) {
        PizzaNodo[] lista= new PizzaNodo[res.getnPizzas()];
        PizzaNodo aux=res.getCab();
        for (int i = 0; i < res.nPizzas; i++) {
            lista[i]=aux;
//            lista[i].setSig(null);
            aux=aux.sig;
        }
        System.out.println(lista.length);
        for (int i = lista.length-1; i > -1; i--) {
            this.addUltimo(lista[i]);
//            this.ultimo().setSig(lista[i]);
        }

        System.out.println("finalizado");
        
    }

    public PizzaNodo BuscarId(String id) {

        if (this.nPizzas != 0) {
            PizzaNodo aux = this.cab;
            while (aux.getSig() != null) {
                if (aux.getIdPizza().equals(id)) {
                    return aux;
                }
                aux = aux.getSig();
            }
            if (aux.getIdPizza().equals(id)) {
                return aux;
            }
        }
        return null;
    }

    public PizzaNodo ultimo() {
        PizzaNodo aux = this.cab;
        if (this.nPizzas != 0) {
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
        }
        return aux;
    }

    public PizzaNodo BuscarIdAnt(String id) {

        if (this.nPizzas != 0) {
            PizzaNodo aux = this.cab;
            PizzaNodo ant = null;
            while (aux.getSig() != null) {

                if (aux.getIdPizza().equals(id)) {
                    return ant;
                }
                ant = aux;
                aux = aux.getSig();
            }
            if (aux.getIdPizza().equals(id)) {
                return ant;
            }

        }
        return null;
    }

    public void quitarTope() {
        if (this.nPizzas != 0) {
            PizzaNodo temp = this.cab;
            this.cab = temp.getSig();
            temp = null;
            this.nPizzas--;
        }
    }

    public void Elimiar(String id) {
        if (this.BuscarId(id).getIdPizza().equals(this.cab.getIdPizza())) {
            this.quitarTope();
//            this.nPizzas--;
        } else {
            this.BuscarIdAnt(id).setSig(this.BuscarId(id).getSig());
            this.nPizzas--;
        }
        if(this.nPizzas==-1){this.nPizzas=0;}
    }

    public void Lista() {
        if (this.nPizzas != 0) {
            PizzaNodo aux = this.cab;
            while (aux.getSig() != null) {
                System.out.println(aux.getInfo());
                aux = aux.getSig();

            }
            System.out.println(aux.getInfo());
        }
    }
    
    public int getTotalPrecio(){
        int suma=0;
        if (this.cab!=null) {
            PizzaNodo aux= this.cab;
            while(aux.sig!=null){
                suma+=aux.getValor();
                aux=aux.sig;
            }
            suma+=aux.getValor();
        }
        return suma;
    }

}
