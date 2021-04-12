package sk.kosickaakademia.mizak.exchange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GuiCalculator.fxml"));
        primaryStage.setTitle("CurrencyExchanger3000");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("USD");

    }

}

