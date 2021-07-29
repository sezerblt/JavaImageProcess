package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controller.RootLayoutController;

import java.net.URL;


public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Customer Appp V-0.1");

        initRootLayout();
        showCustomerView();
    }

    public void initRootLayout(){
        try{
            //FXML yükleyicisi xml kaynıgını layoutlera yukleme islemini gerceklestirir.
            FXMLLoader fxmlLoader= new FXMLLoader();
            URL location = Main.class.getResource("view/rootLayout.fxml");
            fxmlLoader.setLocation(location);
            rootLayout =(BorderPane)fxmlLoader.load();
            Scene scene=new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController rootLayoutController= fxmlLoader.getController();
            rootLayoutController.setMain(this);
            primaryStage.show();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void showCustomerView(){
        try{
            FXMLLoader fxmlLoader= new FXMLLoader();
            //URL location2 = Main.class.getResource("view/customerView.fxml");
            fxmlLoader.setLocation(Main.class.getResource("view/customerView.fxml"));

            AnchorPane customerViewPane = (AnchorPane) fxmlLoader.load();

            rootLayout.setCenter(customerViewPane);


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
