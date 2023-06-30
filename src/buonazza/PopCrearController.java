/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package buonazza;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import modelo.PizzaNodo;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class PopCrearController {

    @FXML
    public int opc;
    @FXML
    public int cant = 1;
    @FXML
    public int precioTam;
    @FXML
    public int sab1;
    @FXML
    public int sab2;
    @FXML
    public int sab3;
    @FXML
    public PizzaNodo Pizza;
    @FXML
    public int idPizza;

    @FXML
    public Button btnCancel;
    @FXML
    public Button btnOK;
    @FXML
    public Button suma;
    @FXML
    public Button resta;
    @FXML
    public TextField cantidad;
    @FXML
    public Label valor;
    @FXML
    public ComboBox Combo1;
    @FXML
    public ComboBox Combo2;
    @FXML
    public ComboBox Combo3;
    @FXML
    public ToggleButton Mini;
    @FXML
    public ToggleButton Med;
    @FXML
    public ToggleButton Fam;

    public void onClose() {
        Stage root = (Stage) this.btnCancel.getScene().getWindow();
        root.close();
    }

    public void onResta() {
        System.out.println("click Resta");
        if (cant >= 2) {
            cant--;
        }
        cantidad.setText(String.valueOf(cant));
        this.setLabelPrecio();
    }

    public void onSuma() {
        System.out.println("click suma");
        if (cant >= 1) {
            cant++;
        }

        cantidad.setText(String.valueOf(cant));
        this.setLabelPrecio();
    }

    public void onSelectMini() {
        this.precioTam = 5000;
        this.setLabelPrecio();
    }

    public void onSelectMed() {
        this.precioTam = 12000;
        this.setLabelPrecio();
    }

    public void onSelectFam() {
        this.precioTam = 35000;
        this.setLabelPrecio();
    }

    public void onSabor1() {
        if (this.Combo1.getValue().toString().equals("Queso")) {
            this.sab1 = 1000;
        } else if (this.Combo1.getValue().toString().equals("Mariscos")) {
            this.sab1 = 5000;
        } else if (this.Combo1.getValue().toString().equals("Salmón")) {
            this.sab1 = 4000;
        } else if (this.Combo1.getValue().toString().equals("Piña")) {
            this.sab1 = 3000;
        } else if (this.Combo1.getValue().toString().equals("Peperoni")) {
            this.sab1 = 3000;
        } else if (this.Combo1.getValue().toString().equals("--")) {
            this.sab1 = 0;
        }
        this.setLabelPrecio();
        return;
    }

    public void onSabor2() {
        if (this.Combo2.getValue().toString().equals("Queso")) {
            this.sab2 = 1000;
        } else if (this.Combo2.getValue().toString().equals("Mariscos")) {
            this.sab2 = 5000;
        } else if (this.Combo2.getValue().toString().equals("Salmón")) {
            this.sab2 = 4000;
        } else if (this.Combo2.getValue().toString().equals("Piña")) {
            this.sab2 = 3000;
        } else if (this.Combo2.getValue().toString().equals("Peperoni")) {
            this.sab1 = 3000;
        } else if (this.Combo2.getValue().toString().equals("--")) {
            this.sab1 = 0;
        }

        this.setLabelPrecio();
        return;
    }

    public void onSabor3() {
        if (this.Combo3.getValue().toString().equals("Queso")) {
            this.sab3 = 1000;
        } else if (this.Combo3.getValue().toString().equals("Mariscos")) {
            this.sab3 = 5000;
        } else if (this.Combo3.getValue().toString().equals("Salmón")) {
            this.sab3 = 4000;
        } else if (this.Combo3.getValue().toString().equals("Piña")) {
            this.sab3 = 3000;
        } else if (this.Combo3.getValue().toString().equals("Peperoni")) {
            this.sab3 = 3000;
        } else if (this.Combo3.getValue().toString().equals("--")) {
            this.sab3 = 0;
        }
        this.setLabelPrecio();
        return;
    }

    public void setLabelPrecio() {
        int res = this.precioTam + this.sab1 + this.sab2 + this.sab3;
        res *= this.cant;
        this.valor.setText("Valor $" + String.valueOf(res));

    }

    public int getPrecio() {
        int res = this.precioTam + this.sab1 + this.sab2 + this.sab3;
        res *= this.cant;
        return res;
    }

    public void initComboBox() {
        this.Combo1.setValue("--");
        this.Combo2.setValue("--");
        this.Combo3.setValue("--");
        this.Combo1.getItems().addAll("--", "Queso", "Salmón", "Mariscos", "Piña", "Peperoni");
        this.Combo2.getItems().addAll("--", "Queso", "Salmón", "Mariscos", "Piña", "Peperoni");
        this.Combo3.getItems().addAll("--", "Queso", "Salmón", "Mariscos", "Piña", "Peperoni");
    }

    public void onBtnOK() {
        String tamano="";
        if (this.Mini.isSelected()) {
            tamano="MINI";
        }else if (this.Med.isSelected()) {
            tamano="MEDIANA";
        }else if (this.Fam.isSelected()) {
            tamano="FAMILIAR";
        }
        String Sabor = this.Combo1.getValue().toString() + " + " + this.Combo2.getValue().toString() + " + " + this.Combo3.getValue().toString();
        Pizza= new PizzaNodo(String.valueOf(this.idPizza),Sabor,tamano,this.cant,"ORDEN");
        this.opc=1;
        Stage root = (Stage) this.btnOK.getScene().getWindow();
        root.close();
    }

//    @Override
    public void initialize() {
        this.initComboBox();
//        this.Combo1.seton
//        this.cantidad.setText(String.valueOf(this.cant));
        // TODO
    }

}
