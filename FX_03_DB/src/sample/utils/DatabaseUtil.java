package sample.utils;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DatabaseUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/companydb";

    private static Connection conn=null;

    private static final String USER = "root";
    private static final String PASS = "Root123";

    public static void mysqlConnect() throws SQLException, ClassNotFoundException {
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("MYSQL Driver Tanımlandi");
        }catch (ClassNotFoundException se){
            System.out.println("MYSQL JDBC Driver Bulunamadi");
            se.printStackTrace();
            throw se;
        }

        //try2
        try{
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException throwables) {
            System.out.println("MYSQL Baglantisi gerceklesmedi");
            throwables.printStackTrace();
            throw throwables;
        }

    }

    public static  void mysqlDiscconetc() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            System.out.println("MYSQL Kapanmadi");
            throw e;
        }
    }

    public static ResultSet executeQuery(String statement) throws SQLException {
        CachedRowSetImpl crs = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            mysqlConnect();
            preparedStatement=conn.prepareStatement(statement);
            System.out.println("query: "+statement);
            resultSet=preparedStatement.executeQuery();

            crs = new CachedRowSetImpl();
            crs.populate(resultSet);

        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Sorgulama da Hata");
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            mysqlDiscconetc();
        }
        return resultSet;
    }

    public static void executeUpdate(String statement) throws SQLException, ClassNotFoundException {
        //Statement stmt = null;
        PreparedStatement preparedStatement=null;
        try {
            mysqlConnect();
            //stmt = conn.createStatement();
            //stmt.executeUpdate(statement);
            preparedStatement=conn.prepareStatement(statement);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Güncelleöe Hatasi: " + e);
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            mysqlDiscconetc();
        }
    }
}
