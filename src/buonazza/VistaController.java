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

    @FXML
    PizzaLista ventas = new PizzaLista();
    @FXML
    PizzaPila Orden = new PizzaPila();
    @FXML
    PizzaPila Ordenes = new PizzaPila();
    @FXML
    PizzaPila Elaboracion = new PizzaPila();
    /**
     * Initializes the controller class.
     */
    @FXML
    public Button agregar;
    @FXML
    private Button elimOrd;
    @FXML
    private Button btnOrdenes;
    @FXML
    private Button btnEjec;
    @FXML
    private Pane btnHaw;
    @FXML
    private TableView tableOrden;
    @FXML
    public TableView tableVentas;
    @FXML
    public TableView tableOrdenes;
    @FXML
    public TableView tableElaboracion;
    @FXML
    public VBox paneTable;
    @FXML
    public Label PrecioOrd;
    @FXML
    public Label TotalVentas;
    @FXML
    int idPizza = 0;
    @FXML
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
        st.setTitle("Menú Hawaiana");
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
            this.idPizza++;
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
        st.setTitle("Menú Mariscos");
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
            this.idPizza++;
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
        st.setTitle("Menú Quesol");
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
            this.idPizza++;
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
        st.setTitle("Menú Salmón");
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
            this.idPizza++;
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
        st.setTitle("Menú Tradicional");
        st.setScene(sc);
        st.showAndWait();

        if (control.Pizza != null) {
            this.p = control.Pizza;
            System.out.println(p.getInfo());
            this.Orden.addPizza(p);
            this.actualizarOrden();
            this.idPizza++;
        }
    }

    public void onActionCrear() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popCrear.fxml"));
        Parent root = loader.load();
        PopCrearController control = loader.getController();
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setTitle("Menú Crear");
        st.setScene(sc);
        st.showAndWait();
        if (control.opc == 1) {
            this.p = control.Pizza;
//            this.p.setValor(control.precio);
            System.out.println(control.precio+"<---- valor del nodo creado");
            this.Orden.addPizza(p);
            this.actualizarOrden();
            this.idPizza++;
            
        }
    }

    public void initTableVentas() {
        tableVentas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tableVentas, Priority.ALWAYS);
        TableColumn<PizzaNodo, String> col = new TableColumn<>("");
        col.setCellValueFactory(new PropertyValueFactory<>("img"));
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
        TableColumn<PizzaNodo, String> col6 = new TableColumn<>("Costo");
        col6.setCellValueFactory(new PropertyValueFactory<>("valor"));

        this.tableVentas.getColumns().addAll(col,col1, col2, col3, col4, col6,col5);
    }

    public void initTableOrdenElab() {
//        this.tableOrdenes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tableOrdenes, Priority.ALWAYS);
        TableColumn<PizzaNodo, String> col1 = new TableColumn<>("id");
        col1.setCellValueFactory(new PropertyValueFactory<>("idPizza"));
        TableColumn<PizzaNodo, String> col2 = new TableColumn<>("Sabor");
        col2.setCellValueFactory(new PropertyValueFactory<>("sabor"));
        TableColumn<PizzaNodo, String> col3 = new TableColumn<>("Tam");
        col3.setCellValueFactory(new PropertyValueFactory<>("tamaño"));
        TableColumn<PizzaNodo, String> col4 = new TableColumn<>("Uni");
        col4.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        TableColumn<PizzaNodo, String> col5 = new TableColumn<>("");
        Callback<TableColumn<PizzaNodo, String>, TableCell<PizzaNodo, String>> cellNew = (TableColumn<PizzaNodo, String> param) -> {
            final TableCell<PizzaNodo, String> cell = new TableCell<PizzaNodo, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button deleteCell = new Button("");
                        deleteCell.getStyleClass().add("btnElim2");
                        deleteCell.setPrefSize(45, 53);
                        deleteCell.setOnAction(e -> {
                            try {
                                p = (PizzaNodo) tableOrdenes.getSelectionModel().getSelectedItem();
                                Ordenes.Elimiar(p.getIdPizza());
                                actualizarOrdenes();

                            } catch (Exception r) {
                                System.out.println("error en celda" + r);
                            }
                        });

                        HBox managebtn = new HBox(deleteCell);
                        managebtn.alignmentProperty().set(Pos.CENTER);
                        managebtn.setPadding(new Insets(10));
                        managebtn.setSpacing(0);
//                        managebtn.getStyleClass().add("cellBtn");
                        setGraphic(managebtn);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        col5.setCellFactory(cellNew);
        TableColumn<PizzaNodo, String> col6 = new TableColumn<>("");
        Callback<TableColumn<PizzaNodo, String>, TableCell<PizzaNodo, String>> cellNew2 = (TableColumn<PizzaNodo, String> param) -> {
            final TableCell<PizzaNodo, String> cell = new TableCell<PizzaNodo, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button AddEla = new Button("Elaborar");
                        AddEla.getStyleClass().add("btnEla");
                        AddEla.setPrefSize(120, 40);
                        AddEla.setOnAction(e -> {
                            p = (PizzaNodo) tableOrdenes.getSelectionModel().getSelectedItem();
                            Elaboracion.addUltimo(p);
                            Ordenes.Elimiar(p.getIdPizza());
                            System.out.println(Elaboracion.getnPizzas() + " numero de nodo en Elaboracion");
                            actualizarOrdenes();
                            actualizarElaboracion();
                        });

                        HBox managebtn = new HBox(AddEla);
                        managebtn.alignmentProperty().set(Pos.CENTER);
                        managebtn.setPadding(new Insets(15));
                        managebtn.setSpacing(0);
//                        managebtn.getStyleClass().add("cellBtn");
                        setGraphic(managebtn);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        col6.setCellFactory(cellNew2);
        col1.getStyleClass().add("cellCab");
        col4.getStyleClass().add("cellCola");
        col4.getStyleClass().add("cellNone");
        col4.getStyleClass().add("cellNone");
        col5.setPrefWidth(90);
        col2.setPrefWidth(228);
        col3.setPrefWidth(100);
        col4.setPrefWidth(100);
        col6.setPrefWidth(200);

        this.tableOrdenes.getColumns().addAll(col1, col2, col3, col4, col5, col6);
    }

    public void initTableElabo() {
        this.tableElaboracion.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<PizzaNodo, String> col1 = new TableColumn<>("id");
        col1.setCellValueFactory(new PropertyValueFactory<>("idPizza"));
        TableColumn<PizzaNodo, String> col2 = new TableColumn<>("Sabor");
        col2.setCellValueFactory(new PropertyValueFactory<>("sabor"));
        TableColumn<PizzaNodo, String> col3 = new TableColumn<>("Tamaño");
        col3.setCellValueFactory(new PropertyValueFactory<>("tamaño"));
        TableColumn<PizzaNodo, String> col4 = new TableColumn<>("Cantidad");
        col4.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<PizzaNodo, String> col6 = new TableColumn<>("");
        Callback<TableColumn<PizzaNodo, String>, TableCell<PizzaNodo, String>> cellNew2 = (TableColumn<PizzaNodo, String> param) -> {
            final TableCell<PizzaNodo, String> cell = new TableCell<PizzaNodo, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button AddV = new Button("Listo");
                        AddV.getStyleClass().add("btnEla");
                        AddV.setPrefSize(120, 40);
                        AddV.setOnAction(e -> {
                            p = (PizzaNodo) tableElaboracion.getSelectionModel().getSelectedItem();
                            Elaboracion.Elimiar(p.getIdPizza());
                            ventas.addNodoVentasDoc(p);
                            actualizarVentas();
                            actualizarElaboracion();

                        });

                        HBox managebtn = new HBox(AddV);
                        managebtn.alignmentProperty().set(Pos.CENTER);
                        managebtn.setPadding(new Insets(15));
                        managebtn.setSpacing(0);
//                        managebtn.getStyleClass().add("cellBtn");
                        setGraphic(managebtn);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        col6.setCellFactory(cellNew2);
        col1.getStyleClass().add("cellCab");
        col4.getStyleClass().add("cellCola");
        col4.getStyleClass().add("cellNone");
        col4.getStyleClass().add("cellNone");

        this.tableElaboracion.getColumns().addAll(col1, col2, col3, col4, col6);
    }

    public void actualizarVentas() {
        ventas.leerVentas();
        if (ventas.getnPizzas() != 0) {
            for (int i = 0; i < tableVentas.getItems().size(); i++) {
                tableVentas.getItems().clear();
            }
            if (ventas.getnPizzas() == 1) {
                tableVentas.getItems().clear();
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
        this.actLabelTotalVentas();
    }

    public void actLabelTotalVentas() {
        this.TotalVentas.setText("Total $" + this.ventas.getTotalPrecio());
    }

    public void popUp() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("emergente.fxml"));
        Parent root = loader.load();
        EmergenteController control = loader.getController();
        control.titulo("¿Quieres cancelar el pedido?");
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setTitle("Cancelar Orden");
        st.setScene(sc);
        st.showAndWait();
        System.out.println(control.opc);
        if (control.opc == 1) {
            this.tableOrden.getItems().clear();
            this.Orden = new PizzaPila();
            this.Orden.getnPizzas();
            this.actualizarOrden();
        }

    }

    public void addPizza() {

        this.Orden.addPizza(String.valueOf(this.idPizza), "HAWAIANA", "MINI", 1, "ORDENADO");
        this.idPizza++;
        this.actualizarOrden();
    }

    public void actualizarOrden() {
        System.out.println(Orden.getnPizzas() + "<------- Actualizadon ");
        if (Orden.getnPizzas() != 0) {
            this.tableOrden.getItems().clear();
            System.out.println(Orden.getnPizzas() + " verif acutalizar en ordenes");
            if (Orden.getnPizzas() == 1) {
                this.tableOrden.getItems().clear();
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
        } else {
            this.tableOrden.getItems().clear();
        }
        this.PrecioOrd.setText("Total $" + this.Orden.getTotalPrecio());
    }

    public void actualizarOrdenes() {
        System.out.println(Ordenes.getnPizzas() + "<------- Actualizadon ");
        if (Ordenes.getnPizzas() != 0) {
            this.tableOrdenes.getItems().clear();
            System.out.println(Ordenes.getnPizzas() + " verif acutalizar en ordenes");
            if (Ordenes.getnPizzas() == 1) {
                this.tableOrdenes.getItems().clear();
                tableOrdenes.getItems().add(Ordenes.getCab());
            } else {
                PizzaNodo i = Ordenes.getCab();
                while (i.getSig() != null) {
                    tableOrdenes.getItems().add(i);
//                    System.out.println(i.getNombre());
                    i = i.getSig();
                }
                tableOrdenes.getItems().add(i);
            }
        } else {
            this.tableOrdenes.getItems().clear();
        }
    }

    public void actualizarElaboracion() {
        System.out.println(Elaboracion.getnPizzas() + "<------- Actualizadon ");
        if (Elaboracion.getnPizzas() != 0) {
            this.tableElaboracion.getItems().clear();
            System.out.println(Elaboracion.getnPizzas() + " verif acutalizar en ordenes");
            if (Elaboracion.getnPizzas() == 1) {
                this.tableElaboracion.getItems().clear();
                tableElaboracion.getItems().add(Elaboracion.getCab());
            } else {
                PizzaNodo i = Elaboracion.getCab();
                while (i.getSig() != null) {
                    tableElaboracion.getItems().add(i);
//                    System.out.println(i.getNombre());
                    i = i.getSig();
                }
                tableElaboracion.getItems().add(i);
            }
        } else {
            this.tableElaboracion.getItems().clear();
        }
    }

    public void initTableOrden() {
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
                        deleteCell.setPrefSize(40, 45);
                        deleteCell.getStyleClass().add("btnElim2");
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
                        managebtn.setSpacing(0);
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

    public void refresTableOrdElab() {
        this.tableOrdenes.getColumns().clear();
    }

    public void TableElaboracion() {
        this.refresTableOrdElab();
        this.initTableElabo();
        this.actualizarElaboracion();
    }

    public void TableOrdenes() {
        this.refresTableOrdElab();
        this.initTableOrdenElab();
        this.actualizarOrdenes();
    }

    public void InsertTableOrdenes() {
        this.actualizarOrdenes();
        this.paneTable.getChildren().clear();
        this.paneTable.getChildren().add(this.tableOrdenes);
        this.tableElaboracion.setPrefHeight(-110);
//        this.tableElaboracion.
//        this.tableElaboracion.setVisible(false);
        this.tableOrdenes.setPrefHeight(1000);
//        this.tableOrdenes.setVisible(true);

    }

    public void insertTableElabo() {
        this.actualizarElaboracion();
        this.paneTable.getChildren().clear();
        this.paneTable.getChildren().add(this.tableElaboracion);
//        this.tableElaboracion.setDisable(true);
        this.tableElaboracion.setPrefHeight(1000);
//        this.tableElaboracion.setVisible(true);
        this.tableOrdenes.setPrefHeight(-110);
//        this.tableOrdenes.setVisible(false);
    }

    public void PassOrdenes() {
        this.tableOrden.getItems().clear();
        System.out.println(this.Orden.getnPizzas());
        PizzaNodo aux = this.Orden.getCab();
        if (this.Orden.getnPizzas() != 0) {
            while (aux.getSig() != null) {
                System.out.println("agregado");
                Ordenes.addPizza(aux);
                aux = aux.getSig();

            }
        }

        System.out.println("agregado");
        Ordenes.addPizza(aux);
//        this.Ordenes.addPila(Orden);
        this.actualizarOrdenes();
        this.Orden = new PizzaPila();
        System.out.println(this.Orden.getnPizzas());

    }

    public void OnPassOrdenes() {
        this.Ordenes.addPizzaCola(Orden);
        this.actualizarOrdenes();
        this.tableOrden.getItems().clear();
        Orden = new PizzaPila();
        this.actualizarOrden();
    }

    @FXML
    public void OnActionHaw() {

    }

    public void initialize() {

        this.tableOrdenes.getStyleClass().add("tableOrd");
        this.initTableOrden();
        this.initTableVentas();
        this.actualizarVentas();
        this.initTableOrdenElab();
        this.initTableElabo();
        this.InsertTableOrdenes();
        this.idPizza=ventas.obtenerid()+1;

    }

}
