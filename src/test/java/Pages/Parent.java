package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element); // gözükene kadar bekle
        scrollToelement(element);  // elemente kadar scroll yap (javascriptexecuter)
        element.clear();           //        temizle  (clear)
        element.sendKeys(value);//        değeri gönder (sendKeys)
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element); // Clickable olana kadar bekle
        scrollToelement(element);  // elemente kadar scroll yap (javascriptexecuter)
        element.click();           //        click
    }

    public void waitUntilVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToelement(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsTextFunction(WebElement element, String value)
    {
        //waitUntilVisible(element); // gözükene kadar bekle
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"The text you searched could'nt be find");
    }

}

// case sensitive, stringin bir parçası olabilir
//wait.until(ExpectedCondition.textToBePresentInElement(By,"Looking4TextOnElement");//This verifies if text is present on element By.
//wait.until(ExpectedCondition.textToBePresentInElementValue(By,"Looking4TextOnValueAttribute");//This verifies if text is present in value attribute of element By.