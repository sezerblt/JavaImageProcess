package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.utils.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public static Customer searchCustomer(String customer_id) throws SQLException{

        String query = "SELECT * FROM customer WHERE customer_id="+customer_id;

        try{
            ResultSet rs= DatabaseUtil.executeQuery(query);
            Customer customer=getCustomerFromResultSet(rs);
            return customer;

        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    public static ObservableList<Customer> searchAllCustomers() throws SQLException {
        String query = "SELECT * FROM customer";
        ObservableList<Customer> list=null;

        try{
            ResultSet rs= DatabaseUtil.executeQuery(query);
            list = getCustomerList(rs);

            return list;

        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteWithCustomerId(String customer_id) throws SQLException, ClassNotFoundException{

        String query = " DELETE FROM customer WHERE customer_id "+ customer_id ;

        try {
            DatabaseUtil.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print("Silmne İsleminde Hata " + e);
            throw e;
        }

    }

    public static void updateCustomerEmail (String customer_id, String customer_email) throws SQLException, ClassNotFoundException{
        String query = " UPDATE customer SET customer_email = '" + customer_email + "' WHERE customer_id = " + customer_id;

        try {
            DatabaseUtil.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(" UPDATE email Operation: " + e);
            throw e;
        }
    }

    public static void updateCustomerGsm (String customer_id, String customer_gsm) throws SQLException, ClassNotFoundException{
        String query = " UPDATE customer SET customer_gsm = '" + customer_gsm + "' WHERE customer_id = " + customer_id;
        try {
            DatabaseUtil.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(" UPDATE email Operation: " + e);
            throw e;
        }
    }

    public static void insertCustomer(int id,String name, String lastname, String email) throws SQLException, ClassNotFoundException{
        String query = "INSERT INTO customer (customer_id, customer_name, customer_lastname, customer_email, customer_gsm)\n" +
                        "VALUES " +
                        "('"+id+"', '"+name+"', '"+lastname+"','"+email+"','0000000000')" ;

        try {
            DatabaseUtil.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(" Ekleme Yapilmadi: " + e);
            throw e;
        }

    }

    //-----------------------------------------------------------------------------------------
    public static Customer getCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer=null;
        if(resultSet.next()){
            customer = new Customer();
            customer.setCustomer_id(resultSet.getInt("customer_id"));
            customer.setCustomer_name(resultSet.getString("customer_name"));
            customer.setCustomer_lastname(resultSet.getString("customer_lastname"));
            customer.setCustomer_email(resultSet.getString("customer_email"));
            customer.setCustomer_gsm(resultSet.getString("customer_gsm"));
        }
        return customer;
    }

    public static ObservableList<Customer> getCustomerList(ResultSet resultSet) throws SQLException {
        ObservableList<Customer> observable_list = FXCollections.observableArrayList();

        while(resultSet.next()){
            Customer customer = new Customer();
            customer.setCustomer_id(resultSet.getInt("customer_id"));
            customer.setCustomer_name(resultSet.getString("customer_name"));
            customer.setCustomer_lastname(resultSet.getString("customer_lastname"));
            customer.setCustomer_email(resultSet.getString("customer_email"));
            customer.setCustomer_gsm(resultSet.getString("customer_gsm"));
            observable_list.add(customer);
        }
        return observable_list;
    }
}
