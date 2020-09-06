import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginTest extends TestBase {
    public LoginTest() throws IOException {
        super();
    }
    LoginPage loginpage ;
    SoftAssert softassert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        initialization(prop.getProperty("homeURL"));
        loginpage = new LoginPage();

        loginpage.clickonlogin();
        loginpage.popupIsDisplayed();
        loginpage.clickonpersonal();
        String actualresult = loginpage.getURL();
        driver.navigate().to(actualresult);
        softassert.assertTrue(loginpage.titleIsDisplayed(),"title is display");

    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @Test(priority = 1)
    public void loginvalid(){
      loginpage.dologin();
        softassert.assertTrue(loginpage.usericonIsDisplayed(),"you're login successfully");

    }
    @Test(priority = 2)
    public void logininvalidpass(){
        loginpage.doinvalidpass();
        softassert.assertTrue(loginpage.passerormsgIsDisplayed(), "password error message is appear");
    }
    @Test(priority = 3)
    public void logininvalidemail(){
        loginpage.doinvalidemail();
        softassert.assertTrue(loginpage.emailerormsgIsDisplayed(), "email error message is appear");
    }

}
