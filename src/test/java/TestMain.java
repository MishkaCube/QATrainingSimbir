import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestMain {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    String login = "test.simbir.valeev";
    String passwd = "ks007410";
    @BeforeClass
    public static void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mishka\\chromedriver.exe");
        ChromeOptions caps = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.ru/?uid=1555275419#tabs/relevant");
    }
    @Test
    @Step("Main test")
    @Description("Main testing")
    public void testTesting() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.buttonClick();
        loginPage.inputLogin(login);
        loginPage.entryButtonClick();
        Thread.sleep(10);
        loginPage.inputPasswd(passwd);
        loginPage.entryButtonClick();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        profilePage.findMessage();
        //System.out.println("Найдено сообщение");
        profilePage.buttonSendClick();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        profilePage.inputName("test.simbir.valeev@yandex.ru");
        profilePage.inputTheme("Simbirsoft theme");
        profilePage.inputMessage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2);
        profilePage.outButtonClick();
    }
    @AfterClass
    public static void ShutDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }
}