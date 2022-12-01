package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{

    public FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;

    @FindBy(xpath = "(//mat-option[@role='option']/span[.=' 2.Grade '])")
    private WebElement gradeLevel3;

    @FindBy(xpath = "(//mat-option[@role='option']/span[.=' 3.Grade '])")
    private WebElement gradeLevel4;

    @FindBy(xpath = "(//mat-option[@role='option']/span[.=' 4.Grade '])")
    private WebElement gradeLevel5;

    WebElement myElement;
    public void findAndClick(String strlement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "academicPeriod":
                myElement = academicPeriod;
                break;
            case "academicPeriod1":
                myElement = academicPeriod1;
                break;
            case "gradeLevel":
                myElement = gradeLevel;
                break;
            case "gradeLevel2":
                myElement = gradeLevel2;
                break;
            case "gradeLevel3":
                myElement = gradeLevel3;
                break;
            case "gradeLevel4":
                myElement = gradeLevel4;
                break;
            case "gradeLevel5":
                myElement = gradeLevel5;
                break;

        }

        clickFunction(myElement);
    }


}
