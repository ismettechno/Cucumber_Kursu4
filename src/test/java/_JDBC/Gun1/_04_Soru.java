package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    // city tablosundaki tüm kayıtlardaki isimleri next ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri absolute ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri relative ile yazdırınız.

    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int cnt=0;
        while(rs.next()){ // bir row, bir sonraki row
            System.out.println(rs.getString("city"));
            cnt++;
        }
        System.out.println("cnt = " + cnt);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int cnt=1;
        while(rs.absolute(cnt)){ // verilen satir numarasına kursoru konumlandırır
            System.out.println(rs.getString("city"));
            cnt++;
        }
        System.out.println("cnt = " + (cnt-1));
    }

    @Test
    public void test3() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int cnt=0;
        while(rs.relative(1)){ // bulunduğu yereden 1 satır sonraya gider
            System.out.println(rs.getString("city"));
            cnt++;
        }
        System.out.println("cnt = " + cnt);
    }


}
