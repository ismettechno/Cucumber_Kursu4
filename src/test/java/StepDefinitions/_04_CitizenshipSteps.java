package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    LeftNav lf=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to CitizenShip page")
    public void navigateToCitizenShipPage() {
        lf.findAndClick("setupOne");
        lf.findAndClick("parameters");
        lf.findAndClick("citizenShip");
    }

    @When("User a CitizenShip name as {string} short name as {string}")
    public void userACitizenShipNameAsShortNameAs(String name, String shorname) {
       dc.findAndClick("addButton");
       dc.findAndSend("nameInput", name);
       dc.findAndSend("shortName", shorname);
       dc.findAndClick("saveButton");

    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String arananaKelime) {
        dc.findAndDelete(arananaKelime);
    }
}
