import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage
{
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class=\"mail-ComposeButton js-main-action-compose\"]")
    private WebElement SendButton;

    @FindBy(xpath = "//div[@class=\"composeYabbles\"]")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement recipientField;

    @FindBy(xpath = "//div[@role=\"textbox\"]")
    private WebElement messageBox;

    @FindBy(xpath = "//button[@class=\"Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l\"]")
    private WebElement OutButton;

    private int k = 0;
    @Step("Finding message")
    public void findMessage() {
        List<WebElement> list_letters = driver.findElements(By.xpath("//span[text()='Simbirsoft theme']"));
        for (int i = 0; i < list_letters.size(); i++)
        {
            if (list_letters.get(i).getText().equals("Simbirsoft theme")) {
                k+=1;
            }
        }
        System.out.println("Количество писем - " + k);
    }
    public void buttonSendClick()
    {
        SendButton.click();
    }

    @Step("Input name")
    public void inputName(String name)
    {
        nameField.sendKeys(name);
    }

    @Step("Input Letter Theme")
    public void inputTheme(String theme)
    {
        recipientField.sendKeys(theme);
    }

    @Step ("Input our message")
    public void inputMessage()
    {
        messageBox.sendKeys("Количество найденных писем - " + k);
    }

    @Step ("Click out button")
    public void outButtonClick()
    {
        OutButton.click();
    }
}
