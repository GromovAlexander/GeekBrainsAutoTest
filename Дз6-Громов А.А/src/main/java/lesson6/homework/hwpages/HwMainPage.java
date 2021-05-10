package lesson6.homework.hwpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwMainPage extends HwBaseView{

    @FindBy(xpath = "//*[@id=\"user_menu\"]/span")
    public WebElement hwLoginVerification;

    public HwMainPage(WebDriver driver) {
        super(driver);
    }

}
