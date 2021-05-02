package lesson3.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HwTestLoginTo1cInteres {

    private static WebDriver driver;
    private static final String BASE_URL = "https://www.1c-interes.ru/";
    private WebDriver driver1;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1040));
        login();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"title-search-input\"]")).sendKeys("Vampire: The Masquerade – Bloodlines 2");
        driver.findElement(By.xpath("//*[@id=\"title-search\"]/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root_picture_carousel\"]/div[1]/div/div/div[3]/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"base\"]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();
        driver.get("https://www.1c-interes.ru/personal/#favorites");

        Thread.sleep(5000);
        driver.quit();

    }

    private static void login() {
        driver.get(BASE_URL);
        driver.findElement(By.id("btn_login")).click();
        driver.findElement(By.xpath("//*[@id=\"auth_from\"]/fieldset/ul/li[1]/div[2]/div/input")).sendKeys("rynerlute1989@inbox.ru");
        driver.findElement(By.xpath("//*[@id=\"auth_from\"]/fieldset/ul/li[1]/div[2]/div/div[1]/input")).sendKeys("test123test");
        driver.findElement(By.xpath("//*[@id=\"auth_from\"]/fieldset/input[3]")).click();
    }

}
