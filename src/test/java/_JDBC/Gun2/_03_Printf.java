package _JDBC.Gun2;

public class _03_Printf {
    public static void main(String[] args) {
        // printf
        int a=2343;
        double pi=3.145656565;
        String isim="ismet temur";
        char basHarf='İ';

        System.out.printf("%5d", a ); // a yı 5 hane içinde ondalık sistemde göster
        // virgülden önceki bölüm format
        // virgülden sonraki bölüm dataları temsil ediyor
        System.out.println("Merhaba");

        System.out.printf("%-5d", a ); // sola dayalı
        System.out.println("Merhaba");

        System.out.printf("%-5d %6.2f \n", a, pi );
        // %6.2f  : toplamda noktadan sonrası dahil
        // 6 hane kullan noktadan 2 hane kullan
        System.out.printf("%-5d %6.2f %20s \n", a, pi, isim );

        System.out.printf("%-6.1f",pi);
        System.out.println("Merhaba");
    }
}
