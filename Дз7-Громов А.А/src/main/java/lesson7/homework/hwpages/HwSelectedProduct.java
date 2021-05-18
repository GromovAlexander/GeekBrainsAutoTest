package lesson7.homework.hwpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwSelectedProduct extends HwBaseView{

    @FindBy(xpath = "//*[@id=\"title-search-input\"]")
    public WebElement hwProductSearchForFavorites;

    @FindBy(xpath = "//*[@id=\"title-search\"]/input[2]")
    public WebElement hwButtonClickForEarch;

    @FindBy(xpath = "//*[@id=\"root_picture_carousel\"]/div[1]/div/div/div[3]/a/img")
    public WebElement hwButtonClickForOpenProduct;

    @FindBy(xpath = "//*[@id=\"base\"]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/button")
    public WebElement hwButtonClickForFavorite;

    @FindBy(xpath = "//*[@id=\"bx-dynamic-user-options\"]/div[1]/div/ul/li[4]/a")
    public WebElement hwAssertFavoriteList;

    public HwSelectedProduct(WebDriver driver) {
        super(driver);
    }

}
