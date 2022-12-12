package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // var olan Excel e yazma işlemi
        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path); // dosya okuma modu açıldı
        Workbook workbook= WorkbookFactory.create(inputStream); // exceldeki workbook hafızaya aldı
        Sheet sheet=workbook.getSheetAt(0);

        // HAFIZADA işlemlere devam ediliyor
        Row yeniSatir=sheet.createRow(0); // hafızada satır oluşturuldu 0.yerde
        Cell yeniHucre=yeniSatir.createCell(0); // hafızada yeni satırda ilk hucre olusturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // hafızada bilgi yazıldı.

        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar, her şey WORKBOOK da
        inputStream.close(); // okuma modu , kanalı kapatılıyor.

         // Yazma işlemini YAZMA modunda açıp öyle yapacağız.(SAVE)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream); // workbook excel dosyasına yazıldı (save)
        workbook.close(); // workbook için ayrılan hafıza boşaltıldı. (excel kapatıldı)
        outputStream.close(); // yazma için açılan kanal kapatıldı. (program excel kanalı kapatıldı)
        System.out.println("işlem tamamlandı");
    }
}
