/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author adria
 */
public class PizzaLista {

    PizzaNodo cab;
    PizzaNodo cola;
    int nPizzas;

    public PizzaLista() {
    }

    public PizzaNodo getCab() {
        return cab;
    }

    public void setCab(PizzaNodo cab) {
        this.cab = cab;
    }

    public PizzaNodo getCola() {
        return cola;
    }

    public void setCola(PizzaNodo cola) {
        this.cola = cola;
    }

    public int getnPizzas() {
        return nPizzas;
    }

    public void setnPizzas(int nPizzas) {
        this.nPizzas = nPizzas;
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
            this.nPizzas--;
        } else {
            this.BuscarIdAnt(id).setSig(this.BuscarId(id).getSig());
            this.nPizzas--;
        }
    }
    
    public void Eliminar(String id){
        if(this.cab==null){
            return;
        }
        if(this.cab.idPizza.equals(id)){
            this.cab=this.cab.sig;
            return;
        }
        PizzaNodo aux= this.cab;
        while(aux.sig!=null){
                if(aux.sig.idPizza.equals(id)){
                    aux.sig=aux.sig.sig;
                    return;
                }
        }
        aux=aux.sig;
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

    public void addCab(PizzaNodo n) {
        if (this.cab == null) {
            cab = n;
            cola = n;
            this.nPizzas++;
        } else {
            PizzaLista res = new PizzaLista();

            cola.sig = n;
//            n.sig = cab;

            this.cola = this.getUltimo();
            this.nPizzas += this.contador(n);
        }
    }

    public void addFinal(String idPizza, String sabor, String tamaño, int cantidad, String estado) {
        PizzaNodo n = new PizzaNodo(idPizza, sabor, tamaño, cantidad, estado);
        if (this.cab == null) {
            cab = n;
            cola = n;
            this.nPizzas++;
        } else {
            cola.sig = n;
//            n.sig = cab;
            this.cola = n;
            this.nPizzas++;
        }
    }

    public void addFinal(PizzaNodo n) {
        n.sig=null;
        if (this.cab == null) {
            cab = n;
            cola = n;
            this.nPizzas++;
        } else {
            cola.sig = n;
//            n.sig = cab;
            this.cola = n;
            this.nPizzas++;
        }
    }

    public int contador(PizzaNodo cab) {
        int contador = 0;
        if (cab != null) {
            PizzaNodo aux = cab;
            while (aux.sig != null) {
                aux = aux.sig;
                contador++;
            }
            contador++;
        }
        return contador;
    }

    public void addPila(PizzaPila lista) {
        PizzaNodo aux = lista.getCab();
        if (aux != null) {
            System.out.println("exito");
            while (aux.sig != null) {
                
                this.addFinal(aux);
                aux = aux.sig;
            }
            this.addFinal(aux);
            
            System.out.println("Se agrgaron todos los nodos de la Pila");
        } else {
            System.out.println("fallo en agregacion de nodo en listas");
        }
    }

    public PizzaNodo getUltimo() {
        PizzaNodo aux = cab;
        if (cab != null) {

            while (aux.sig != null) {
                aux = aux.sig;
            }

        }
        return aux;
    }

    public void leerVentas() {
//        PizzaLista res = new PizzaLista(); // lista auxiliar para recibir datos del documento
        File doc = new File(".\\ventas.txt");// llamada del documento,
        try {
            Scanner obj = new Scanner(doc);// leectra del documento
            while (obj.hasNextLine()) { //contador de lineas del documento
                String[] item = obj.nextLine().split("\\s*,\\s*"); // Separa la linea del docuemnte por sus  comas, y las combierte en Arreglos de String
                addFinal(item[0], item[1], item[2], Integer.valueOf(item[3]), item[4]); // Asignacion de los elementos del la linea del documento y los agrega a la lista auxiliar.
            }
        } catch (Exception e) {
            System.out.println("error al agregar datos");
        }
//        this.cab=res.cab;  // Retorna la lista con los elementos encontrados
    }

    public void Lista() {
        if (this.nPizzas != 0) {
            PizzaNodo aux = this.cab;
            while (aux.sig != null) {
                System.out.println(aux.getIdPizza());
                aux = aux.sig;
            }
            System.out.println(aux.getIdPizza());
        }
    }
}
