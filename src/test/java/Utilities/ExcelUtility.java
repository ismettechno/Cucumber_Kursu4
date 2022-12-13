package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ExcelUtility {
    // kendisine verilen path deki excelin, istenilen, sheetindeki
    // istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    // getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2

    public  static ArrayList< ArrayList<String> > getListData(String path, String sheetName, int columnCnt)
    {
        ArrayList< ArrayList<String> > tablo=new ArrayList<>();

        Sheet sayfa =null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sayfa = workbook.getSheet(sheetName);
        }
        catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        for (int i = 0; i < sayfa.getPhysicalNumberOfRows(); i++) { // bütün satırları getiriyor

            ArrayList<String> satirData=new ArrayList<>();
            for (int j = 0; j < columnCnt; j++) {
                 satirData.add(sayfa.getRow(i).getCell(j).toString());
            }

            tablo.add(satirData);
        }

        return tablo;
    }
    // fonksiyonu çağırıp test yapmak için kullanacağımız main
    public static void main(String[] args) {
      ArrayList< ArrayList<String> >  tablo=
              getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen", 2);

        System.out.println("tablo = " + tablo);
    }
}
