package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {
    // ! Paralel static local anlatmadna önce mikroişlemci gelişimini anlatalık, thread e gelelimki
    // aşağıdaki değişkenler için, thread.Sşeep den bahsedilebilir, pipeline, local ama static eğişken olmalı
    // pipeline-thread-tread.sleep selenium dedği explicit kullanın biz böyle yaptık.burada thread bazlı static değişken
    // yaplaıyızı o lokale özel

    // biz burada tüm sistemi static driver üzerine kurduk, bu durumda bize local static lazım thread özel

    //  hem static hemde her thread e özel değişken : static WebDriver1, static Webdriver2
    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>(); // webDriver 1, webDriver 2
    private static ThreadLocal<String> threadBrowserName=new ThreadLocal<>(); // Chrome, firefox ...

    // threadDriver.get() -> bulunduğum thread deki drierı verecek
    // threadDriver.set(driver) -> bulunduğum thread e driver set ediliyor

    public static WebDriver getDriver()
    {
        // extend report türkçe bilg çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadBrowserName.get() == null) // paralel çalışmayan yani XML den parametreyle gelmeyen ger çağıran
            threadBrowserName.set("chrome"); // Basic araynlar için

        if (threadDriver.get() == null) { // Şu andaki yani bu thread deki driver ım boş mu ?
            //driverı start et doldur, başlat ve gönder

            switch (threadBrowserName.get() )
            {
                case "firefox":
                    //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    //System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;
                default: // diğer testlerimizi direk çalıştırırken, XML den parametre gelmeyeceği için default olarak chrome atandı
                    //System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver()); // bu threade bir webdriver atanıyor
            }
        }

        return threadDriver.get();
    }

    public static void quitDriver()
    {
        try {
            Thread.sleep(5000); // ölmeyecek kullan
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null)  // dolu ise
        {
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get(); driver =null; // theradlocal deki boşaltma için önce al null  a eşitle ve tekrar ata.
            threadDriver.set(driver);
        }
    }

    public static void setThreadBrowserName(String browserName) {
        GWD.threadBrowserName.set(browserName);
    }

    public static String getThreadBrowserName() {
       return GWD.threadBrowserName.get();
    }

}
