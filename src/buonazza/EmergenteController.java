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
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class EmergenteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Stage stageEme=new Stage();
    @FXML
    public Button bntOk;
    @FXML
    public Button btnClose;
    @FXML
    private Label titulo;
    
    Scene canva;
    
    public void popEmer() throws IOException{
//        titulo.setText("estoy modificando");
//        Pane pane=new Pane();
        
//        Stage stageEme=new Stage();
        Parent h = FXMLLoader.load(getClass().getResource("emergente.fxml"));
        canva = new Scene(h);
        stageEme.setScene(canva);
        stageEme.showAndWait();
//        btnClose.setOnAction(e->{
//            stageEme.close();
//        });

    }
    public void closeVentana() throws Throwable{

            Stage res= (Stage) this.btnClose.getScene().getWindow();
            res.close();
    }

    public EmergenteController() {
    }

    public EmergenteController(String titulo) {
        this.titulo.setText(titulo);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        this.bntOk.setOnAction(e->{
//        });
        
    }    
    
}
