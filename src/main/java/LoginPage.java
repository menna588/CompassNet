
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {
    public LoginPage() throws IOException {

        PageFactory.initElements(driver, this);
 }
    @FindBy(xpath = "//a[@class='header-btn header-btn-transparent toggle-login']")
    WebElement loginbtn ;

    @FindBy(xpath = "//div[@class='fp-login-selector active']//div[@class='links']")
    WebElement loginpopup ;

    @FindBy(xpath = "//a[contains(text(),'Personal')]")
    WebElement loginpersonal ;

    @FindBy(xpath = "//div[@class='fp-login-selector active']//a[contains(text(),'Business')]")
    WebElement businessbtn ;

    @FindBy(xpath = "//div[@class='fp-login-selector active']//div[@class='close-btn']")
    WebElement popupcancel;

    @FindBy(xpath = "//div[@class='v2-form__title']")
    WebElement logintitle ;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email ;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password ;

    @FindBy(xpath = "//button[@class='v2-form__submit v2-button v2-button--primary']")
    WebElement loginbutton ;

    @FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
    WebElement forgetmypassword;

    @FindBy(xpath = "//span[contains(text(),'Show')]")
    WebElement showbtn ;

    @FindBy(xpath = "//b[@class='ng-binding']")
    WebElement usericon ;

    @FindBy(xpath = "//span[contains(text(),'Password is invalid.')]")
    WebElement passerormsg ;

    @FindBy(xpath = "//span[contains(text(),'User not found.')]")
    WebElement emailerormsg ;

    public void clickonlogin(){

    loginbtn.click();
}
    public boolean popupIsDisplayed(){

    return   loginpopup.isDisplayed();
}
    public void clickonpersonal(){
    loginpersonal.click();
}
    public String getURL(){

        return driver.getCurrentUrl();
}
     public boolean titleIsDisplayed(){

        return  logintitle.isDisplayed();
}
      public String dologin(){
    email.sendKeys(prop.getProperty("email"));
    password.sendKeys(prop.getProperty("password"));
    loginbutton.click();

    return prop.getProperty("profileURL");
}
    public boolean usericonIsDisplayed(){
    return usericon.isDisplayed();

}
   public void doinvalidpass(){
    email.sendKeys(prop.getProperty("email"));
    password.sendKeys("123456");
    loginbutton.click();

}
    public boolean passerormsgIsDisplayed(){

        return  passerormsg.isDisplayed();
}
    public void doinvalidemail(){
        email.sendKeys("menna@mail.com");
        password.sendKeys("123456");
        showbtn.click();
        loginbutton.click();

    }
    public boolean emailerormsgIsDisplayed(){

        return  emailerormsg.isDisplayed();
    }

}
