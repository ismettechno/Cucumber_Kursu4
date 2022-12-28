package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBCSteps {

    @Then("Send The query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sorgu) {

        // DB den gerekli listeyi alıcam
        ArrayList < ArrayList<String>> dbList=DBUtility.getListData(sorgu);
        System.out.println(dbList); //db kontrol

        // Webden Ekrandaki listesi alıcam
        DialogContent dc=new DialogContent();
        List<WebElement> uiList = dc.nameList;
        for(WebElement e: uiList)
            System.out.println(e.getText()); // ui kontrol


        // karşılaştırıcam
        for(int i=0; i <dbList.size(); i++) {
            System.out.println("->"+dbList.get(i).get(1).trim()+"<-");
            System.out.println("->"+uiList.get(i).getText().trim()+"<-");

            Assert.assertEquals(dbList.get(i).get(1).trim(),
                    uiList.get(i).getText().trim(), "Hatalı durum");
        }

    }
}
