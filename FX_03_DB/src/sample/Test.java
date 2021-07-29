package sample;

import sample.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseUtil.mysqlConnect();
    }

}
