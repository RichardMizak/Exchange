package sk.kosickaakademia.mizak.exchange;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sk.kosickaakademia.mizak.exchange.database.Database;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url=new File("src/main/java/sk/kosickaakademia/mizak/exchange/gui/GuiCalculator.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("CurrencyExchanger3000");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
   //     Database database=new Database();

    }

}

