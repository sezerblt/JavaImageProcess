package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public Button btn;
    @FXML
    public Button btn_clear;
    public DatePicker pickTarih;
    public Label biletLabel;
    @FXML
    private TextField adText;
    @FXML
    private TextField soyadText;
    @FXML
    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    @FXML
    private ComboBox<String> comboNerden;
    @FXML
    private ComboBox<String> comboNereye;


    ObservableList<String> nereden = FXCollections.observableArrayList("Antalya", "İzmir", "Ankara", "İstanbul");
    ObservableList<String> nereye = FXCollections.observableArrayList("Paris", "Londra ", "Sochi", "Beşiktaş");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_clear.setVisible(false);
        comboNerden.setItems(nereden);
        comboNereye.setItems(nereye);
        btn.setVisible(true);

    }

    @FXML
    public void biletAl() {
        String ad, soyad, tarih, nerden, nereye, koltukNo = null;

        ad = adText.getText();
        soyad = soyadText.getText();
        tarih = pickTarih.getValue().toString();
        nerden = comboNerden.getValue();
        nereye = comboNereye.getValue();



        if (cb1.isSelected()) {
            koltukNo = cb1.getText();
            cb1.setDisable(true);
        } else if (cb2.isSelected()) {
            koltukNo = cb2.getText();
            cb2.setDisable(true);
        } else if (cb3.isSelected()) {
            koltukNo = cb3.getText();
            cb3.setDisable(true);
        } else if (cb4.isSelected()) {
            koltukNo = cb4.getText();
            cb4.setDisable(true);
        } else if (cb5.isSelected()) {
            koltukNo = cb5.getText();
            cb5.setDisable(true);
        } else if (cb6.isSelected()) {
            koltukNo = cb6.getText();
            cb6.setDisable(true);
        } else if (cb7.isSelected()) {
            koltukNo = cb7.getText();
            cb7.setDisable(true);
        } else if (cb8.isSelected()) {
            koltukNo = cb8.getText();
            cb8.setDisable(true);
        }else{
            biletLabel.setText("Koltuk no giriniz!!!");

        }
        //********
        biletLabel.setText("Ad: " + ad + "\n soyad: " + soyad + "\n tarih: "
                + tarih + "\n nerden: " + nerden + "\n nereye: " + nereye + "\n No: " + koltukNo);
        btn.setVisible(false);
        btn_clear.setVisible(true);
    }

    @FXML
    public void sil(){
        adText.clear();
        soyadText.clear();
        pickTarih.setEditable(true);
        comboNerden.setValue("");
        comboNereye.setValue("");

        biletLabel.setText("");
        btn.setVisible(true);
        btn_clear.setVisible(false);

    }
}
