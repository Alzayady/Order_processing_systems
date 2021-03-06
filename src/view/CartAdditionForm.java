package view;
import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Schema.Book_Order;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static view.ConfirmOrderForm.getObjectsTableFromOrders;


public class CartAdditionForm extends Application {
    private Controller controller = null;
    private ArrayList<Book_Order> cart = null;
    {
        try {
            controller = Controller.get_instance();
            cart = controller.get_userProxy().get_cart();
        } catch (SQLException e) {
            System.out.println("Failed to load Controller;");
        }
    }
    ComponentsBuilder componentsBuilder = new ComponentsBuilder();
    public TableView<Object[]> table = new TableView<>();
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        table.setEditable(true);
        Scene scene = new Scene(new Group());
        stage.setTitle("Shopping Cart");
        table.setPrefWidth(1150);
        table.setPrefHeight(550);
        stage.setWidth(1200);
        stage.setHeight(700);
        stage.setResizable(false);
        Button add_to_cart =new Button("Add to Cart");
        Button remove_from_cart =new Button("Remove From Cart");
        TextField title = new TextField();
        title.setMinWidth(480);
        TextField copies = new TextField();
        copies.setMinWidth(480);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        HBox hBox=new HBox();
        Button back = new Button();
        Button logout = new Button("Logout");
        HBox topBar = componentsBuilder.buildTopHBox(back, logout, stage);
        HBox controlBar = new HBox();
        hBox.setSpacing(100);
        controlBar.setSpacing(5);
        controlBar.getChildren().addAll(title, copies, add_to_cart, remove_from_cart);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(topBar, controlBar, table);
        ((Group)scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
        add_to_cart.setOnAction(e->{
            try {
                table.getColumns().clear();
                Object[][] x= convertCartTOArray(cart);
                SearchBookTableView.UpdateTable(x, table);
            } catch (Exception ex) {
                System.out.println("Error displaying Table");
            }
        });
        remove_from_cart.setOnAction(e->{
            try {
                table.getColumns().clear();
                Object[][] x= convertCartTOArray(cart);
                SearchBookTableView.UpdateTable(x, table);
            } catch (Exception ex) {
                System.out.println("Error displaying Table");
            }
        });
    }

    private Object [][] convertCartTOArray(ArrayList<Book_Order> cart) {
        return getObjectsTableFromOrders(cart, 0);
    }
}