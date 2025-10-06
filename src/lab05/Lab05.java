package lab05;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lab05 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bag Order Form");
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        
        Label result = new Label("");
        root.add(result, 1, 5);
        
        Label one = new Label("Select Bag Style:");
        root.add(one, 0, 0);
        
        ListView<String> bagStyles = new ListView<>();
        bagStyles.getItems().addAll("Full Decorative", "Beaded", 
                "Pirate Design", "Fringed", "Leather", "Plain");
        bagStyles.setPrefHeight(200);
        root.add(bagStyles, 1, 0);
        
        Label three = new Label("Select Quantity:");
        root.add(three, 2, 0);
        
        ComboBox<String> quant = new ComboBox<>();
        quant.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        root.add(quant, 3, 0);
        
        RadioButton radio1 = new RadioButton("Small");
        RadioButton radio2 = new RadioButton("Medium");
        RadioButton radio3 = new RadioButton("Biggest");
        ToggleGroup radioGroup = new ToggleGroup();
        radio1.setToggleGroup(radioGroup);
        radio2.setToggleGroup(radioGroup);
        radio3.setToggleGroup(radioGroup);
        root.add(radio1, 1, 2);
        root.add(radio2, 1, 3);
        root.add(radio3, 1, 4);
        
        Button clear = new Button("Clear Selection");
        clear.setOnAction(e -> {
            bagStyles.getSelectionModel().clearSelection();
            quant.setValue(null);
            radio1.setSelected(false);
            radio2.setSelected(false);
            radio3.setSelected(false);
            result.setText("");
        });
        root.add(clear, 2, 1);
        
        Button order = new Button("Place Order");
        order.setOnAction(e -> {
            if (quant.getValue() == null || radioGroup.getSelectedToggle() == null || bagStyles.getSelectionModel().getSelectedItem() == null) {
                result.setText("Error. Select every option");
            } else {
                RadioButton selected = (RadioButton) radioGroup.getSelectedToggle();
                String radioResult = selected.getText();
                result.setText("You ordered " 
                    + quant.getValue() 
                    + " "
                    + radioResult
                    + " "
                    + bagStyles.getSelectionModel().getSelectedItem()
                    + " Bag");
            }
        });
        root.add(order, 3, 1);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    
}
