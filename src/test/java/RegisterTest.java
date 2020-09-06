import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class RegisterTest extends TestBase {
    public RegisterTest() throws IOException {
        super();
    }
    RegisterPage registerPage ;
    LoginPage loginPage ;
    SoftAssert softassert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        initialization(prop.getProperty("homeURL"));
        registerPage = new RegisterPage();
        loginPage = new LoginPage();

        registerPage.clickonsignup();
        softassert.assertTrue(registerPage.registerpopupIsDisplayed(), "popup is appear choose an acoount type");
        registerPage.clickonpersonal();
        String actualresult =  registerPage.getURL();
        driver.navigate().to(actualresult);
        softassert.assertTrue(registerPage.titleIsDisplayed(), "title is displayed");

    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @Test(priority = 1)
    public void test(){
       registerPage.doregister();
       String  actualresult = driver.getCurrentUrl();
       driver.navigate().to(actualresult);
       registerPage.doregister2();
       registerPage.selectcountrycode();
       registerPage.selectcountry();
       registerPage.selectday();
       registerPage.selectmonth();
       registerPage.selectyear();
       registerPage.clickoncreate();
      softassert.assertTrue(loginPage.usericonIsDisplayed(),"user icon is displayed");
    }
}
