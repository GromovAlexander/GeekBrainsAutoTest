package lesson7.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson7.homework.hwpages.HwLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HwBaseTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    HwLoginPage hwLoginPage;

    @BeforeAll
    static void befotALl() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void hwSetupBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        hwLoginPage = new HwLoginPage(driver);
    }

    @AfterEach
    void hwTearDown() throws InterruptedException {
        Thread.sleep(5000);
//        Решил поставить тут ожидания, так как слишком быстро происходит закрытие
        driver.quit();
    }

}
