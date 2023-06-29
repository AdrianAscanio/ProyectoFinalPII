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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.PizzaLista;
import modelo.PizzaNodo;
import modelo.PizzaPila;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class VistaController {

    PizzaLista ventas = new PizzaLista();
    PizzaPila Orden = new PizzaPila();
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
    int idPizza = 0;
    PizzaNodo p = null;

    @FXML
    public void onActionhawaiana() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController control = loader.getController();
        control.IdP = String.valueOf(this.idPizza);
        control.sab = "HAWAIANA";
        control.setTitutlo("Hawaiana");
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
        }
    }

    public void onActionMariscos() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController control = loader.getController();
        control.IdP = String.valueOf(this.idPizza);
        control.sab = "MARISCOS";
        control.setTitutlo("Mariscos");
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
        }

    }

    public void onActionQueso() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController control = loader.getController();
        control.IdP = String.valueOf(this.idPizza);
        control.sab = "QUESO";
        control.setTitutlo("Queso");
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
        }
    }

    public void onActionSalmon() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController control = loader.getController();
        control.IdP = String.valueOf(this.idPizza);
        control.sab = "SALMON";
        control.setTitutlo("Salmón");
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
        }
    }

    public void onActionTradicional() throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("popMenu.fxml"));
        Parent root = loader.load();
        PopMenuController control = loader.getController();
        control.IdP = String.valueOf(this.idPizza);
        control.sab = "TRADICIONAL";
        control.setTitutlo("Tradicional");
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
        }
    }

    public void initTableVentas() {
        tableVentas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<PizzaNodo, String> col1 = new TableColumn<>("id");
        col1.setCellValueFactory(new PropertyValueFactory<>("idPizza"));
        TableColumn<PizzaNodo, String> col2 = new TableColumn<>("Sabor");
        col2.setCellValueFactory(new PropertyValueFactory<>("sabor"));
        TableColumn<PizzaNodo, String> col3 = new TableColumn<>("Tamaño");
        col3.setCellValueFactory(new PropertyValueFactory<>("tamaño"));
        TableColumn<PizzaNodo, String> col4 = new TableColumn<>("Cantidad");
        col4.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        TableColumn<PizzaNodo, String> col5 = new TableColumn<>("Estado");
        col5.setCellValueFactory(new PropertyValueFactory<>("estado"));
        this.tableVentas.getColumns().addAll(col1, col2, col3, col4, col5);
    }

    public void actualizarVentas() {
        ventas.leerVentas();
        if (ventas.getnPizzas() != 0) {
            for (int i = 0; i < tableVentas.getItems().size(); i++) {
                tableVentas.getItems().clear();
            }
            if (ventas.getnPizzas() == 1) {
                tableVentas.getItems().add(ventas.getCab());
            } else {
                PizzaNodo i = ventas.getCab();
                while (i.getSig() != null) {
                    tableVentas.getItems().add(i);
//                    System.out.println(i.getNombre());
                    i = i.getSig();
                }
                tableVentas.getItems().add(i);
            }
        }

    }

    public void popUp() throws IOException {
        EmergenteController emer = new EmergenteController();

        emer.popEmer("¿Deseas Cancelar La orden?");
        emer.btnClose.setOnAction(e -> {
            emer.stageEme.close();
        });

    }

    public void addPizza() {

//        PizzaNodo N = new PizzaNodo("1", "HAWAIANA", "MINI", 1, "ORDENADO");
        this.Orden.addPizza(String.valueOf(this.idPizza), "HAWAIANA", "MINI", 1, "ORDENADO");
        this.idPizza++;
        this.actualizarOrden();
//        this.tableOrden.getItems().add(N);
    }

    public void actualizarOrden() {
//        ventas.leerVentas();
        if (Orden.getnPizzas() != 0) {
            for (int i = 0; i < tableOrden.getItems().size(); i++) {
                tableOrden.getItems().clear();
            }
            if (Orden.getnPizzas() == 1) {
                tableOrden.getItems().add(Orden.getCab());
            } else {
                PizzaNodo i = Orden.getCab();
                while (i.getSig() != null) {
                    tableOrden.getItems().add(i);
//                    System.out.println(i.getNombre());
                    i = i.getSig();
                }
                tableOrden.getItems().add(i);
            }
        }
    }

    public void AgregarColumn() {
        tableOrden.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tableOrden, Priority.ALWAYS);
        TableColumn<PizzaNodo, String> col1 = new TableColumn<>("");
        col1.setCellValueFactory(new PropertyValueFactory<>("img"));
        col1.setPrefWidth(100);
        TableColumn<PizzaNodo, String> col2 = new TableColumn<>("");
        col1.setPrefWidth(150);
        col2.setCellValueFactory(new PropertyValueFactory<>("Info"));
        TableColumn<PizzaNodo, String> col3 = new TableColumn<>("");
        col3.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        TableColumn<PizzaNodo, String> col4 = new TableColumn<>("");
        Callback<TableColumn<PizzaNodo, String>, TableCell<PizzaNodo, String>> cellNew = (TableColumn<PizzaNodo, String> param) -> {
            final TableCell<PizzaNodo, String> cell = new TableCell<PizzaNodo, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button deleteCell = new Button("");
//                        deleteCell.set
//                        deleteCell.set
                        deleteCell.getStyleClass().add("btnElim1");
                        deleteCell.setOnAction(e -> {
                            try {
                                p = (PizzaNodo) tableOrden.getSelectionModel().getSelectedItem();
                                Orden.Elimiar(p.getIdPizza());
                                actualizarOrden();

                            } catch (Exception r) {
                                System.out.println("error en celda");
                            }
                        });

                        HBox managebtn = new HBox(deleteCell);
                        managebtn.alignmentProperty().set(Pos.CENTER);
                        managebtn.setPadding(new Insets(15));
                        managebtn.setSpacing(0);
                        managebtn.getStyleClass().add("cellBtn");
                        setGraphic(managebtn);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        col4.setCellFactory(cellNew);
        tableOrden.getColumns().addAll(col1, col2, col4);
    }

    @FXML
    public void OnActionHaw() {

    }

    public void initialize() {

//            System.out.println("hola");s
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
