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
    public Button restar;
    @FXML
    public Button sumar;
    @FXML
    public TextField cantidad;
    
    @FXML public ToggleButton btnmini;
    @FXML public ToggleButton btnmediana;
    @FXML public ToggleButton btnfamiliar;

    public int cant = 1;

    @FXML
    public ToggleGroup r;
    @FXML
    public Button btnClose;

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
    
    public void SetBtn(String mini, String med, String fam){
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
    public void popUp(String titulo,String btn1,String btn2, String btn3) throws IOException {
        Stage stageEme = new Stage();
        stageEme.setTitle("Menú");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController controlador = loader.getController();
        controlador.setTitutlo(titulo);
        controlador.SetBtn(btn1,btn2,btn3);
        
        Scene canva = new Scene(root);
        stageEme.setScene(canva);
        stageEme.showAndWait();
    }

    public void btnRestaOnAction() {
        if (cant >= 2) {
            cant--;
        }
        cantidad.setText(String.valueOf(cant));
    }

    public void btnSumaOnAction() {
        if (cant >= 1) {
            cant++;
        }
        cantidad.setText(String.valueOf(cant));

    }

    @FXML
    public void initialize() {
            System.out.println("vectana menu");
            
    }

}
