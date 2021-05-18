package lesson7.homework.hwpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HwLoginPage extends HwBaseView{

    @FindBy(id = "btn_login")
    public WebElement hwButtonClickLogin;

    @FindBy(xpath = "//*[@id=\"auth_from\"]/fieldset/ul/li[1]/div[2]/div/input")
    public WebElement hwInputLogin;

    @FindBy(xpath = "//*[@id=\"auth_from\"]/fieldset/ul/li[1]/div[2]/div/div[1]/input")
    public WebElement hwInputPassword;

    @FindBy(xpath = "//*[@id=\"auth_from\"]/fieldset/input[3]")
    public WebElement hwButtonClickEntrance;

    public HwLoginPage(WebDriver driver) {
        super(driver);
    }
}
