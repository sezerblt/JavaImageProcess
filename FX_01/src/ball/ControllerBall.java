package ball;

import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControllerBall implements Initializable {
    public AnchorPane anchor;
    public ImageView img_red;
    public ImageView img_green;

    Path anaYol = new Path();
    Path altYol = new Path();
    Path ustYol = new Path();

    Random rnd = new Random();
    Scanner scn = new Scanner(System.in);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Image redball = new Image(getClass().getResourceAsStream("images/red_ball.png")); // var olan bir paket içerisndeki resmi almak için ku llanılır
        Image redball = new Image("images//red_ball.png");
        img_red.setImage(redball);
        img_red.setFitHeight(30);
        img_red.setFitWidth(30);
        img_red.setRotate(.50);

        //Image greenball = new Image(getClass().getResourceAsStream("images/green_ball.png")); // var olan bir paket içerisndeki resmi almak için ku llanılır
        Image greenball = new Image("images//green_ball.png");
        img_green.setImage(greenball);
        img_green.setFitHeight(30);
        img_green.setFitWidth(30);
        img_green.setRotate(.50);

        anchor.getChildren().add(anaYol);
        anaYol.setStrokeWidth(2);
        anaYol.setStroke(Color.AQUA);

    }
    @FXML
    private void mouse_released(){
        int duration1, duration2;
        duration1 = rnd.nextInt(2000)+2000;
        duration2 = rnd.nextInt(2000)+2000;

        PathTransition pts1 = new PathTransition();
        pts1.setPath(ustYol);
        pts1.setNode(img_red);// hareket edecek nesne
        pts1.setDuration(Duration.millis(3000));
        pts1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pts1.play();

        PathTransition pts2 = new PathTransition();
        pts2.setPath(altYol);
        pts2.setNode(img_green);// hareket edecek nesne
        pts2.setDuration(Duration.millis(3000));
        pts2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pts2.play();
    }

    @FXML
    private void mouse_dragged(MouseEvent event) {
        anaYol.getElements().add(new LineTo(event.getX(),event.getY()));
        altYol.getElements().add(new LineTo(event.getX(),event.getY()+40));
        ustYol.getElements().add(new LineTo(event.getX(),event.getY()-40));
    }

    @FXML
    private void mouse_pressed(MouseEvent event) {
        anaYol.getElements().clear();
        ustYol.getElements().clear();
        altYol.getElements().clear();
        anaYol.getElements().add(new MoveTo(event.getX(),event.getY()));// başlangıç noktasını alır
        altYol.getElements().add(new MoveTo(event.getX(),event.getY()+60));
        ustYol.getElements().add(new MoveTo(event.getX(),event.getY()-60));
    }
}
