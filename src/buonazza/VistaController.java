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
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class VistaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button elimOrd;
    @FXML
    private Pane btnHaw;
    private TableView tableOrden;
    
    @FXML
    public void onActionhawaiana(){
        System.out.println("precionaste el btn hawaiana");
        Alert ax=new Alert(Alert.AlertType.CONFIRMATION);
//        ax.setDialogPane(dp);
        ax.show();
    }
    
    public void popUp() throws IOException{
        EmergenteController emer=new EmergenteController();
        emer.popEmer();
//        emer.btnClose.setOnAction(e->{
//            emer.stage.close();
//        });
//        Stage stage=new Stage();
//        Parent h = FXMLLoader.load(getClass().getResource("emergente.fxml"));
//        Scene canva = new Scene(h);
//        stage.setScene(canva);
//        stage.showAndWait();
        
    }
    
    public void AgregarColumn(){
        TableColumn<String, String> col1 = new TableColumn<>("id");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableOrden.getColumns().addAll(col1);
    }
    @FXML
    public void OnActionHaw(){

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            System.out.println("hola");
//            this.AgregarColumn();
//        tableOrden.getItems().add();
        
    }
    
    
    
}
