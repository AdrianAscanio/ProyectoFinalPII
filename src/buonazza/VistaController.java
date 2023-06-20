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
import modelo.PizzaLista;
import modelo.PizzaNodo;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class VistaController implements Initializable {
    PizzaLista ventas=new PizzaLista();
    /**
     * Initializes the controller class.
     */
    @FXML
    public Button agregar;
    @FXML
    private Button elimOrd;
    @FXML
    private Pane btnHaw;
    @FXML
    private TableView tableOrden;
    @FXML
    public TableView tableVentas;
    @FXML
    public Pagination pag;
    
    @FXML
    public void onActionhawaiana() throws IOException{
        PopMenuController res = new PopMenuController();
        res.popUp();
//        System.out.println("precionaste el btn hawaiana");
//        Alert ax=new Alert(Alert.AlertType.CONFIRMATION);
////        ax.setDialogPane(dp);
//        ax.show();
    }
    public void initTableVentas(){
        tableVentas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        TableColumn<PizzaNodo, String> col1 = new TableColumn<>("id");
        col1.setCellValueFactory(new PropertyValueFactory<>("idPizza"));
        TableColumn<PizzaNodo, String> col2 = new TableColumn<>("Sabor");
        col2.setCellValueFactory(new PropertyValueFactory<>("sabor"));
        TableColumn<PizzaNodo, String> col3 = new TableColumn<>("Tamaño");
        col3.setCellValueFactory(new PropertyValueFactory<>("tamaño"));
        TableColumn<PizzaNodo, String> col4 = new TableColumn<>("Cantidad");
        col4.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        TableColumn<PizzaNodo, String> col5 = new TableColumn<>("Estaado");
        col5.setCellValueFactory(new PropertyValueFactory<>("estado"));
        this.tableVentas.getColumns().addAll(col1,col2,col3,col4,col5);
    }
    public void actualizarVentas(){
        ventas.leerVentas();
        if (ventas.getnPizzas() != 0) {
            for (int i = 0; i < tableVentas.getItems().size(); i++) {
                tableVentas.getItems().clear();
            }
            if (ventas.getnPizzas() == 1) {
                tableVentas.getItems().add(ventas.getCab());
            } else {
                PizzaNodo i = ventas.getCab();
                while (i.getSig()!=null) {
                    tableVentas.getItems().add(i);
//                    System.out.println(i.getNombre());
                    i = i.getSig();
                }
                tableVentas.getItems().add(i);
            }
        }
    
    }
    public void popUp() throws IOException{
        EmergenteController emer=new EmergenteController();
        emer.popEmer();
        emer.btnClose.setOnAction(e->{
            emer.stageEme.close();
        });
//        emer.btnClose.setOnAction(e->{
//            emer.stage.close();
//        });
//        Stage stage=new Stage();
//        Parent h = FXMLLoader.load(getClass().getResource("emergente.fxml"));
//        Scene canva = new Scene(h);
//        stage.setScene(canva);
//        stage.showAndWait();
//        this.AgregarColumn();
    }
    
    public void addPizza(){
        PizzaNodo N=new PizzaNodo("xxxx","HAWAIANA","MINI",1,"ORDENADO");
        this.tableOrden.getItems().add(N);
    }
    
    public void AgregarColumn(){
        
        TableColumn<PizzaNodo, String> col1 = new TableColumn<>("id");
        col1.setCellValueFactory(new PropertyValueFactory<>("idPizza"));
        TableColumn<PizzaNodo, String> col2 = new TableColumn<>("sabor");
        col2.setCellValueFactory(new PropertyValueFactory<>("sabor"));
        TableColumn<PizzaNodo, String> col3 = new TableColumn<>("Cantidad");
        col3.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tableOrden.getColumns().addAll(col1,col2,col3);
    }
    @FXML
    public void OnActionHaw(){

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            System.out.println("hola");
//            TableColumn<String, String> col1 = new TableColumn<>("id");
//        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
//        tableOrden.getColumns().addAll(col1);
            this.AgregarColumn();
            this.initTableVentas();
            this.actualizarVentas();
//            pag.setPageFactory(value);
//        tableOrden.getItems().add();
        
    }
    
    
    
}
