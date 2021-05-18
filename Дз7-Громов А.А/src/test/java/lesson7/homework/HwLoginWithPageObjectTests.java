package lesson7.homework;

import io.qameta.allure.Feature;
import lesson7.homework.hwpages.HwAddItemToBasketAndRemove;
import lesson7.homework.hwpages.HwDetailedPreOrderInformation;
import lesson7.homework.hwpages.HwMainPage;
import lesson7.homework.hwpages.HwSelectedProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import static lesson7.homework.HwConfiguration.BASE_URL;

@Feature("Тестирование моего любимого сайта")
public class HwLoginWithPageObjectTests extends HwBaseTest{

    @BeforeEach
    public void hwGoToPage() {
        driver.get(BASE_URL);
        driver.manage().window().setSize(new Dimension(1920, 1040));
    }

    @Test
    void hwLoginTest() throws InterruptedException {
        hwLoginPage.hwButtonClickLogin.click();
        hwLoginPage.hwInputLogin.sendKeys("rynerlute1989@inbox.ru");
        hwLoginPage.hwInputPassword.sendKeys("test123test");
        hwLoginPage.hwButtonClickEntrance.click();
    }

//    @Test
//    void HwMainPageTest() {
//        hwLoginTest();
//        new HwMainPage(driver).hwLoginVerification.getText().equals("rynerlute1989@inbox.ru");
//    }
//    К сожалению, не смог понять почему у меня тут не проверяет имя логина.

    @Test
    void HwSelectedProductTest() throws InterruptedException {
        hwLoginTest();
        Thread.sleep(3000);
        new HwSelectedProduct(driver).hwProductSearchForFavorites.sendKeys("Vampire: The Masquerade – Bloodlines 2");
        new HwSelectedProduct(driver).hwButtonClickForEarch.click();
        Thread.sleep(3000);
//        Понимаю, что тут нужно правильный wait сделать, но, к сожалению, у меня не получилось его правильно написать.
        new HwSelectedProduct(driver).hwButtonClickForOpenProduct.click();
        new HwSelectedProduct(driver).hwButtonClickForFavorite.click();
        Thread.sleep(3000);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(driver.findElement(By.xpath("//*[@id=\"user_menu\"]/span")))
                .build()
                .perform();
        new HwSelectedProduct(driver).hwAssertFavoriteList.click();
    }

    @Test
    void HwAddItemToBasketAndRemoveTest() throws InterruptedException {
        hwLoginTest();
        Thread.sleep(3000);
        new HwAddItemToBasketAndRemove(driver).hwProductSearchForBuy.sendKeys(
                "Фигурка Witcher 3: Wild Hunt – Geralt Grandmaster Feline (27 см)");
        new HwAddItemToBasketAndRemove(driver).hwButtonClickForEarchToBuy.click();
        Thread.sleep(3000);
        new HwAddItemToBasketAndRemove(driver).hwSelectProductForBuy.click();
        Thread.sleep(3000);
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(driver.findElement(By.xpath("//*[@id=\"num_prod\"]")))
                .build()
                .perform();
        new HwAddItemToBasketAndRemove(driver).hwRemoveProduct.click();
        new HwAddItemToBasketAndRemove(driver).hwRemoveProductFinishe.click();
    }

    @Test
    void HwDetailedPreOrderInformationTest() throws InterruptedException {
        hwLoginTest();
        Thread.sleep(3000);
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(driver.findElement(By.xpath("//*[@id=\"user_menu\"]/span")))
                .build()
                .perform();
        new HwDetailedPreOrderInformation(driver).hwOpenPreOrder.click();
        new HwDetailedPreOrderInformation(driver).hwOpenMoreInformation.click();
//        new HwDetailedPreOrderInformation(driver).hwCloseMoreInformation.click();
//    К сожалению, не получается и тут корректно закрыть подробную информацию о предзаказе.
    }
}
