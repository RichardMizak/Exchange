package sk.kosickaakademia.mizak.exchange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sk.kosickaakademia.mizak.exchange.database.Database;
import java.io.FileInputStream;
import java.io.InputStream;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("GuiCalculator.fxml"));
        primaryStage.setTitle("CurrencyExchanger3000");
        InputStream stream = new FileInputStream("C:\\Users\\rmiza\\OneDrive\\Plocha\\flags.jpg");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(33);
        imageView.setY(15);
        imageView.setFitWidth(166);
        imageView.setFitHeight(83);
        imageView.setPreserveRatio(true);
        Group group = new Group(imageView);
        primaryStage.setScene(new Scene(root, 500, 250));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
      Database database=new Database();


    }

}

