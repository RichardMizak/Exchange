package sk.kosickaakademia.mizak.exchange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sk.kosickaakademia.mizak.exchange.calc.CurrencyCalc;
import sk.kosickaakademia.mizak.exchange.database.Database;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("GuiCalculator.fxml"));
        primaryStage.setTitle("CurrencyExchanger3000");
        primaryStage.setScene(new Scene(root, 500, 250));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
      Database database=new Database();
     //   database.test();

    }

}

