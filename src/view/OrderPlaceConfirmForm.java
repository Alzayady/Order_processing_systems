package view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class OrderPlaceConfirmForm extends Application {
    ComponentsBuilder componentsBuilder = new ComponentsBuilder();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Order Place/Confirm Form");
        GridPane gridPane = componentsBuilder.createFormPane();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        Button back = new Button();
        Button logout = new Button("Logout");
        HBox hBox = componentsBuilder.buildTopHBox(back, logout);
        vBox.getChildren().addAll(hBox);
        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(20);
        vBox.getChildren().add(gridPane);
        vBox.getChildren().add(hBox1);
        addUIControls(gridPane);
        Button place_order = componentsBuilder.buildButton(hBox, "Place Order",40, 200, true);
        Button confirm_order = componentsBuilder.buildButton(hBox, "Confirm Order",  40, 200, true);
        Scene scene = new Scene(vBox, 800, 640);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Order Place/Confirm");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        Label ISBN_label = componentsBuilder.addLabel(gridPane,"ISBN", 2, 0);
        TextField ISBN = componentsBuilder.addTextField(gridPane, 40, 2, 1);
        Label title_label = componentsBuilder.addLabel(gridPane,"Title", 3, 0);
        TextField title = componentsBuilder.addTextField(gridPane, 40, 3, 1);
        Label username_label = componentsBuilder.addLabel(gridPane,"Username", 4, 0);
        TextField username = componentsBuilder.addTextField(gridPane, 40, 4, 1);
        Label copies_label = componentsBuilder.addLabel(gridPane,"Copies", 5, 0);
        TextField copies = componentsBuilder.addTextField(gridPane, 40, 5, 1);
        Label date_label = componentsBuilder.addLabel(gridPane,"Date", 6, 0);
        TextField date = componentsBuilder.addTextField(gridPane, 40, 6, 1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
