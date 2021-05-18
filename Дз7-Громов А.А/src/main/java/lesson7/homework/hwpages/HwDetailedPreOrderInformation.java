package lesson7.homework.hwpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwDetailedPreOrderInformation extends HwBaseView{

    @FindBy(xpath = "//*[@id=\"bx-dynamic-user-options\"]/div[1]/div/ul/li[2]/a")
    public WebElement hwOpenPreOrder;

    @FindBy(xpath = "//*[@id=\"tab4\"]/section/div/ul/li/div/div/div[1]/div/div/span/span[1]")
    public WebElement hwOpenMoreInformation;

//    @FindBy(xpath = "//html//body//div[13]//div//div//a[@title='Close']")
//    public WebElement hwCloseMoreInformation;
//    К сожалению, не получается и тут корректно закрыть подробную информацию о предзаказе.

    public HwDetailedPreOrderInformation(WebDriver driver) {
        super(driver);
    }

}
