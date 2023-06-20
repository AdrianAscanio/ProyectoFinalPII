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
public class PopMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Button btnClose;
    public void  popUp() throws IOException{
        Stage stageEme=new Stage();
        Parent h = FXMLLoader.load(getClass().getResource("popMenu.fxml"));
        Scene canva = new Scene(h);
        stageEme.setScene(canva);
        stageEme.showAndWait();
    }
    public void popClose(){
        Stage res = (Stage) btnClose.getScene().getWindow();
        res.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
