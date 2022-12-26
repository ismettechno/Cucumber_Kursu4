package _JDBC.Gun1;

import org.testng.annotations.*;
import java.sql.*;

public class _02_BeforeAfter {

    public static Statement statement;
    public static Connection connection;

    @BeforeTest
    public void DBConnectionOpen()
    {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        rs.next();
        String dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi); // English

        rs.next();
        System.out.println("rs.getString(2) = " + rs.getString(2)); // Italian

        rs.next();
        System.out.println("rs.getString(2) = " + rs.getString(2)); // Japanese
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        rs.next();
        String dilAdi=rs.getString(2); // English
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        System.out.println("rs.getString(2) = " + rs.getString(2)); // Italian

        rs.previous(); // 1 üst satıra gider
        System.out.println("rs.getString(2) = " + rs.getString(2)); // English
    }




}
