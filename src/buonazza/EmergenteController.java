/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package buonazza;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class EmergenteController {

    /**
     * Initializes the controller class.
     */
    public int opc;
    @FXML
    public Stage stageEme = new Stage();
    @FXML
    public Button bntOk;
    @FXML
    public Button btnClose;
    @FXML
    public Label titulo;

    Scene canva;

    public void popEmer() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emergente.fxml"));
        Parent root = loader.load();
        EmergenteController controlador = loader.getController();
        controlador.titulo("¿Ya no deseas solicitar la Orden?");
        canva = new Scene(root);
        stageEme.setScene(canva);
        stageEme.showAndWait();
    }
    
    public void popEmer(String res) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emergente.fxml"));
        Parent root = loader.load();
        EmergenteController controlador = loader.getController();
        controlador.titulo(res);
        canva = new Scene(root);
        stageEme.setScene(canva);
        stageEme.showAndWait();
    }

    public void cambiar() {
        titulo.setText("¿Ya no deseas solicitar la Orden?");
    }
    
    public void eliminar(){
        this.opc=1;
//        System.out.println(this.opc);
        Stage ventana = (Stage) this.bntOk.getScene().getWindow();
        ventana.close();
    }

    public void closeVentana() throws Throwable {

        Stage res = (Stage) this.btnClose.getScene().getWindow();
        res.close();
    }

    public void titulo(String tit) {
        this.titulo.setText(tit);
    }

    public EmergenteController() {
    }

    public EmergenteController(String titulo) {
        this.titulo.setText(titulo);
    }

    public EmergenteController(int opc) {
        this.opc = opc;
    }

    @FXML

    public void initialize() {
//        int res=getOPC();
//        if (this.opc==0) {
//            this.titulo.setText("no hice nada");
//        }else if(this.opc==1){
//            this.titulo.setText("hola");
//        }

    }

    public void setOPC(int res) {
        this.opc = res;
    }
//    @FXML
//    public void initialize(int opc){
//        if (this.opc==0) {
//            this.titulo.setText("no hice nada");
//        }else if(this.opc==1){
//            this.titulo.setText("hola");
//        }
//    }

    private int getOPC() {
        return this.opc;
    }

}
