package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _01_LoginSteps {


    @Given("Naviagate to Campus")
    public void naviagateToCampus() {

        GWD.getDriver().get("https://demo.mersys.io/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click Login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        DialogContent dc=new DialogContent();

        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dc.username));

        dc.username.sendKeys("richfield.edu");
        dc.password.sendKeys("Richfield2020!");
        dc.loginButton.click();
    }

    @Then("User should login successfuly")
    public void userShouldLoginSuccessfuly() {
        Assert.fail();
    }
}
