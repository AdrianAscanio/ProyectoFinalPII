/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author adria
 */
public class PizzaLista {

    public PizzaNodo cab;
    public int nPizzas;

    public PizzaLista() {
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

    public void addUltimo(PizzaNodo n) {
        n.setSig(null);
        if (this.cab == null) {
            cab = n;
            this.nPizzas++;
        } else {
            PizzaNodo Aux = this.cab;
            while (Aux.sig != null) {
                Aux = Aux.sig;

            }
            Aux.setSig(n);
            this.nPizzas++;
        }
    }

    public void addPizzaCola(PizzaPila res) {
        PizzaNodo[] lista = new PizzaNodo[res.getnPizzas()];
        PizzaNodo aux = res.getCab();
        for (int i = 0; i < res.nPizzas; i++) {
            lista[i] = aux;
//            lista[i].setSig(null);
            aux = aux.sig;
        }
        System.out.println(lista.length);
        for (int i = lista.length - 1; i > -1; i--) {
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
            System.out.println("entre aqui en cabeza");
            this.quitarTope();
//            this.nPizzas--;
        } else {
            this.BuscarIdAnt(id).setSig(this.BuscarId(id).getSig());
            this.nPizzas--;
        }
        if (this.nPizzas == -1) {
            this.nPizzas = 0;
        }
    }

    public void addFinal(PizzaNodo n) {
        n.setSig(null);
        if (this.cab == null) {
            cab = n;
            this.nPizzas++;
        } else {
            PizzaNodo Aux = this.cab;
            while (Aux.sig != null) {
                Aux = Aux.sig;

            }
            Aux.setSig(n);
            this.nPizzas++;
        }
    }

    public void leerVentas() {
        this.cab = null;
//        this.cola=null;
        this.nPizzas = 0;
//        PizzaLista res = new PizzaLista(); // lista auxiliar para recibir datos del documento
//        if (this.docVacio()) {
//            System.out.println("El Documento esta vacio");
//            return ;
//        }
        File doc = new File(".\\ventas.txt");// llamada del documento,
        try {
            Scanner obj = new Scanner(doc);// leectra del documento
            while (obj.hasNextLine()) { //contador de lineas del documento
                
                String[] Nodo = obj.nextLine().split("\\s*,\\s*"); // Separa la linea del docuemnte por sus  comas, y las combierte en Arreglos de String
                PizzaNodo n = new PizzaNodo(Nodo[0], Nodo[1], Nodo[2], Integer.valueOf(Nodo[3]), Nodo[4],Integer.valueOf(Nodo[5]));
                addFinal(n); // Asignacion de los elementos del la linea del documento y los agrega a la lista auxiliar.
            }
        } catch (Exception e) {
            System.out.println("error al agregar datos >>> "+e );
        }
//        this.cab=res.cab;  // Retorna la lista con los elementos encontrados
    }

    public void addNodoVentasDoc(PizzaNodo nodo) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String data = "\n" + nodo.getIdPizza() + "," + nodo.getSabor() + "," + nodo.getTamaño() + "," + nodo.getCantidad() + "," + "HECHO"+","+nodo.getValor();
            File file = new File(".\\ventas.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("información agregada!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int getTotalPrecio() {
        int suma = 0;
        if (this.cab != null) {
            PizzaNodo aux = this.cab;
            while (aux.sig != null) {
                suma += aux.getValor();
                aux = aux.sig;
            }
            suma += aux.getValor();
        }
        return suma;
    }

    public int obtenerid() {
        File archivo = new File(".\\ventas.txt");
        String ultimaLinea = null;
        if (this.docVacio()) {
            return 0;
        }
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                ultimaLinea = linea;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] res = ultimaLinea.split("\\s*,\\s*");
        try {
            return Integer.valueOf(res[0]);
        } catch (Exception r) {
            System.out.println("Error en Obtener ultimo Id Ventas | "+r);
            return -1;
            
        }
        
    }
    
    public boolean docVacio(){
        File archivo = new File(".\\ventas.txt");

        if (archivo.length() == 0) {
            return true;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();
            if (linea == null || linea.trim().isEmpty()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
