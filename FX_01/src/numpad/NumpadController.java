package numpad;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class NumpadController<btnKaristirEvent> implements Initializable {

    public GridPane gridPane;
    public TextArea textArea;
    public Button btn_karistir;
    public Label lbl;

    String password="";
    String txt=" ";
    ArrayList<Integer> list =new  ArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        placeButton();

    }

    public void btnKaristirEvent(){
        txt =txt+password+" ";
        lbl.setText(txt);
        list.clear();
        textArea.clear();
        password="";
        placeButton();
    }

    public void shuffleButton(){
        list.clear();
        Random rnd = new Random();
        int rndUret; // direk for kullanırsak aynı sayıyı üretme ihtimali var.
        for (int i=0;i<9;i++){
            rndUret = rnd.nextInt(10);
            if (i==0)
                list.add(rndUret);
            else{
                while(list.contains(rndUret))//üretilen sayı listenin içinde olduğu sürece
                    rndUret = rnd.nextInt(10);
                list.add(rndUret);
            }
        }

    }

    public void placeButton(){
        shuffleButton();
        int grid_row=0;
        int grid_col=0;

        for (int i=0;i<9;i++){
            final Button btn = new Button();
            btn.setText(String.valueOf(list.get(i)));
            btn.setPrefSize(100, 70);//butonlar 100*70 olacak
            btn.setOnAction(new EventHandler<ActionEvent>() {// aiağısı otomatik oluşturuldu
                @Override
                public void handle(ActionEvent event) {
                    password+=btn.getText();
                    textArea.setText(password);
                    shuffleButton();
                }
            });
            gridPane.add(btn, grid_col, grid_row);
            grid_col++;
            if (grid_col == 3){
                grid_col=0;
                grid_row++;
            }
        }
    }
}
