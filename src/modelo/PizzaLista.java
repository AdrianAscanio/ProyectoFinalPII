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
    
    
    void addCab(PizzaNodo n){
        if (this.cab== null) {
            cab = n;
            cola = n;
            this.nPizzas++;
        } else {
            PizzaLista res =new PizzaLista();
            
            cola.sig = n;
//            n.sig = cab;
            
            this.cola = this.getUltimo();
            this.nPizzas+=this.contador(n);
        }
    }
    void addFinal(String idPizza, String sabor, String tamaño, int cantidad, String estado){
        PizzaNodo n = new PizzaNodo(idPizza,sabor,tamaño,cantidad,estado);
        if (this.cab== null) {
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
    public int contador(PizzaNodo cab){
        int contador=0;
        if(cab!=null){
            PizzaNodo aux=cab;
            while(aux.sig!=null){
                aux=aux.sig;
                contador++;
            }
            contador++;
        }
        return contador;
    }
    public void addPila(PizzaPila lista){
        PizzaNodo aux=lista.getCab();
        if (aux!=null) {
            System.out.println("exito");
            while(aux.sig!=null){
                System.out.println("se agrego");
                this.addFinal(aux.idPizza, aux.getSabor(), aux.getTamaño(),aux.getCantidad(),aux.getEstado());
                aux=aux.sig;
            }
             this.addFinal(aux.idPizza, aux.getSabor(), aux.getTamaño(),aux.getCantidad(),aux.getEstado());
        }else{System.out.println("fallo");}
    }
    public PizzaNodo getUltimo(){
        PizzaNodo aux=cab;
        if(cab!=null){
            
            while (aux.sig!=null){
                aux=aux.sig;
            }
            
        }
        return aux;
    }
    public void  leerVentas(){
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

