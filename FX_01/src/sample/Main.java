package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("Uygulama alt sınıfından çağırıliyor...");
        launch(args);
    }


    @Override
    public void init() throws Exception {
        System.out.println("Uygulama için gerekli ilk değer atamaları yapiliyor");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("tüm uygulamalar tarafından gerçekleştiriliyor...");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene= new Scene(root,640,480);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    @Override
    public void stop() throws Exception {
        System.out.println("yapılacak son işlemler ---- Uygulama sonlandiriliyor... ");
        super.stop();
    }


}
