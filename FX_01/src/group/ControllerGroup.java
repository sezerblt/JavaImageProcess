package group;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGroup implements Initializable {


    public TextField ad_text;
    public TextField soyad_text;
    public TextField proje_text;
    public RadioButton ekle_rb;
    public RadioButton sil_rb;
    public RadioButton guncelle_rb;
    public Button onayla_btn;
    public ListView<String> isim_list;
    public ListView<String> grup_list;
    public Button ekle_btn;
    public Button cikar_btn;
    public Button kaydet_btn;
    public TextArea liste_area;
    public ComboBox danisman_combo;

    ObservableList<String> sagList = FXCollections.observableArrayList("Kisi1 kisi1","Berkan akan","Yusuf gul","Ahmet at","Can Kan");
    ObservableList<String> solList = FXCollections.observableArrayList();
    ObservableList<String> danismanList = FXCollections.observableArrayList("Danisman danisman","Aykut miras","Hedim Hakan");

    ObservableList<String> yedekListeSag = FXCollections.observableArrayList();
    ObservableList<String> yedekListeSol = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        ekle_rb.setToggleGroup(group);
        sil_rb.setToggleGroup(group);
        danisman_combo.setItems(danismanList);
        grup_list.setItems(sagList);
    }

    @FXML
    private void onayla(){
        String girilen = ad_text.getText();
        String girilen2 = soyad_text.getText();
        yedekListeSag=grup_list.getItems();
        if(ekle_rb.isSelected())
        {
            yedekListeSag.add(girilen+" "+girilen2);
        }
        if(sil_rb.isSelected())
        {
            yedekListeSag.remove(girilen+" "+girilen2);
        }
        grup_list.setItems(yedekListeSag);

        ad_text.clear();
        soyad_text.clear();
        proje_text.clear();
    }

    @FXML
    private void grubaEkle(){
        String secilen = grup_list.getSelectionModel().getSelectedItem();
        yedekListeSag = grup_list.getItems();
        yedekListeSag.remove(secilen);
        grup_list.setItems(yedekListeSag);

        yedekListeSol = isim_list.getItems();
        yedekListeSol.add(secilen);
        isim_list.setItems(yedekListeSol);
    }

    @FXML
    private void gruptanCikar(){
        String secilen2 = isim_list.getSelectionModel().getSelectedItem();
        yedekListeSol = isim_list.getItems();
        yedekListeSol.remove(secilen2);
        isim_list.setItems(yedekListeSol);
// Şimdi diğer tarafa ekleyelim.
        yedekListeSag = grup_list.getItems();
        yedekListeSag.add(secilen2);
        grup_list.setItems(yedekListeSag);
// Başarılı.
    }

    @FXML
    private void grupKaydet(){
        String projeAdi = proje_text.getText();
        yedekListeSol = isim_list.getItems();
        String danisman = (String) danisman_combo.getValue();
        String grupElemanları="";
// Listeyi çekebilmemiz için her indisi tek tek çekmemiz lazım.
        for (int i=0; i < yedekListeSol.size(); i++)
            grupElemanları= grupElemanları + ", " + yedekListeSol.get(i);
        liste_area.setText("Proje Bilgileri: \nProje Adı: "+projeAdi+"\nGrup Elemanları: "+ grupElemanları+"\nDanışman: "+danisman);
    }

    @FXML
    private void danismanSec(){
    }


}
