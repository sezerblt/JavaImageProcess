package numpad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Numpad extends Application {

    public static void main(String[] args) {
        System.out.println("->>main->>launch...");
        launch(args);
    }


    @Override
    public void init() throws Exception {
        System.out.println(">>init...");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("-----");
        Parent rootGroup = FXMLLoader.load(getClass().getResource("Numpad.fxml"));
        Scene scene2= new Scene(rootGroup,640,500);
        primaryStage.setTitle("Buton Karistir Kayıt");
        primaryStage.setScene(scene2);
        primaryStage.show();
    }



    @Override
    public void stop() throws Exception {
        System.out.println(">>Stop.");
        super.stop();
    }
}
