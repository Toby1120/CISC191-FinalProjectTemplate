package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    //application stage
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    //basic launch function
    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start (Stage primaryStage)throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston-javaFX");

        //Name Column
        TableColumn<Product, String> nameColumn= new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


//Price column
        TableColumn<Product, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        //Quantity column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("price");


        //Quantity input
        quantityInput =new TextField();
        quantityInput.setPromptText("Quantity");





        //Button
        Button addButton= new Button("Add");
        addButton.setOnAction(e-> addButtonClicked());
        Button deleteButton= new Button("Delete");
        deleteButton.setOnAction(e-> deleteButtonClicked());



        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll (nameColumn, priceColumn, quantityColumn);




        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);


        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }



    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();



    }
    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);

    }

    //default parameter
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Bouncy Ball", 2.49, 198));
        products.add(new Product("toilet",99.00,74));
        products.add(new Product("The Notebook DVD", 19.99, 12));
        products.add(new Product("corn", 1.49,856));
        return products;
    }





}














