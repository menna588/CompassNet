import base.TestBase;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class RegisterPage extends TestBase {
    public RegisterPage() throws IOException {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='header-btn header-btn-yellow button-signup']")
    WebElement signbtn ;

    @FindBy(xpath = "//div[@class='v2-form__title']")
    WebElement registertitle ;

    @FindBy(xpath = "//div[@class='fp-signup-selector active']//div[@class='links']")
    WebElement registerpopup ;

    @FindBy(xpath = "//div[@class='fp-signup-selector active']//a[contains(text(),'Personal')]")
    WebElement registerpersonal ;

    @FindBy(xpath = "//input[@id='email']")
    WebElement registeremail ;

    @FindBy(xpath = "//input[@id='password']")
    WebElement registerpass;

    @FindBy(xpath = "//button[@class='v2-form__submit v2-button v2-button--primary']")
    WebElement registersave ;

     @FindBy(xpath = "//li[@class='v2-control-errors__item']")
     WebElement termserormsg ;

     @FindBy(xpath = "//label[@for='agreement']")
     WebElement termscheckbox ;

     @FindBy(xpath = "//input[@id='firstname']")
     WebElement firstname;

     @FindBy(xpath = "//input[@id='lastname']")
     WebElement lastname ;

     @FindBy(xpath = "//input[@placeholder='_ _ - _ _ _ - _ _ - _ _']")
     WebElement phonenumber ;

     @FindBy(xpath = "//select[@name='phoneCountryCode']")
     WebElement countrycode ;

     @FindBy(xpath = "//select[@ng-model='vm.newUserBirthday.month']")
     WebElement month ;

     @FindBy(xpath = "//select[@ng-model='vm.newUserBirthday.day']")
     WebElement day;

     @FindBy(xpath = "//select[@ng-model='vm.newUserBirthday.year']")
     WebElement year ;

     @FindBy(xpath = "//select[@id='country']")
     WebElement country ;

     @FindBy(xpath = "//input[@id='city']")
     WebElement city ;

     @FindBy(xpath = "//input[@id='address']")
     WebElement address ;

     @FindBy(xpath = "//input[@id='zip']")
     WebElement zipcode ;

     @FindBy(xpath = "//div[@id='step-2']//button[@class='v2-form__submit v2-button v2-button--primary']")
     WebElement createbtn ;

    public void clickonsignup(){
        signbtn.click();
    }
    public boolean registerpopupIsDisplayed(){
        return registerpopup.isDisplayed();
    }
    public void clickonpersonal(){
        registerpersonal.click();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
    public boolean titleIsDisplayed(){
        return registertitle.isDisplayed();
    }

    public void doregister() {
        registeremail.sendKeys("jmtqzqet5@tmpmail.org");
        registerpass.sendKeys(prop.getProperty("password"));
        termscheckbox.click();
        registersave.click();
    }
    public void doregister2(){
       phonenumber.sendKeys("1012756084");
       firstname.sendKeys(prop.getProperty("firstname"));
       lastname.sendKeys(prop.getProperty("lastname"));
       city.sendKeys("cairo");
       address.sendKeys("cairo");
       zipcode.sendKeys(prop.getProperty("zipcode"));
    }
    public void selectcountrycode(){
        Select countryvalue = new Select(countrycode);
        countryvalue.selectByVisibleText("+20");

    }
    public void selectmonth(){
        Select monthvalue = new Select(month);
        monthvalue.selectByVisibleText("September");
    }
    public void selectday(){
        Select dayvalue = new Select(day);
        dayvalue.selectByVisibleText("6");
    }
    public void selectyear(){
        Select yearvalue = new Select(year);
        yearvalue.selectByVisibleText("1900");
    }

    public void selectcountry(){
        Select countryvalue = new Select(country);
        countryvalue.selectByVisibleText("Egypt");
}
     public boolean termerormsgIsDisplayed(){
        return termserormsg.isDisplayed();
}
public String clickoncreate(){
        createbtn.click();
        return prop.getProperty("profileURL");
}
}
