/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package buonazza;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import modelo.PizzaNodo;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class PopMenuController {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Label tituloMenu;
    @FXML
    public Label labelPrecio;
    @FXML
    public Button restar;
    @FXML
    public Button sumar;
    @FXML
    public TextField cantidad;

    @FXML
    public ToggleButton btnmini;
    @FXML
    public ToggleButton btnmediana;
    @FXML
    public ToggleButton btnfamiliar;

    public int cant = 1;
    public String sab;
    public String IdP;
    public int valor;

    public PizzaNodo Pizza;

    @FXML
    public ToggleGroup r;
    @FXML
    public Button btnClose;
    @FXML
    public Button btnOK;

    public void popUp() throws IOException {
        Stage stageEme = new Stage();
        Parent h = FXMLLoader.load(getClass().getResource("popMenu.fxml"));
        Scene canva = new Scene(h);
        stageEme.setScene(canva);
        stageEme.showAndWait();
    }

    public void setTitutlo(String tit) {
        this.tituloMenu.setText(tit);
    }

    public void SetBtn(String mini, String med, String fam) {
        this.btnmini.setText(mini);
        this.btnmediana.setText(med);
        this.btnfamiliar.setText(fam);
    }

    public void popClose() {
        Stage res = (Stage) btnClose.getScene().getWindow();
        res.close();
    }

    public void popUp(String titulo) throws IOException {
        Stage stageEme = new Stage();
        stageEme.setTitle("Menú");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController controlador = loader.getController();
        controlador.setTitutlo(titulo);
//        controlador.SetBtn("gola","hola","gola");

        Scene canva = new Scene(root);
        stageEme.setScene(canva);
        stageEme.showAndWait();
    }

    public void popUp(String titulo, String btn1, String btn2, String btn3, String sabor, String id) throws IOException {
        System.out.println(sabor + "<---- Popup");
        System.out.println(id + "<---- Popup");

        Stage stageEme = new Stage();
        stageEme.setTitle("Menú");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController controlador = loader.getController();
        controlador.setTitutlo(titulo);
        controlador.SetBtn(btn1, btn2, btn3);

        Scene canva = new Scene(root);
        stageEme.setScene(canva);
        this.sab = sabor;
        this.IdP = id;
        System.out.println(this.sab);
        System.out.println(this.IdP);
        stageEme.show();

    }

    public void btnRestaOnAction() {
        if (cant >= 2) {
            cant--;
        }
        cantidad.setText(String.valueOf(cant));
        this.labelPrecio.setText("Valor $"+(this.valor*this.cant));
    }



    public void btnSumaOnAction() {
        if (cant >= 1) {
            cant++;
        }
        cantidad.setText(String.valueOf(cant));
        this.labelPrecio.setText("Valor $"+(this.valor*this.cant));
    }

    public PizzaNodo getResult() {
        System.out.println(this.btnmini.isSelected());
        System.out.println(this.sab);
        System.out.println(this.IdP);
        PizzaNodo res = null;
        if (this.btnmini.isSelected()) {
            res = new PizzaNodo(this.IdP, this.sab, "MINI", cant, "ORDEN");
        } else if (this.btnmediana.isSelected()) {
            res = new PizzaNodo(this.IdP, this.sab, "MEDIANA", cant, "ORDEN");
        } else if (this.btnfamiliar.isSelected()) {
            res = new PizzaNodo(this.IdP, this.sab, "FAMILIAR", cant, "ORDEN");
        }
//        System.out.println(res.getInfo());
        return res;
    }

    public void onAntionBtnOk() {
        this.Pizza = this.getResult();
        Stage res = (Stage) btnOK.getScene().getWindow();
        res.close();
    }

    public void onMINI() {
        if (this.tituloMenu.getText().equals("Hawaiana")) {
            this.valor = 9000;
        } else if (this.tituloMenu.getText().equals("Queso")) {
            this.valor = 7000;
        } else if (this.tituloMenu.getText().equals("Salmón")) {
            this.valor = 11000;
        } else if (this.tituloMenu.getText().equals("Tradicional")) {
            this.valor = 13000;
        } else if (this.tituloMenu.getText().equals("Mariscos")) {
            this.valor =15000;
        }
        this.labelPrecio.setText("Valor $"+(this.valor*this.cant));
        
    }

    public void onMEDIANA() {
        if (this.tituloMenu.getText().equals("Hawaiana")) {
            this.valor = 12000;
        } else if (this.tituloMenu.getText().equals("Queso")) {
            this.valor = 10000;
        } else if (this.tituloMenu.getText().equals("Salmón")) {
            this.valor = 14000;
        } else if (this.tituloMenu.getText().equals("Tradicional")) {
            this.valor = 17000;
        } else if (this.tituloMenu.getText().equals("Mariscos")) {
            this.valor =19000;
        }
        this.labelPrecio.setText("Valor $"+(this.valor*this.cant));
    }

    public void onFAMILIAR() {
        if (this.tituloMenu.getText().equals("Hawaiana")) {
            this.valor = 40000;
        } else if (this.tituloMenu.getText().equals("Queso")) {
            this.valor = 36000;
        } else if (this.tituloMenu.getText().equals("Salmón")) {
            this.valor = 44000;
        } else if (this.tituloMenu.getText().equals("Tradicional")) {
            this.valor = 46000;
        } else if (this.tituloMenu.getText().equals("Mariscos")) {
            this.valor =49000;
        }
        this.labelPrecio.setText("Valor $"+(this.valor*this.cant));
    }

    @FXML
    public void initialize() {
//            System.out.println("vectana menu");
        this.btnOK.setOnAction(e -> {
            this.onAntionBtnOk();
        });
    }

}
