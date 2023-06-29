/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author adria
 */
public class PizzaNodo extends Pizza {

    String idPizza;
    String Info;
    ImageView img;
    PizzaNodo sig;

    public PizzaNodo() {
        this.sig = null;
        this.idPizza = "";
    }

    public PizzaNodo(String idPizza) {
        this.idPizza = idPizza;
    }

    public PizzaNodo(String idPizza, String sabor, String tamaño, int cantidad, String estado) {
        super(sabor, tamaño, cantidad, estado);
        this.idPizza = idPizza;
        this.Info = sabor + "\n" + tamaño + "\n" + String.valueOf(cantidad) + " uni";
        this.img = this.imagen(sabor.toUpperCase());
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public ImageView imagen(String sab) {
        Image icon = null;
        if (this.sabor.equals("HAWAIANA")) {
            icon = new Image("img/hawaiana.png");
        } else if (this.sabor.equals("QUESO")) {
            icon = new Image("img/quso.png");
        }else if (this.sabor.equals("SALMON")) {
            icon = new Image("img/salmon.png");
        }else if (this.sabor.equals("TRADICIONAL")) {
            icon = new Image("img/tradicional.png");
        }else if (this.sabor.equals("MARISCOS")) {
            icon = new Image("img/mariscos.png");
        }
        ImageView res = new ImageView(icon);
        res.setFitWidth(50);
        res.setFitHeight(50);

        return res;
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
