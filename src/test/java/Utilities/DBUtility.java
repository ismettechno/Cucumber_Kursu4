package Utilities;

import org.apache.poi.ss.extractor.ExcelExtractor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public static Statement statement;
    public static Connection connection;
    public static ArrayList<ArrayList<String>> getListData(String query)
    { // query : select * from city;
        ArrayList< ArrayList<String> > tablo=new ArrayList<>();
        // DB den bütün satırları ve kolonları okuyup liste atıcam

        //1- db bağlantısını aç
        DBConnectionOpen();

        //2- sorguyu calistir
        try {
            ResultSet rs = statement.executeQuery(query);
            int kolonSayisi = rs.getMetaData().getColumnCount();

            //3- bütün satırları ve o satırlardaki sütunları oku Tabloya ekle
            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();
                for (int i = 1; i <= kolonSayisi; i++)
                    satir.add(rs.getString(i));

                tablo.add(satir);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        //4- db bağlantısını kapat
        DBConnectionClose();
        return tablo;
    }

    public static void main(String[] args) {
        // getListData fonnksiyonum çalışıyormu
        ArrayList< ArrayList<String> > tablo = getListData("select * from actor");

        // test için kontrol , veriler geldi mi, liste atıldı mı
        //System.out.println("tablo = " + tablo);

        for(List<String> satir : tablo)
            System.out.println("satir = " + satir);
    }

    public static void DBConnectionOpen()
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

    public static void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
