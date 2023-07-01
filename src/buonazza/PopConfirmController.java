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

/**
 * FXML Controller class
 *
 * @author adria
 */
public class PopConfirmController implements Initializable {
    
    @FXML
    public Label Titulo;
    @FXML
    public Button btn;
    @FXML
    public int opc;
    
    /**
     * Initializes the controller class.
     */
    public void onButton(){
        this.opc=1;
        Stage root = (Stage) this.btn.getScene().getWindow();
        root.close();
    }
    public void setTitle(String res){
        this.Titulo.setText(res);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
