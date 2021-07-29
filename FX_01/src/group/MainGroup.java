package group;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGroup extends Application {


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
        Parent rootGroup = FXMLLoader.load(getClass().getResource("group.fxml"));
        Scene scene2= new Scene(rootGroup,640,480);
        primaryStage.setTitle("Proje Takimi");
        primaryStage.setScene(scene2);
        primaryStage.show();
    }



    @Override
    public void stop() throws Exception {
        System.out.println(">>Stop.");
        super.stop();
    }

}
