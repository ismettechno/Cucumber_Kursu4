package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    public void tes1() throws SQLException {
        // next(): bulunduğu noktadan bir sonraki row
        // previous() : bulunduğu noktadan bir önceki row
        // absolute(4) : baştan itibaren 4.ROW a gider, direkt verine ROW a gider
        // relative(4) : bulunduğu noktadan 4 sonraki ROW a gider.
        ResultSet rs=statement.executeQuery("select * from film");

        rs.absolute(10); // 10.satıra git.
        String title= rs.getString("title");
        System.out.println("title = " + title); //ALADDIN CALENDAR

        rs.absolute(15); // baştan itibaren 15.satıra gider.
        title= rs.getString("title");
        System.out.println("title = " + title); //ALIEN CENTER

        rs.absolute(-15) ; // (-)sondan 15.satıra git
        title=rs.getString("title");
        System.out.println("title = " + title); //WONKA SEA

        rs.absolute(10); // 10.satıra git.
        title= rs.getString("title");
        System.out.println("title = " + title); //ALADDIN CALENDAR

        rs.relative(5); // en son bulunduğun yerden 5 satır ileri
        title= rs.getString("title");
        System.out.println("title = " + title);
    }

}
