package lesson5.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.FileAssert;
import org.testng.annotations.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class HwAllTestsForMyFavoriteSite {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://www.1c-interes.ru/";

    @BeforeSuite
    void setupDataBase() {
        System.out.println("Before suite setup database");
    }

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(BASE_URL);
        driver.manage().window().setSize(new Dimension(1920, 1040));
        login();
    }

    @Test
    void AllTestsForMyFavoriteSite() throws InterruptedException {

        webDriverWait.until(driver -> driver.findElement(
                By.xpath("//*[@id=\"user_menu\"]/span")).getText().equals("rynerlute1989@inbox.ru"));
//        К сожалению, тут у меня не получилось сделать проверку через assert.
//        Пытался сделать на подобии урока в классе ActionsExamplesTest.
//        Поэтому сделал просто по ожиданию отображения корректного логина.
//        Также, ожидание пришлось делать из-за того, что при начале теста у меня вход в личный кабинет
//        пересекаося с добавлением товара в избранное, посему в итоге выходила ошибка.

//        Добавление товара в избранные и проверка раздела избранные.
        driver.findElement(By.xpath("//*[@id=\"title-search-input\"]")).sendKeys(
                "Vampire: The Masquerade – Bloodlines 2");
        driver.findElement(By.xpath("//*[@id=\"title-search\"]/input[2]")).click();
        Thread.sleep(3000);
//        Что-то у меня тут не получился поставить правильный wait на то, чтобы дождаться, когда откроется страница
//        по запрошенной информации
//        https://www.1c-interes.ru/search/?q=%56%61%6D%70%69%72%65%3A%20%54%68%65%20%4D%61%73%71%75%65%72%61%64%65%20%96%20%42%6C%6F%6F%64%6C%69%6E%65%73%20%32
        driver.findElement(By.xpath("//*[@id=\"root_picture_carousel\"]/div[1]/div/div/div[3]/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"base\"]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();
//        driver.get("https://www.1c-interes.ru/personal/#favorites");
        Thread.sleep(3000);
//        С правильными wait-ами нужно будет тоже ещё попрактиковаться.
//        Я понял их суть, но нужно больше практики.
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(driver.findElement(By.xpath("//*[@id=\"user_menu\"]/span")))
                .build()
                .perform();
        driver.findElement(By.xpath("//*[@id=\"bx-dynamic-user-options\"]/div[1]/div/ul/li[4]/a")).click();

        Thread.sleep(3000);
        driver.get("https://www.1c-interes.ru/");
        Thread.sleep(3000);

//        Добавление товара в корзину и удаление его из корзины.
        driver.findElement(By.xpath("//*[@id=\"title-search-input\"]")).sendKeys(
                "Фигурка Witcher 3: Wild Hunt – Geralt Grandmaster Feline (27 см)");
        driver.findElement(By.xpath("//*[@id=\"title-search\"]/input[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root_picture_carousel\"]/div/div/div/div[4]/div[4]/a/span")).click();
        Thread.sleep(3000);
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(driver.findElement(By.xpath("//*[@id=\"num_prod\"]")))
                .build()
                .perform();
        driver.findElement(By.xpath("//*[@id=\"basket_drop\"]/div/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/section/table/tbody/tr/td[8]/a[2]/i")).click();
//        В качестве проверки тут можно было реализовать проверку id="num_prod", чтобы так было слово "пуста".

        Thread.sleep(3000);
        driver.get("https://www.1c-interes.ru/");
        Thread.sleep(3000);

//        Проверка раздела предзаказов, подробное описание заказа и закрытие его.
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(driver.findElement(By.xpath("//*[@id=\"user_menu\"]/span")))
                .build()
                .perform();
        driver.findElement(By.xpath("//*[@id=\"bx-dynamic-user-options\"]/div[1]/div/ul/li[2]/a")).click();
//        Пытался найти более приятный путь, но не получилось. Над этим нужно будет поработать.

        driver.findElement(By.xpath("//*[@id=\"tab4\"]/section/div/ul/li/div/div/div[1]/div/div/span/span[1]")).click();
        Thread.sleep(3000);

//        К сожалению, дальше у меня не получается закрыть подробную информацию по предзаказу.
//        driver.findElement(By.xpath("//html//body//div[13]//div//div//a[@title='Close']")).click();
//        Actions actions3 = new Actions(driver);
//        actions3.moveToElement(driver.findElement(By.xpath("//a[@title='Close']")))
//                .build()
//                .perform();
//        driver.findElement(By.xpath("//a[@title=\"Close\")).click();

        Thread.sleep(3000);
        driver.get("https://www.1c-interes.ru/");

        Thread.sleep(5000);
        driver.quit();

    }

    private void login() {
        driver.get(BASE_URL);
        driver.findElement(By.id("btn_login")).click();
        driver.findElement(By.xpath("//*[@id=\"auth_from\"]/fieldset/ul/li[1]/div[2]/div/input")).sendKeys("rynerlute1989@inbox.ru");
        driver.findElement(By.xpath("//*[@id=\"auth_from\"]/fieldset/ul/li[1]/div[2]/div/div[1]/input")).sendKeys("test123test");
        driver.findElement(By.xpath("//*[@id=\"auth_from\"]/fieldset/input[3]")).click();
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

}
