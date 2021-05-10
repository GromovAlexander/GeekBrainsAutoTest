package lesson6.homework.hwpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwAddItemToBasketAndRemove extends HwBaseView{

    @FindBy(xpath = "//*[@id=\"title-search-input\"]")
    public WebElement hwProductSearchForBuy;

    @FindBy(xpath = "//*[@id=\"title-search\"]/input[2]")
    public WebElement hwButtonClickForEarchToBuy;

    @FindBy(xpath = "//*[@id=\"root_picture_carousel\"]/div/div/div/div[4]/div[4]/a/span")
    public WebElement hwSelectProductForBuy;

    @FindBy(xpath = "//*[@id=\"basket_drop\"]/div/div/a/span")
    public WebElement hwRemoveProduct;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/section/table/tbody/tr/td[8]/a[2]/i")
    public WebElement hwRemoveProductFinishe;

    public HwAddItemToBasketAndRemove(WebDriver driver) {
        super(driver);
    }

}
