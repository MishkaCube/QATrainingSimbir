import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    ////span[text()="Войти"]
    //*[@id="index-page-container"]/div/div[2]/div/div/div[4]/a[2]
    @FindBy(xpath = "//a[@class=\"control button2 button2_view_classic button2_size_mail-big" +
            " button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow\"]")

    private WebElement btn;
    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    WebElement entryButton;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    WebElement passwdField;

    @Step
    public void buttonClick()
    {
        btn.click();
    }

    @Step
    public void entryButtonClick()
    {
        entryButton.click();
    }

    @Step
    public void inputLogin(String keys)
    {
        loginField.sendKeys(keys);
    }

    @Step
    public void inputPasswd(String keys)
    {
        passwdField.sendKeys(keys);
    }
}
