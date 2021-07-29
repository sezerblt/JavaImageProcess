package product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class UrunController implements Initializable {


    public TextField urunno_tf;
    public TextField urunad_tf;
    public TextField uruncins_tf;
    public TextField urunfiyat_tf;
    public TextField urunmiktar_tf;
    public TextField urunmarka_tf;
    public Button btn_ekle;
    public Button btn_sil;

    public TableView<Urun> urunler_tabview;
    public TableColumn<Urun,Integer> urunno_col;
    public TableColumn<Urun,String> urunad_col;
    public TableColumn<Urun,String> uruncins_col;
    public TableColumn<Urun,Double> urunfiyat_col;
    public TableColumn<Urun,Integer> urunmiktar_col;
    public TableColumn<Urun,String> tip_col;
    public Button btn_liste;
    public Label info_lbl;
    public ComboBox<String> miktar_combo;

    ObservableList<Urun> urun_observableList = FXCollections.observableArrayList();
    ObservableList<String> tipList = FXCollections.observableArrayList("Kg","Demet","Adet");


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        miktar_combo.setItems(tipList);
        miktar_combo.setValue(tipList.get(0));
        PropertyValueFactory<Urun,Integer> pvf=new PropertyValueFactory("urunNo");
        PropertyValueFactory<Urun,String> pvf1=new PropertyValueFactory("urunAd");
        PropertyValueFactory<Urun,String> pvf2=new PropertyValueFactory("urunCins");
        PropertyValueFactory<Urun,Double> pvf3=new PropertyValueFactory("urunFiyat");
        PropertyValueFactory<Urun,Integer> pvf4=new PropertyValueFactory("urunMiktar");
        urunno_col.setCellValueFactory(pvf);
        urunad_col.setCellValueFactory(pvf1);
        uruncins_col.setCellValueFactory(pvf2);
        urunfiyat_col.setCellValueFactory(pvf3);
        urunmiktar_col.setCellValueFactory(pvf4);;
        info_lbl.setText("");
    }

    @FXML
    private void urunEkle(ActionEvent event){
        String ad_tf,cins_tf,tip;
        int no_tf;
        int miktar_tf;
        double fiyat_tf;

        Urun urun= new Urun();
        UrunDAO dao=new UrunDAO();

        if(urunno_tf.getText().isEmpty() ||urunad_tf.getText().isEmpty() || urunfiyat_tf.getText().isEmpty() || urunmiktar_tf.getText().isEmpty()){
            info_lbl.setText(" Alanlar bos birakilmaz");
        }else{
            no_tf = Integer.parseInt(urunno_tf.getText());
            ad_tf=urunad_tf.getText();
            cins_tf=uruncins_tf.getText();
            fiyat_tf= Double.parseDouble(urunfiyat_tf.getText());
            miktar_tf= Integer.parseInt(urunmiktar_tf.getText());
            tip=miktar_combo.getValue();

            urun.setUrunNo(no_tf);
            urun.setUrunAd(ad_tf);
            urun.setUrunCins(cins_tf);
            urun.setUrunFiyat(fiyat_tf);
            urun.setUrunMiktar(miktar_tf);
            info_lbl.setText(urun.getUrunAd()+" Veri tabanina eklendi");

            dao.insertUrun(urun);

            urun_observableList.add(urun);
            urunler_tabview.setItems(urun_observableList);

        }

        urun_observableList = urunler_tabview.getItems();


        urunno_tf.clear();
        urunad_tf.clear();
        uruncins_tf.clear();
        urunfiyat_tf.clear();
        urunmiktar_tf.clear();
        urunmarka_tf.clear();
    }

    @FXML
    private void urunSil(ActionEvent event){
        UrunDAO dao = new UrunDAO();
        info_lbl.setText("");
        int chosedIndex = 0;
        String text=null;
        //tablo->ModelSecimi->indisSecimi
        if(urunler_tabview.getSelectionModel().getSelectedIndices().isEmpty()){
            info_lbl.setText("Urun Yok");
            System.out.println("**********Liste Bosaldi,***********");
        }
        else{
            text=urunler_tabview.getSelectionModel().getSelectedItem().getUrunAd().toString();
            chosedIndex = urunler_tabview.getSelectionModel().getSelectedIndex();
            urunler_tabview.getItems().remove(chosedIndex);
            dao.deleteUrun(chosedIndex);
        }
        info_lbl.setText(text +" vweri tabanından silindi");

    }


    @FXML
    private void getListe(ActionEvent event){

    }
}
