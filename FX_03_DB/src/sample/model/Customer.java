package sample.model;

import javafx.beans.property.*;

import java.sql.Date;

public class Customer {
    private IntegerProperty customer_id;
    private StringProperty customer_name;
    private StringProperty customer_lastname;
    private StringProperty customer_email;
    private StringProperty customer_gsm;

    public Customer() {
        this.customer_id = new SimpleIntegerProperty();
        this.customer_name = new SimpleStringProperty();
        this.customer_lastname = new SimpleStringProperty();
        this.customer_email = new SimpleStringProperty();
        this.customer_gsm = new SimpleStringProperty();
    }

    public Customer(IntegerProperty customer_id, StringProperty customer_name, StringProperty customer_lastname, StringProperty customer_email, StringProperty customer_gsm) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_lastname = customer_lastname;
        this.customer_email = customer_email;
        this.customer_gsm = customer_gsm;
    }

    public int getCustomer_id() {
        return customer_id.get();
    }

    public IntegerProperty customer_idProperty() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id.set(customer_id);
    }

    public String getCustomer_name() {
        return customer_name.get();
    }

    public StringProperty customer_nameProperty() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name.set(customer_name);
    }

    public String getCustomer_lastname() {
        return customer_lastname.get();
    }

    public StringProperty customer_lastnameProperty() {
        return customer_lastname;
    }

    public void setCustomer_lastname(String customer_lastname) {
        this.customer_lastname.set(customer_lastname);
    }

    public String getCustomer_email() {
        return customer_email.get();
    }

    public StringProperty customer_emailProperty() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email.set(customer_email);
    }

    public String getCustomer_gsm() {
        return customer_gsm.get();
    }

    public StringProperty customer_gsmProperty() {
        return customer_gsm;
    }

    public void setCustomer_gsm(String customer_gsm) {
        this.customer_gsm.set(customer_gsm);
    }
}
