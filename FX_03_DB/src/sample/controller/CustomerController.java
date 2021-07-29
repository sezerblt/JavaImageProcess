package sample.controller;

import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import sample.model.Customer;
import sample.model.CustomerDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
public class CustomerController implements Initializable{

    public TextField name_tf;
    public TextField lastname_tf;
    public TextField email_tf;
    public TextField id_tf;
    public TextField email_edit_tf;
    public TextField gsm_tf;

    public Button add_btn;
    public Button search_btn;
    public Button delete_btn;
    public Button update_btn;

    public TableColumn<Customer, Integer> id_col;
    //
    //TableColumn<Person, String> firstNameCol = new TableColumn<>("Customer Name");
    public TableColumn<Customer,String> name_col;
    public TableColumn<Customer,String>  lastname_col;
    public TableColumn<Customer,String>  email_col;
    public TableColumn<Customer,String>  gsm_col;
    public TableView tab_view;
    public TextArea result_area;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_col.setCellValueFactory(param -> param. getValue().customer_idProperty().asObject());
        name_col.setCellValueFactory(param -> param. getValue().customer_nameProperty());
        //name_col.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        lastname_col.setCellValueFactory(param -> param. getValue().customer_lastnameProperty());
        email_col.setCellValueFactory(param -> param. getValue().customer_emailProperty());
        gsm_col.setCellValueFactory(param -> param. getValue().customer_gsmProperty());
        tab_view.setEditable(true);
        //CustomerDAO dao=new CustomerDAO();

        Callback<TableColumn<Customer, String>,
                        TableCell<Customer, String>> cellFactory
                = (TableColumn<Customer, String> p) -> new EditingCell();

        setHandleEditCommit();
        tab_view.getColumns().addAll(id_col, name_col, lastname_col,email_col,gsm_col);

    }

    public void setHandleEditCommit(){
        name_col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Customer,String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Customer,String> event) {
                        ((Customer) event.getTableView().getItems().get(event.getTablePosition().getRow())).setCustomer_name(event.getNewValue());
                    }
                });
        lastname_col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Customer,String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Customer,String> event) {
                        ((Customer) event.getTableView().getItems().get(event.getTablePosition().getRow())).setCustomer_lastname(event.getNewValue());
                    }
                });
        email_col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Customer,String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Customer,String> event) {
                        ((Customer) event.getTableView().getItems().get(event.getTablePosition().getRow())).setCustomer_email(event.getNewValue());
                    }
                });
        gsm_col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Customer,String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Customer,String> event) {
                        ((Customer) event.getTableView().getItems().get(event.getTablePosition().getRow())).setCustomer_gsm(event.getNewValue());
                    }
                });

    }

    public static  int id_count=1;
    public void addAction() throws SQLException, ClassNotFoundException {
        try {
            CustomerDAO.insertCustomer(id_count,name_tf.getText(),lastname_tf.getText(),email_tf.getText());
            id_count++;
            result_area.setText("Customer inserted! \n");
        } catch (SQLException | ClassNotFoundException e) {
            result_area.setText("Musteri eklerken Hata meydana geldi" + e);
            throw e;
        }

    }
    //searchAllCustomers
    public void searchAction() throws SQLException, ClassNotFoundException {
        Customer customer=null;
        try{
            String customerID=id_tf.getText();
            customer= CustomerDAO.searchCustomer(customerID);
            populateAndShowCustomer(customer);
        }catch(Exception e){
            e.printStackTrace();
            result_area.setText("Veri Tabanindan istenilen komut bulunamadi");
            throw e;
        }
    }

    private void populateAndShowCustomer(Customer customer) throws ClassNotFoundException{
        if (customer != null) {
            populateCustomer(customer);
            setEmpInfoToTextArea(customer);
        }else{
            result_area.setText("TMusteri olusturulmadi!\n");
        }
    }
    private void setEmpInfoToTextArea ( Customer customer) {
        result_area.setText("Name: " + customer.getCustomer_name() + "\n" +
                "Last Name: " + customer.getCustomer_lastname());
    }



    public void searchAllListAction() throws SQLException, ClassNotFoundException {
        try{
            //String customerID=id_tf.getText();
            ObservableList<Customer> list  = CustomerDAO.searchAllCustomers();
            populateCustomer((Customer) list);
        }catch(Exception e){
            e.printStackTrace();
            result_area.setText("Veri Tabanindan Liste bulunamadi");
            throw e;
        }

    }


    //tab_view.setItems(CustomerDAO.searchAllCustomers());
    private void populateCustomer (Customer customer) throws ClassNotFoundException{
        //Declare and ObservableList for table view
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        //Add customer to the ObservableList
        customers.add(customer);
        //Set items to the customer table
        tab_view.setItems(customers);
    }

    private void populateCustomers (ObservableList<Customer> customers) throws ClassNotFoundException {
        tab_view.setItems(customers);
    }

    public void deleteAction() throws SQLException, ClassNotFoundException {
        try {
            CustomerDAO.deleteWithCustomerId(id_tf.getText());
            result_area.setText("Employee deleted! Employee id: " + id_tf.getText() + "\n");
        } catch (SQLException | ClassNotFoundException e) {
            result_area.setText("Msteri silinmedi " + e);
            throw e;
        }
    }

    public void updateAction(){
        try {
            CustomerDAO.updateCustomerEmail(id_tf.getText(),email_tf.getText());
            result_area.setText("Email has been updated for, employee id: " + id_tf.getText() + "\n");
        } catch (SQLException | ClassNotFoundException e) {
            result_area.setText("Email guncellenmedi " + e);
        }

    }

    private class EditingCell extends TableCell<Customer, String> {
        private TextField textField;
        public EditingCell() {
        }
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }
        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText((String) getItem());
            setGraphic(null);
        }
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(
                    (ObservableValue<? extends Boolean> arg0,
                     Boolean arg1, Boolean arg2) -> {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                    });
        }
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }//inner-class
}//------
