package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    public static void main(String[] args) {
        /*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
        */

        System.out.print("İstene sütun=");
        Scanner oku = new Scanner(System.in);
        int sutun = oku.nextInt();

        String donenSonuc = bul(sutun);
        System.out.println("donenSonuc = \n" + donenSonuc);
    }

    public static String bul(int sutun) {
        String donecek = "";
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //bütün satırları dolaş
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(sutun) != null)
              donecek += sheet.getRow(i).getCell(sutun)+"\n";
        }

        return donecek;
    }




}
