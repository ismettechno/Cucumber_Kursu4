package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {

         // Workbook varolan excelin workbook u idi, bunu oluşmamış bir excel için kullanamıyoruz

        XSSFWorkbook workbook= new XSSFWorkbook(); // hafızada bir workbook oluşturuldu
        XSSFSheet sheet=workbook.createSheet("Sayfa1"); // içinde sheet oluşturdum

        // HAFIZADA işlemlere devam ediliyor
        Row yeniSatir=sheet.createRow(0); // hafızada satır oluşturuldu 0.yerde
        Cell yeniHucre=yeniSatir.createCell(0); // hafızada yeni satırda ilk hucre olusturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // hafızada bilgi yazıldı.

        for (int i = 1; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i);  // Merhaba Dünya 1 2 3 4 5 6 7 8 9
        }

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.(SAVE)
        String path="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream); // workbook excel dosyasına yazıldı (save)
        workbook.close(); // workbook için ayrılan hafıza boşaltıldı. (excel kapatıldı)
        outputStream.close(); // yazma için açılan kanal kapatıldı. (program excel kanalı kapatıldı)
        System.out.println("işlem tamamlandı");

    }
}
